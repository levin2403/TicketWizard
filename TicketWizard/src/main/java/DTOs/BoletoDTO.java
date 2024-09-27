/**
 * BoletoDTO.java
 * 
 * Clase que representa un boleto en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información sobre un boleto, 
 * incluyendo su precio, número de serie, número de control, fila, asiento, tipo de boleto, 
 * precio original y el evento asociado.
 * 
 */
package DTOs;

import java.math.BigDecimal;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class BoletoDTO {
    
    private String id;
    private BigDecimal precio;
    private String numero_serie;
    private String numero_control;
    private String fila;
    private String asiento;
    private String tipo_boleto;
    private BigDecimal precio_original;
    private EventoDTO evento;

    /**
     * Constructor por defecto.
     */
    public BoletoDTO() {
    }

    /**
     * Constructor para crear un boleto con información completa, 
     * excluyendo el ID.
     *
     * @param precio El precio del boleto.
     * @param numero_serie El número de serie del boleto.
     * @param numero_control El número de control del boleto.
     * @param fila La fila del asiento.
     * @param asiento El número del asiento.
     * @param tipo_boleto El tipo de boleto.
     * @param precio_original El precio original del boleto.
     * @param evento El evento asociado al boleto.
     */
    public BoletoDTO(BigDecimal precio, String numero_serie, 
            String numero_control, String fila, String asiento, 
            String tipo_boleto, BigDecimal precio_original, 
            EventoDTO evento) {
        this.precio = precio;
        this.numero_serie = numero_serie;
        this.numero_control = numero_control;
        this.fila = fila;
        this.asiento = asiento;
        this.tipo_boleto = tipo_boleto;
        this.precio_original = precio_original;
        this.evento = evento;
    }

    /**
     * Constructor para crear un boleto con información completa, 
     * incluyendo el ID.
     *
     * @param id El identificador del boleto.
     * @param precio El precio del boleto.
     * @param numero_serie El número de serie del boleto.
     * @param numero_control El número de control del boleto.
     * @param fila La fila del asiento.
     * @param asiento El número del asiento.
     * @param tipo_boleto El tipo de boleto.
     * @param precio_original El precio original del boleto.
     * @param evento El evento asociado al boleto.
     */
    public BoletoDTO(String id, BigDecimal precio, String numero_serie, 
            String numero_control, String fila, String asiento, 
            String tipo_boleto, BigDecimal precio_original, EventoDTO evento) {
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

     /**
     * Obtiene el identificador del boleto.
     *
     * @return El ID del boleto.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del boleto.
     *
     * @param id El nuevo ID del boleto.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el precio del boleto.
     *
     * @return El precio del boleto.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del boleto.
     *
     * @param precio El nuevo precio del boleto.
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el número de serie del boleto.
     *
     * @return El número de serie del boleto.
     */
    public String getNumero_serie() {
        return numero_serie;
    }

    /**
     * Establece el número de serie del boleto.
     *
     * @param numero_serie El nuevo número de serie del boleto.
     */
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    /**
     * Obtiene el número de control del boleto.
     *
     * @return El número de control del boleto.
     */
    public String getNumero_control() {
        return numero_control;
    }

    /**
     * Establece el número de control del boleto.
     *
     * @param numero_control El nuevo número de control del boleto.
     */
    public void setNumero_control(String numero_control) {
        this.numero_control = numero_control;
    }

    /**
     * Obtiene la fila del asiento del boleto.
     *
     * @return La fila del asiento.
     */
    public String getFila() {
        return fila;
    }

    /**
     * Establece la fila del asiento del boleto.
     *
     * @param fila La nueva fila del asiento.
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el número del asiento del boleto.
     *
     * @return El número del asiento.
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Establece el número del asiento del boleto.
     *
     * @param asiento El nuevo número del asiento.
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Obtiene el tipo de boleto.
     *
     * @return El tipo de boleto.
     */
    public String getTipo_boleto() {
        return tipo_boleto;
    }

    /**
     * Establece el tipo de boleto.
     *
     * @param tipo_boleto El nuevo tipo de boleto.
     */
    public void setTipo_boleto(String tipo_boleto) {
        this.tipo_boleto = tipo_boleto;
    }

    /**
     * Obtiene el precio original del boleto.
     *
     * @return El precio original del boleto.
     */
    public BigDecimal getPrecio_original() {
        return precio_original;
    }

    /**
     * Establece el precio original del boleto.
     *
     * @param precio_original El nuevo precio original del boleto.
     */
    public void setPrecio_original(BigDecimal precio_original) {
        this.precio_original = precio_original;
    }

    /**
     * Obtiene el evento asociado al boleto.
     *
     * @return El evento asociado.
     */
    public EventoDTO getEvento() {
        return evento;
    }

    /**
     * Establece el evento asociado al boleto.
     *
     * @param evento El nuevo evento asociado al boleto.
     */
    public void setEvento(EventoDTO evento) {
        this.evento = evento;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto BoletoDTO.
     *
     * @return Una cadena que representa el boleto, incluyendo su ID, precio, 
     *         número de serie, número de control, fila, asiento, tipo de boleto,
     *         precio original y evento asociado.
     */
    @Override
    public String toString() {
        return "BoletoDTO{" + "id=" + id + ", precio=" + precio + 
                ", numero_serie=" + numero_serie + ", numero_control=" + 
                numero_control + ", fila=" + fila + ", asiento=" + asiento + 
                ", tipo_boleto=" + tipo_boleto + ", precio_original=" + 
                precio_original + ", evento=" + evento + '}';
    }  
}
