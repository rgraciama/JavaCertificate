/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A.lambda;

/**
 *
 * @author Rulo
 */
public class Scopes {
    
    private static double atributo1;
    private double atributo2;
    
    public double probarLocalVariable() {

        final double n3 = 3;
        Operacion op = new Operacion (){
            @Override
            public double calcular(double n1, double n2) {
                
                return n1 + n2 + n3;
            }
        
        };
        
        
        Operacion operacion = (x,y) -> {
            atributo1 = x+y;
            atributo2 = atributo1;
            return atributo2;
        };
        return op.calcular(1, 1);
    }
    
    public double probarAtributosStaticVariables() {
        return 0.0;
    }
    
    public static void main (String[] args) {
        Scopes app = new Scopes();
        System.out.println(app.probarLocalVariable());
    }
}
