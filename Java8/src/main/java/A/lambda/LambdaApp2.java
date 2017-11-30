/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rulo
 */
public class LambdaApp2 {
    public void ordenar() {
        
        List<String> lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Code");
        lista.add("Mito");
        
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
        
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
    
    public void calcular() {
        
//        Operacion operacion = new Operacion() {
//            @Override
//            public double calcularPromedio(int n1, int n2) {
//                return (n1+n2)/2;
//            }
//            
//        };
//        
//        System.out.println(operacion.calcularPromedio(2, 3));

//          Operacion operacion = (double x, double y) -> (x+y)/2);
//          Operacion operacion = (double x, double y) -> { return (x+y)/2;};
//          Operacion operacion = (x, y) -> (x+y)/2;
          Operacion operacion = (x,y) -> 2;
          System.out.println(operacion.calcular(2,3));
    }
    public static void main (String[] args) {
        LambdaApp2 app = new LambdaApp2();
        app.ordenar();
        app.calcular();
    }
}
