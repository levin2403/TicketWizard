/**
 * Venta.java
 * 
 * La clase Venta representa una transacción de reventa de un boleto por parte 
 * de un usuario. Esta clase contiene información sobre el boleto, el precio 
 * de reventa y la fecha límite para la compra del boleto.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Venta {
    
    private int id;
    private Persona persona; //persona que compra el boleto
    private Boleto boleto; //boleto que esta en venta
    private BigDecimal precio_reventa;
    private Date fecha_limite;

    /**
     * Constructor vacío de la clase Venta.
     */
    public Venta() {
    }

    /**
     * Constructor que inicializa la venta con los datos proporcionados.
     * 
     * @param cliente La persona que realiza la compra.
     * @param boleto El boleto que está siendo vendido.
     * @param precio_reventa El precio de reventa del boleto.
     * @param fecha_limite La fecha límite para la compra del boleto.
     */
    public Venta(Persona cliente, Boleto boleto, BigDecimal precio_reventa, 
            Date fecha_limite) {
        this.persona = cliente;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    /**
     * Constructor que inicializa la venta con el ID y los datos proporcionados.
     * 
     * @param id El identificador de la venta.
     * @param persona La persona que realiza la compra.
     * @param boleto El boleto que está siendo vendido.
     * @param precio_reventa El precio de reventa del boleto.
     * @param fecha_limite La fecha límite para la compra del boleto.
     */
    public Venta(int id, Persona persona, Boleto boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    /**
     * Obtiene el ID de la venta.
     * 
     * @return El ID de la venta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la venta.
     * 
     * @param id El nuevo ID de la venta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la persona que realiza la compra.
     * 
     * @return La persona que compra el boleto.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona que realiza la compra.
     * 
     * @param cliente La nueva persona que compra el boleto.
     */
    public void setPersona(Persona cliente) {
        this.persona = cliente;
    }

    /**
     * Obtiene el boleto que está en venta.
     * 
     * @return El boleto que está siendo vendido.
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que está en venta.
     * 
     * @param boleto El nuevo boleto que está siendo vendido.
     */
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    /**
     * Obtiene el precio de reventa del boleto.
     * 
     * @return El precio de reventa del boleto.
     */
    public BigDecimal getPrecio_reventa() {
        return precio_reventa;
    }

    /**
     * Establece el precio de reventa del boleto.
     * 
     * @param precio_reventa El nuevo precio de reventa del boleto.
     */
    public void setPrecio_reventa(BigDecimal precio_reventa) {
        this.precio_reventa = precio_reventa;
    }

    /**
     * Obtiene la fecha límite para la compra del boleto.
     * 
     * @return La fecha límite para la compra del boleto.
     */
    public Date getFecha_limite() {
        return fecha_limite;
    }

    /**
     * Establece la fecha límite para la compra del boleto.
     * 
     * @param fecha_limite La nueva fecha límite para la compra del boleto.
     */
    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
}
