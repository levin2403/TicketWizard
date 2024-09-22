/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class VentaDTO {
    
    private String id;
    private PersonaDTO persona;
    private BoletoDTO boleto;
    private BigDecimal precio_reventa;
    private Date fecha_limite;

    public VentaDTO() {
    }

    public VentaDTO(PersonaDTO persona, BoletoDTO boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    public VentaDTO(String id, PersonaDTO persona, BoletoDTO boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO cliente) {
        this.persona = cliente;
    }

    public BoletoDTO getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoDTO boleto) {
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
