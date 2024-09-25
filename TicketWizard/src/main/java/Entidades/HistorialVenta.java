/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class HistorialVenta {
    
    private int id;
    private Persona vendedor;
    private Persona comprador;
    private Boleto boleto;
    private BigDecimal precio_venta;
    private Date fecha_venta;
    private Time hora_venta;

    public HistorialVenta() {
    }

    public HistorialVenta(Persona vendedor, Persona comprador, Boleto boleto, 
            BigDecimal precio_venta, Date fecha_venta, Time hora_venta) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    public HistorialVenta(int id, Persona vendedor, Persona comprador, 
            Boleto boleto, BigDecimal precio_venta, Date fecha_venta, 
            Time hora_venta) {
        this.id = id;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public Persona getComprador() {
        return comprador;
    }

    public void setComprador(Persona comprador) {
        this.comprador = comprador;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Time getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    @Override
    public String toString() {
        return "HistorialVenta{" + "id=" + id + ", vendedor=" + vendedor + 
                ", comprador=" + comprador + ", boleto=" + boleto + 
                ", precio_venta=" + precio_venta + ", fecha_venta=" + 
                fecha_venta + ", hora_venta=" + hora_venta + '}';
    }
    
}
