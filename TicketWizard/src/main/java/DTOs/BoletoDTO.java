/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author skevi
 */
public class BoletoDTO {
    
    private String id;
    private String numero_serie;
    private String fila;
    private String asiento;
    private String precio_original;
    private EventoDTO evento;

    public BoletoDTO() {
    }

    public BoletoDTO(String numero_serie, String fila, String asiento, 
            String precio_original, EventoDTO evento) {
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public BoletoDTO(String id, String numero_serie, String fila, 
            String asiento, String precio_original, EventoDTO evento) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.fila = fila;
        this.asiento = asiento;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public EventoDTO getEvento() {
        return evento;
    }

    public void setEvento(EventoDTO evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" + "id=" + id + ", numero_serie=" + numero_serie + 
                ", fila=" + fila + ", asiento=" + asiento + 
                ", precio_original=" + precio_original + ", evento=" + 
                evento + '}';
    }
    
    
}
