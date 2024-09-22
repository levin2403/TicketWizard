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
public class CompraDTO {
    
    private String id;
    private PersonaDTO personaDTO;
    private BoletoDTO boletoDTO;
    private String id_transaccion;
    private Date fecha_compra; 
    private Time hora_compra;
    private String tipo_compra;
    private BigDecimal monto;

    public CompraDTO() {
    }

    public CompraDTO(PersonaDTO personaDTO, BoletoDTO boletoDTO, 
            String id_transaccion, Date fecha_compra, Time hora_compra, 
            String tipo_compra, BigDecimal monto) {
        this.personaDTO = personaDTO;
        this.boletoDTO = boletoDTO;
        this.id_transaccion = id_transaccion;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
        this.monto = monto;
    }

    public CompraDTO(String id, PersonaDTO personaDTO, BoletoDTO boletoDTO, 
            String id_transaccion, Date fecha_compra, Time hora_compra, 
            String tipo_compra, BigDecimal monto) {
        this.id = id;
        this.personaDTO = personaDTO;
        this.boletoDTO = boletoDTO;
        this.id_transaccion = id_transaccion;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public BoletoDTO getBoletoDTO() {
        return boletoDTO;
    }

    public void setBoletoDTO(BoletoDTO boletoDTO) {
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

    public String getTipo_compra() {
        return tipo_compra;
    }

    public void setTipo_compra(String tipo_compra) {
        this.tipo_compra = tipo_compra;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
}
