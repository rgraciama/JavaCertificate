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
    /*Empleado administrativa = new Empleado("Elena", 45, 1500);
    
    Jefe directoraComercial = new Jefe("Ana", 27, 3500);
    
    Empleado nuevoEmpleado = DirectoraComercial;*/
    
    Pareja<Empleado> administrativa = new Pareja<Empleado>();
    Pareja<Jefe> directoraComercia = new Pareja<Jefe>();
    
    //¿POR QUE NO?
    //Pareja<Empleado> nuevoEmpleado = directoraComercial;
    /*Pareja*/
}
