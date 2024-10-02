/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author skevi
 */
public class Persona_Boleto {
    
    // omitimos a la persona porque por logica se sabe que es la persona que 
    // esta loggeada.
    private int id;
    private Boleto boleto;
    private Date fecha_adquisicion;
    private Time hora_adquisicion;
    private Tipo_boleto tipo_adquisicion;
    private String estado;

    public Persona_Boleto() {
    }

    public Persona_Boleto(Boleto boleto, Date fecha_adquisicion, 
            Time hora_adquisicion, Tipo_boleto tipo_adquisicion, 
            String estado) {
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
        this.tipo_adquisicion = tipo_adquisicion;
        this.estado = estado;
    }

    public Persona_Boleto(int id, Boleto boleto, Date fecha_adquisicion, 
            Time hora_adquisicion, Tipo_boleto tipo_adquisicion, 
            String estado) {
        this.id = id;
        this.boleto = boleto;
        this.fecha_adquisicion = fecha_adquisicion;
        this.hora_adquisicion = hora_adquisicion;
        this.tipo_adquisicion = tipo_adquisicion;
        this.estado = estado;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
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

    public Tipo_boleto getTipo_adquisicion() {
        return tipo_adquisicion;
    }

    public void setTipo_adquisicion(Tipo_boleto tipo_adquisicion) {
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
        return "Persona_boleto{" + "id=" + id + ", "
                + "boleto=" + boleto + ", fecha_adquisicion=" + 
                fecha_adquisicion + ", hora_adquisicion=" + 
                hora_adquisicion + ", tipo_adquisicion=" + 
                tipo_adquisicion + ", estado=" + estado + 
                '}';
    }
    
}
