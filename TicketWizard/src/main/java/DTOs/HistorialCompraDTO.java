/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author skevi
 */
public class HistorialCompraDTO {
    
    private String id;
    private PersonaDTO persona; //persona que compro el boleto
    private BoletoDTO boleto; //boleto que fue comprado
    private Date fecha_compra;
    private Time hora_compra;
    private String tipo_compra;

    public HistorialCompraDTO() {
    }

    public HistorialCompraDTO(PersonaDTO persona, BoletoDTO boleto, 
            Date fecha_compra, Time hora_compra, String tipo_compra) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    public HistorialCompraDTO(String id, PersonaDTO persona, BoletoDTO boleto, 
            Date fecha_compra, Time hora_compra, String tipo_compra) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
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

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public BoletoDTO getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoDTO boleto) {
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

    public String getTipo_compra() {
        return tipo_compra;
    }

    public void setTipo_compra(String tipo_compra) {
        this.tipo_compra = tipo_compra;
    }
             
}
