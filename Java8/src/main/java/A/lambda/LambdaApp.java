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
public class LambdaApp {
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
    public static void main (String[] args) {
        LambdaApp app = new LambdaApp();
        app.ordenar();
    }
}
