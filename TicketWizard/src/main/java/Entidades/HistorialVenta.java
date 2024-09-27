/**
 * HistorialVenta.java
 * 
 * La clase HistorialVenta representa el historial de ventas de boletos,
 * incluyendo información sobre el vendedor, el comprador, el boleto vendido,
 * el precio de venta, y la fecha y hora de la venta.
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialVenta {
    
    private int id;
    private Persona vendedor;
    private Persona comprador;
    private Boleto boleto;
    private BigDecimal precio_venta;
    private Date fecha_venta;
    private Time hora_venta;

    /**
     * Constructor por defecto.
     */
    public HistorialVenta() {
    }

    /**
     * Constructor que inicializa el historial de venta con los parámetros dados.
     *
     * @param vendedor La persona que vende el boleto.
     * @param comprador La persona que compra el boleto.
     * @param boleto El boleto que fue vendido.
     * @param precio_venta El precio de venta del boleto.
     * @param fecha_venta La fecha de la venta.
     * @param hora_venta La hora de la venta.
     */
    public HistorialVenta(Persona vendedor, Persona comprador, Boleto boleto, 
            BigDecimal precio_venta, Date fecha_venta, Time hora_venta) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    /**
     * Constructor que inicializa el historial de venta con el ID y los parámetros dados.
     *
     * @param id El identificador del historial de venta.
     * @param vendedor La persona que vende el boleto.
     * @param comprador La persona que compra el boleto.
     * @param boleto El boleto que fue vendido.
     * @param precio_venta El precio de venta del boleto.
     * @param fecha_venta La fecha de la venta.
     * @param hora_venta La hora de la venta.
     */
    public HistorialVenta(int id, Persona vendedor, Persona comprador, 
            Boleto boleto, BigDecimal precio_venta, Date fecha_venta, 
            Time hora_venta) {
        this.id = id;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    /**
     * Obtiene el ID del historial de venta.
     *
     * @return El ID del historial de venta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del historial de venta.
     *
     * @param id El ID del historial de venta a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la persona que vendió el boleto.
     *
     * @return La persona que vendió el boleto.
     */
    public Persona getVendedor() {
        return vendedor;
    }

    /**
     * Establece la persona que vendió el boleto.
     *
     * @param vendedor La persona que vendió el boleto.
     */
    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Obtiene la persona que compró el boleto.
     *
     * @return La persona que compró el boleto.
     */
    public Persona getComprador() {
        return comprador;
    }

    /**
     * Establece la persona que compró el boleto.
     *
     * @param comprador La persona que compró el boleto.
     */
    public void setComprador(Persona comprador) {
        this.comprador = comprador;
    }

    /**
     * Obtiene el boleto que fue vendido.
     *
     * @return El boleto que fue vendido.
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que fue vendido.
     *
     * @param boleto El boleto que fue vendido.
     */
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    /**
     * Obtiene el precio de venta del boleto.
     *
     * @return El precio de venta del boleto.
     */
    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    /**
     * Establece el precio de venta del boleto.
     *
     * @param precio_venta El precio de venta a establecer.
     */
    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return La fecha de la venta.
     */
    public Date getFecha_venta() {
        return fecha_venta;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fecha_venta La fecha de la venta a establecer.
     */
    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    /**
     * Obtiene la hora de la venta.
     *
     * @return La hora de la venta.
     */
    public Time getHora_venta() {
        return hora_venta;
    }

    /**
     * Establece la hora de la venta.
     *
     * @param hora_venta La hora de la venta a establecer.
     */
    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    /**
     * Devuelve una representación en cadena del historial de venta.
     *
     * @return Una cadena que representa el historial de venta.
     */
    @Override
    public String toString() {
        return "HistorialVenta{" + "id=" + id + ", vendedor=" + vendedor + 
                ", comprador=" + comprador + ", boleto=" + boleto + 
                ", precio_venta=" + precio_venta + ", fecha_venta=" + 
                fecha_venta + ", hora_venta=" + hora_venta + '}';
    }
}
