/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author skevi
 */
public class HistorialCompra {
    
    private int id;
    private Persona persona; //persona que compro el boleto
    private Boleto boleto; //boleto que fue comprado
    private Date fecha_compra;
    private Time hora_compra;
    private Tipo_boleto tipo_compra;

    public HistorialCompra() {
    }

    public HistorialCompra(Persona persona, Boleto boleto, Date fecha_compra, 
            Time hora_compra, Tipo_boleto tipo_compra) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    public HistorialCompra(int id, Persona persona, Boleto boleto, 
            Date fecha_compra, Time hora_compra, Tipo_boleto tipo_compra) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
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

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Time getHora_compra() {
        return hora_compra;
    }

    public void setHora_compra(Time hora_compra) {
        this.hora_compra = hora_compra;
    }

    public Tipo_boleto getTipo_compra() {
        return tipo_compra;
    }

    public void setTipo_compra(Tipo_boleto tipo_compra) {
        this.tipo_compra = tipo_compra;
    }
    
}
