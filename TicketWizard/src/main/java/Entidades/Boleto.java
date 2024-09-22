/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author skevi
 */
public class Boleto {
    
    private int id;
    private String numero_serie;
    private String fila;
    private String asiento;
    private String precio_original;
    private Evento evento;

    public Boleto() {
    }

    public Boleto(String numero_serie, String fila, String asiento, String precio_original, Evento evento) {
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public Boleto(int id, String numero_serie, String fila, String asiento, String precio_original, Evento evento) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
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

    public String getPrecio_original() {
        return precio_original;
    }

    public void setPrecio_original(String precio_original) {
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
        return "Boleto{" + "id=" + id + ", numero_serie=" + numero_serie + 
                ", fila=" + fila + ", asiento=" + asiento + 
                ", precio_original=" + precio_original + 
                ", evento=" + evento + '}';
    }

    
}