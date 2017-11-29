/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.io.*;
/**
 *
 * @author Rulo
 */
public class UsoArrayList {
    public static void main(String[] args) {
        ArrayList2 archivos = new ArrayList2(5);
        
        archivos.add("Juan");
        archivos.add("Maria");
        archivos.add("Ana");
        archivos.add("Sandra");
        archivos.add(new File("gestion_pedidos.accdb"));
        
        
        String nombrePersona = (String) archivos.get(4);
        
        
        System.out.println(nombrePersona);
    }
}
