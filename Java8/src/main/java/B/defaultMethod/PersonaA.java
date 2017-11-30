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
public interface PersonaA {
    public void caminar();
    default public void hablar() {
        System.out.println("hablar - PersonaB");
        
    }
}
