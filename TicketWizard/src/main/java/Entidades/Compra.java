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
public class Compra {
    
    private int id;
    private Persona personaDTO;
    private Boleto boletoDTO;
    private String id_transaccion;
    private Date fecha_compra; 
    private Time hora_compra;
    private Tipo_compra tipo_compra;
    private BigDecimal monto;

    public Compra() {
    }

    public Compra(Persona personaDTO, Boleto boletoDTO, String id_transaccion, 
            Date fecha_compra, Time hora_compra, Tipo_compra tipo_compra, 
            BigDecimal monto) {
        this.personaDTO = personaDTO;
        this.boletoDTO = boletoDTO;
        this.id_transaccion = id_transaccion;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
        this.monto = monto;
    }

    public Compra(int id, Persona personaDTO, Boleto boletoDTO, 
            String id_transaccion, Date fecha_compra, Time hora_compra, 
            Tipo_compra tipo_compra, BigDecimal monto) {
        this.id = id;
        this.personaDTO = personaDTO;
        this.boletoDTO = boletoDTO;
        this.id_transaccion = id_transaccion;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(Persona personaDTO) {
        this.personaDTO = personaDTO;
    }

    public Boleto getBoletoDTO() {
        return boletoDTO;
    }

    public void setBoletoDTO(Boleto boletoDTO) {
        this.boletoDTO = boletoDTO;
    }

    public String getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(String id_transaccion) {
        this.id_transaccion = id_transaccion;
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

    public Tipo_compra getTipo_compra() {
        return tipo_compra;
    }

    public void setTipo_compra(Tipo_compra tipo_compra) {
        this.tipo_compra = tipo_compra;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
}
