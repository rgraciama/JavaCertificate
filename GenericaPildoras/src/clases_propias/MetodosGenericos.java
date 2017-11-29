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
public class MetodosGenericos {
    public static void main(String[] args) {
        String nombres[] = {"Jose", "Maria", "Pepe"};
        
//        String elementos = MisMatrices.getElementos(nombres);
        
//        System.out.println(elementos);
        
        Empleado listaEmpleados[] = {new Empleado("Ana",45,2500),
                                     new Empleado("Ana",45,2500),
                                     new Empleado("Ana",45,2500),
                                     new Empleado("Ana",45,2500),
                                     new Empleado("Ana",45,2500)};
        
//        System.out.println(MisMatrices.getElementos(listaEmpleados ));
        System.out.println(listaEmpleados);
        System.out.println(MisMatrices.getMenor(nombres));
    }
}

class MisMatrices {
    public static <T extends Comparable> T getMenor(T[]a) {
        if (a==null || a.length == 0) {
            return null;
        }
        T elementoMenor = a[0];
        
        for (int i = 1; i < a.length; i++) {
            
            if (elementoMenor.compareTo(a[i])>0){
                elementoMenor=a[i];
            }
        }
        
        return elementoMenor;
    }
}
