package socketspildoras;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;

public class Cliente {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco = new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);
        
        addWindowListener(new EnvioOnline());
    }

}

//------------ENVIO SEÑAL ONLINE---------------
class EnvioOnline extends WindowAdapter {
    
    @Override
    public void windowOpened(WindowEvent e) {
        try{
            Socket misocket = new Socket("192.168.1.40",9999);
            PaqueteEnvio datos = new PaqueteEnvio();
            datos.setMensaje(" online");
            ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
            
            paquete_datos.writeObject(datos);
            
            misocket.close();
        } catch (Exception e2) {
            
        }
    }
}

class LaminaMarcoCliente extends JPanel implements Runnable {

    private JTextField campo1;
    private JComboBox ip;
    private JLabel nick;
    private JTextArea campochat;
    private JButton miboton;

    public LaminaMarcoCliente() {

        String nick_usuario = JOptionPane.showInputDialog("Nick: ");
        
        JLabel n_nick = new JLabel("Nick: ");
        
        nick = new JLabel();
        nick.setText(nick_usuario);
        
        add(n_nick);
        add(nick);
        
        JLabel texto = new JLabel("Online: ");
        add(texto);

        ip = new JComboBox();
        
        add(ip);
        
        campochat=new JTextArea(12,20);
        add(campochat);
        
        campo1 = new JTextField(20);
        add(campo1);

        miboton = new JButton("Enviar");
        EnviaTexto mievento = new EnviaTexto();

        miboton.addActionListener(mievento);
        add(miboton);
        
        Thread mihilo = new Thread(this);
        mihilo.start();

    }

    @Override
    public void run() {
        try {
            ServerSocket servidor_cliente = new ServerSocket(9090);
            
            Socket cliente;
            
            PaqueteEnvio paqueteRecibido;
            
            while (true) {
                
                cliente = servidor_cliente.accept();
                ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido= (PaqueteEnvio) flujoentrada.readObject();
                if (!paqueteRecibido.getMensaje().equals(" online")) {
                    campochat.append("\n"+paqueteRecibido.getNick()+ ": "+paqueteRecibido.getMensaje());
                } else {
                    //campochat.append("\n"+paqueteRecibido.getIps());

                    ArrayList<String> IpsMenu = new ArrayList<String>();
                    IpsMenu = paqueteRecibido.getIps();
                    ip.removeAllItems();
                    for (String z : IpsMenu) {
                        ip.addItem(z);
                    }
                    
                }
            }
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            campochat.append("\n"+campo1.getText());
            
            try {
                //System.out.println(campo1.getText());

                Socket misocket = new Socket("192.168.1.40", 9999);
                
                PaqueteEnvio datos =  new PaqueteEnvio();
                
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());
                
                ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
                paquete_datos.writeObject(datos);
                paquete_datos.close(); //no se si se ha de cerrar?
                misocket.close();
                
                /*DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                flujo_salida.writeUTF(campo1.getText());
                flujo_salida.close();*/
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}


class PaqueteEnvio implements Serializable {

    private String nick;
    private String ip;
    private String mensaje;
    private ArrayList<String> Ips;
    
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the Ips
     */
    public ArrayList<String> getIps() {
        return Ips;
    }

    /**
     * @param Ips the Ips to set
     */
    public void setIps(ArrayList<String> Ips) {
        this.Ips = Ips;
    }
    

    
}