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
    private String precio;
    private int id_evento;

    public Boleto() {
    }

    public Boleto(String numero_serie, String fila, String asiento, String precio, int id_evento) {
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio = precio;
        this.id_evento = id_evento;
    }

    public Boleto(int id, String numero_serie, String fila, String asiento, String precio, int id_evento) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio = precio;
        this.id_evento = id_evento;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
    
    
}
