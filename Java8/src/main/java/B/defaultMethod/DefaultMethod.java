/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B.defaultMethod;

/**
 *
 * @author Rulo
 */
public class DefaultMethod implements PersonaA, PersonaB {
    public static void main (String[] args) {
        DefaultMethod app = new DefaultMethod();
        app.hablar();
        System.out.println("");
    }

    @Override
    public void hablar() {
        PersonaB.super.hablar(); 
    }

    @Override
    public void caminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
