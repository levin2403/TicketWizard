/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author skevi
 */
public class Persona_Boleto {
    
    private int id;
    private Persona persona;
    private Boleto boleto;
    private Date fecha_adquisicion;

    public Persona_Boleto() {
    }

    public Persona_Boleto(Persona persona, Boleto boleto, 
            Date fecha_adquisicion) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public Persona_Boleto(int id, Persona persona, Boleto boleto, 
            Date fecha_adquisicion) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }
    
}
