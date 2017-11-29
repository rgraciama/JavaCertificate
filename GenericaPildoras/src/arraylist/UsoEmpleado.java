/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.*;

/**
 *
 * @author Rulo
 */
public class UsoEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Empleado listaEmpleados[] = new Empleado[3];
        
        listaEmpleados[0] = new Empleado("Ana", 45 , 2500);
        listaEmpleados[1] = new Empleado("Antonio", 55 , 2000);
        listaEmpleados[2] = new Empleado("Maria", 25 , 2600);*/

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        //listaEmpleados.ensureCapacity(11);
        
        System.out.println("Tamaño: "+listaEmpleados.size());
        
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));

        System.out.println("Tamaño: "+listaEmpleados.size());
        
        listaEmpleados.add(new Empleado("Pedro", 22, 2500));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        
        listaEmpleados.set(1, new Empleado("Olga", 22, 2200));
        
        System.out.println(listaEmpleados.get(4).dameDatos());

        System.out.println("Tamaño: "+listaEmpleados.size());
        
        //listaEmpleados.trimToSize();
        
        /*for (Empleado e : listaEmpleados) {
            System.out.println(e.dameDatos());
        }*/
        
        Iterator<Empleado> mi_iterador = listaEmpleados.iterator();
        
        while(mi_iterador.hasNext()) {
            System.out.println(mi_iterador.next().dameDatos());
        }
        
        /*for (int i = 0; i<listaEmpleados.size(); i++){
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.dameDatos());
        }*/
        
        /*Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
        
        listaEmpleados.toArray(arrayEmpleados);
        
        for (int i = 0; i < arrayEmpleados.length; i++) {
            System.out.println(arrayEmpleados[i].dameDatos());
        }*/
    }

}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {

        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años."
                + " Y un salario de " + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
