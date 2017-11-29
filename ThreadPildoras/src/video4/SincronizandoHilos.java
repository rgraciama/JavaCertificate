/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rulo
 */
public class SincronizandoHilos {
    public static void main(String[] args) {
        
        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        hilo2.start();
        hilo1.start();
        
        System.out.println("Terminadas las tareas");
    }
}

class HilosVarios extends Thread {

    public void run(){
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo " + getName());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class HilosVarios2 extends Thread {

    private Thread hilo;
    
    public HilosVarios2(Thread hilo) {
        this.hilo = hilo;
        
    }
    
    public void run(){
        
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo " + getName());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}