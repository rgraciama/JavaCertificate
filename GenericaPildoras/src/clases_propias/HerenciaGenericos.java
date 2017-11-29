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
public class HerenciaGenericos {
    /*Empleado Administrativa = new Empleado("Elena", 45, 1500);
    
    Jefe DirectoraComercial = new Jefe("Ana", 27, 3500);
    
    Empleado nuevoEmpleado = DirectoraComercial;*/
    
    Pareja<Empleado> Administrativa = new Pareja<Empleado>();
    Pareja<Jefe> DirectoraComercia = new Pareja<Jefe>();
    
    //¿POR QUE NO?
    //Pareja<Empleado> nuevoEmpleado = DirectoraComercial;
    /*Pareja*/
}
