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
    private Persona persona; //persona que compra el boleto
    private Boleto boleto; //boleto que esta en venta
    private BigDecimal precio_reventa;
    private Date fecha_limite;
    private String estado;

    public Venta() {
    }

    public Venta(Persona persona, Boleto boleto, BigDecimal precio_reventa, 
            Date fecha_limite, String estado) {
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
    }

    public Venta(int id, Persona persona, Boleto boleto, 
            BigDecimal precio_reventa, Date fecha_limite, String estado) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", persona=" + persona + ", boleto=" + 
                boleto + ", precio_reventa=" + precio_reventa + 
                ", fecha_limite=" + fecha_limite + ", estado=" + estado + '}';
    }
    
}
