/**
 * Boleto.java
 * 
 * Clase que representa un boleto en el sistema.
 * Esta clase contiene información sobre un boleto, incluyendo su
 * precio, número de serie, número de control, ubicación, tipo de boleto,
 * precio original y el evento asociado.
 */
package Entidades;

import java.math.BigDecimal;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
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

    /**
     * Constructor por defecto.
     */
    public Boleto() {
    }

    /**
     * Constructor para crear un boleto sin ID.
     *
     * @param precio Precio de reventa del boleto.
     * @param numero_serie Número de serie del boleto.
     * @param numero_control Número de control del boleto.
     * @param fila Fila donde se ubica el asiento.
     * @param asiento Número de asiento.
     * @param tipo_boleto Tipo de boleto (general, VIP, etc.).
     * @param precio_original Precio original del boleto.
     * @param evento Evento asociado al boleto.
     */
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

    /**
     * Constructor para crear un boleto con información completa,
     * incluyendo el ID.
     *
     * @param id Identificador del boleto.
     * @param precio Precio de reventa del boleto.
     * @param numero_serie Número de serie del boleto.
     * @param numero_control Número de control del boleto.
     * @param fila Fila donde se ubica el asiento.
     * @param asiento Número de asiento.
     * @param tipo_boleto Tipo de boleto (general, VIP, etc.).
     * @param precio_original Precio original del boleto.
     * @param evento Evento asociado al boleto.
     */
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

    /**
     * Obtiene el identificador del boleto.
     *
     * @return El ID del boleto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del boleto.
     *
     * @param id El nuevo ID del boleto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el precio del boleto.
     *
     * @return El precio de reventa del boleto.
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
     * Obtiene la fila donde se ubica el asiento del boleto.
     *
     * @return La fila del boleto.
     */
    public String getFila() {
        return fila;
    }

    /**
     * Establece la fila donde se ubica el asiento del boleto.
     *
     * @param fila La nueva fila del boleto.
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el número de asiento del boleto.
     *
     * @return El número de asiento del boleto.
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Establece el número de asiento del boleto.
     *
     * @param asiento El nuevo número de asiento del boleto.
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Obtiene el tipo de boleto.
     *
     * @return El tipo de boleto.
     */
    public Tipo_boleto getTipo_boleto() {
        return tipo_boleto;
    }

    /**
     * Establece el tipo de boleto.
     *
     * @param tipo_boleto El nuevo tipo de boleto.
     */
    public void setTipo_boleto(Tipo_boleto tipo_boleto) {
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
     * @return El evento asociado al boleto.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Establece el evento asociado al boleto.
     *
     * @param evento El nuevo evento asociado al boleto.
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    /**
 * Devuelve una representación en forma de cadena del boleto.
 * Esta representación incluye el ID, el precio, el número de serie, 
 * el número de control, la fila, el asiento, el tipo de boleto, 
 * el precio original y el evento asociado.
 *
 * @return Una cadena que representa el boleto.
 */
    @Override
    public String toString() {
        return "Boleto{" + "id=" + id + ", precio=" + precio + 
               ", numero_serie=" + numero_serie + ", numero_control=" + 
               numero_control + ", fila=" + fila + ", asiento=" + asiento + 
               ", tipo_boleto=" + tipo_boleto + ", precio_original=" +
               precio_original + ", evento=" + evento + '}';
    }
}