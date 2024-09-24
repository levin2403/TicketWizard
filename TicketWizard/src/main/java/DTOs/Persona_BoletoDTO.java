/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class Persona_BoletoDTO {
    
    private String id;
    private PersonaDTO persona;
    private BoletoDTO boleto;
    private Date fecha_adquisicion;
    private Time hora_adquisicion;

    public Persona_BoletoDTO() {
    }

    public Persona_BoletoDTO(PersonaDTO persona, BoletoDTO boleto, 
            Date fecha_adquisicion, Time hora_adquisicion) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
    }

    public Persona_BoletoDTO(String id, PersonaDTO persona, 
            BoletoDTO boleto, Date fecha_adquisicion, Time hora_adquisicion) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
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

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public Time getHora_adquisicion() {
        return hora_adquisicion;
    }

    public void setHora_adquisicion(Time hora_adquisicion) {
        this.hora_adquisicion = hora_adquisicion;
    }

    @Override
    public String toString() {
        return "Persona_BoletoDTO{" + "id=" + id + ", persona=" + persona + 
                ", boleto=" + boleto + ", fecha_adquisicion=" + 
                fecha_adquisicion + ", hora_adquisicion=" + 
                hora_adquisicion + '}';
    }
    
}
