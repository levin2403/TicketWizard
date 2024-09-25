/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class HistorialVentaDTO {
    
    private int id;
    private PersonaDTO vendedor;
    private PersonaDTO comprador;
    private BoletoDTO boleto;
    private BigDecimal precio_venta;
    private Date fecha_venta;
    private Time hora_venta;

    public HistorialVentaDTO() {
    }

    public HistorialVentaDTO(PersonaDTO vendedor, PersonaDTO comprador, 
            BoletoDTO boleto, BigDecimal precio_venta, Date fecha_venta, 
            Time hora_venta) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    public HistorialVentaDTO(int id, PersonaDTO vendedor, PersonaDTO comprador, 
            BoletoDTO boleto, BigDecimal precio_venta, Date fecha_venta, 
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

    public PersonaDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonaDTO vendedor) {
        this.vendedor = vendedor;
    }

    public PersonaDTO getComprador() {
        return comprador;
    }

    public void setComprador(PersonaDTO comprador) {
        this.comprador = comprador;
    }

    public BoletoDTO getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoDTO boleto) {
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
        return "HistorialVentaDTO{" + "id=" + id + ", vendedor=" + vendedor + 
                ", comprador=" + comprador + ", boleto=" + boleto + 
                ", precio_venta=" + precio_venta + ", fecha_venta=" + 
                fecha_venta + ", hora_venta=" + hora_venta + '}';
    }
    
}
