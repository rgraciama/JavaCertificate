package video1;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsoThreads {
    
   
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame marco = new MarcoRebote();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}

class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponente) {

        pelota = unaPelota;
        componente = unComponente;
    }

    @Override
    public void run() {
        
        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        //for (int i = 1; i <= 3000; i++) {
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mueve_pelota(componente.getBounds());

            componente.paint(componente.getGraphics());
          try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                
                System.out.println("Hilo bloqueado. Imposible su interrupcion");
                //Lgger.getLogger(MarcoRebote.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }

        }
        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
    }

}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota {

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites) {

        x += dx;

        y += dy;

        if (x < limites.getMinX()) {

            x = limites.getMinX();

            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {

            x = limites.getMaxX() - TAMX;

            dx = -dx;
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;

        }

    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape() {

        return new Ellipse2D.Double(x, y, TAMX, TAMY);

    }

    private static final int TAMX = 15;

    private static final int TAMY = 15;

    private double x = 0;

    private double y = 0;

    private double dx = 1;

    private double dy = 1;

}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel {

    //Añadimos pelota a la lámina
    public void add(Pelota b) {

        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Pelota b : pelotas) {

            g2.fill(b.getShape());
        }

    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    
    public MarcoRebote() {

        setBounds(600, 300, 400, 350);

        setTitle("Rebotes");

        lamina = new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Dale!", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                comienza_el_juego();
            }

        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                System.exit(0);

            }

        });

        ponerBoton(laminaBotones, "Detener", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                detener();

            }

        });
        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }
    
    

    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego() {

        Pelota pelota = new Pelota();

        lamina.add(pelota);

        Runnable r = new PelotaHilos(pelota, lamina);
        
        t = new Thread(r);
        
        t.start();

    }
    
    public void detener(){
        t.interrupt();
    }

Thread t;

}
