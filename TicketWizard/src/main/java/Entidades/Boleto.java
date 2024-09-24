/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.math.BigDecimal;

/**
 *
 * @author skevi
 */
public class Boleto {
    
    private int id;
    private BigDecimal precio;
    private String numero_serie;
    private String numero_control;
    private String fila;
    private String asiento;
    private Tipo_boleto tipo_boleto;
    private BigDecimal precio_original;
    private Evento evento;

    public Boleto() {
    }

    public Boleto(BigDecimal precio, String numero_serie, 
            String numero_control, String fila, String asiento, 
            Tipo_boleto tipo_boleto, BigDecimal precio_original, 
            Evento evento) {
        this.precio = precio;
        this.numero_serie = numero_serie;
        this.numero_control = numero_control;
        this.fila = fila;
        this.asiento = asiento;
        this.tipo_boleto = tipo_boleto;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public Boleto(int id, BigDecimal precio, String numero_serie, 
            String numero_control, String fila, String asiento, 
            Tipo_boleto tipo_boleto, BigDecimal precio_original, 
            Evento evento) {
        this.id = id;
        this.precio = precio;
        this.numero_serie = numero_serie;
        this.numero_control = numero_control;
        this.fila = fila;
        this.asiento = asiento;
        this.tipo_boleto = tipo_boleto;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getNumero_control() {
        return numero_control;
    }

    public void setNumero_control(String numero_control) {
        this.numero_control = numero_control;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Tipo_boleto getTipo_boleto() {
        return tipo_boleto;
    }

    public void setTipo_boleto(Tipo_boleto tipo_boleto) {
        this.tipo_boleto = tipo_boleto;
    }

    public BigDecimal getPrecio_original() {
        return precio_original;
    }

    public void setPrecio_original(BigDecimal precio_original) {
        this.precio_original = precio_original;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Boleto{" + "id=" + id + ", precio=" + precio + 
                ", numero_serie=" + numero_serie + ", numero_control=" + 
                numero_control + ", fila=" + fila + ", asiento=" + asiento + 
                ", tipo_boleto=" + tipo_boleto + ", precio_original=" +
                precio_original + ", evento=" + evento + '}';
    }
    
}