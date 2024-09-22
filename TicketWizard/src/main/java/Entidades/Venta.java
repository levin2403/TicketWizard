/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class Venta {
    
    private int id;
    private Persona persona;
    private Boleto boleto;
    private BigDecimal precio_reventa;
    private Date fecha_limite;

    public Venta() {
    }

    public Venta(Persona cliente, Boleto boleto, BigDecimal precio_reventa, 
            Date fecha_limite) {
        this.persona = cliente;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    public Venta(int id, Persona persona, Boleto boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
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

    public void setPersona(Persona cliente) {
        this.persona = cliente;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public BigDecimal getPrecio_reventa() {
        return precio_reventa;
    }

    public void setPrecio_reventa(BigDecimal precio_reventa) {
        this.precio_reventa = precio_reventa;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
    
}
