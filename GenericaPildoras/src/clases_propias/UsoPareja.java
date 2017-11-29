/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

/**
 *
 * @author Rulo
 */
public class UsoPareja {

    public static void main(String[] args) {
        Pareja<String> una = new Pareja<String>();

        una.setPrimero("Juan");

        System.out.println(una.getPrimero());

        Persona pers1 = new Persona("Ana");

        Pareja<Persona> otra = new Pareja<Persona>();
        
        otra.setPrimero(pers1);
        
        System.out.println(otra.getPrimero());
    }
}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString() {
        return nombre;
    }
}
