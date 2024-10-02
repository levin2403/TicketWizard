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
public class Persona_BoletoDTO {
    
    // omitimos a la persona porque por logica se sabe que es la persona que 
    // esta loggeada.
    private String id;
    private BoletoDTO boleto;
    private Date fecha_adquisicion;
    private Time hora_adquisicion;
    private String tipo_adquisicion;
    private String estado;

    public Persona_BoletoDTO() {
    }

    public Persona_BoletoDTO(BoletoDTO boleto, Date fecha_adquisicion, 
            Time hora_adquisicion, String tipo_adquisicion, String estado) {
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
        this.tipo_adquisicion = tipo_adquisicion;
        this.estado = estado;
    }

    public Persona_BoletoDTO(String id, BoletoDTO boleto, Date fecha_adquisicion, 
            Time hora_adquisicion, String tipo_adquisicion, String estado) {
        this.id = id;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
        this.tipo_adquisicion = tipo_adquisicion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTipo_adquisicion() {
        return tipo_adquisicion;
    }

    public void setTipo_adquisicion(String tipo_adquisicion) {
        this.tipo_adquisicion = tipo_adquisicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona_boletoDTO{" + "id=" + id + ", boleto=" + boleto + 
                ", fecha_adquisicion=" + fecha_adquisicion + 
                ", hora_adquisicion=" + hora_adquisicion + 
                ", tipo_adquisicion=" + tipo_adquisicion + 
                ", estado=" + estado + '}';
    }
    
}
