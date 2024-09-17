/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author skevi
 */
public class Persona {
    
    private int id;
    private String nombre;
    private String contraseña;
    private Date fechaNacimiento;
    private String correo;
    private int edad;
    private BigDecimal saldo;
    private Domicilio domicilio;
    private String generatedKey;

    public Persona() {
    }

    public Persona(String nombre, String contraseña, Date fechaNacimiento, 
            String correo, int edad, BigDecimal saldo, Domicilio domicilio, 
            String generatedKey) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.edad = edad;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.generatedKey = generatedKey;
    }

    public Persona(int id, String nombre, String contraseña, Date fechaNacimiento, 
            String correo, int edad, BigDecimal saldo, Domicilio domicilio, 
            String generatedKey) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.edad = edad;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.generatedKey = generatedKey;
    }
    
    
}
