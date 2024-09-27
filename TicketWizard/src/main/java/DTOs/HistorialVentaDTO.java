/**
 * HistorialVentaDTO.java
 * 
 * Clase que representa el historial de ventas de boletos en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información sobre 
 * la venta de un boleto, incluyendo detalles sobre el vendedor, el comprador,
 * el precio de venta, la fecha y la hora de la venta.
 */
package DTOs;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialVentaDTO {
    
    private int id;
    private PersonaDTO vendedor;
    private PersonaDTO comprador;
    private BoletoDTO boleto;
    private BigDecimal precio_venta;
    private Date fecha_venta;
    private Time hora_venta;

    /**
     * Constructor por defecto.
     */
    public HistorialVentaDTO() {
    }

    /**
     * Constructor para crear un historial de venta sin ID.
     *
     * @param vendedor El vendedor del boleto.
     * @param comprador El comprador del boleto.
     * @param boleto El boleto que fue vendido.
     * @param precio_venta El precio al que se vendió el boleto.
     * @param fecha_venta La fecha de la venta.
     * @param hora_venta La hora de la venta.
     */
    public HistorialVentaDTO(PersonaDTO vendedor, PersonaDTO comprador, 
            BoletoDTO boleto, BigDecimal precio_venta, Date fecha_venta, 
            Time hora_venta) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.boleto = boleto;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
    }

    /**
     * Constructor para crear un historial de venta con información completa,
     * incluyendo el ID.
     *
     * @param id El identificador de la venta.
     * @param vendedor El vendedor del boleto.
     * @param comprador El comprador del boleto.
     * @param boleto El boleto que fue vendido.
     * @param precio_venta El precio al que se vendió el boleto.
     * @param fecha_venta La fecha de la venta.
     * @param hora_venta La hora de la venta.
     */
    public HistorialVentaDTO(int id, PersonaDTO vendedor, PersonaDTO comprador, 
            BoletoDTO boleto, BigDecimal precio_venta, Date fecha_venta, 
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
     * Obtiene el identificador de la venta.
     *
     * @return El ID de la venta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la venta.
     *
     * @param id El nuevo ID de la venta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el vendedor del boleto.
     *
     * @return El vendedor del boleto.
     */
    public PersonaDTO getVendedor() {
        return vendedor;
    }

    /**
     * Establece el vendedor del boleto.
     *
     * @param vendedor El nuevo vendedor del boleto.
     */
    public void setVendedor(PersonaDTO vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Obtiene el comprador del boleto.
     *
     * @return El comprador del boleto.
     */
    public PersonaDTO getComprador() {
        return comprador;
    }

    /**
     * Establece el comprador del boleto.
     *
     * @param comprador El nuevo comprador del boleto.
     */
    public void setComprador(PersonaDTO comprador) {
        this.comprador = comprador;
    }

    /**
     * Obtiene el boleto que fue vendido.
     *
     * @return El boleto que fue vendido.
     */
    public BoletoDTO getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que fue vendido.
     *
     * @param boleto El nuevo boleto que fue vendido.
     */
    public void setBoleto(BoletoDTO boleto) {
        this.boleto = boleto;
    }

    /**
     * Obtiene el precio de venta del boleto.
     *
     * @return El precio de venta.
     */
    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    /**
     * Establece el precio de venta del boleto.
     *
     * @param precio_venta El nuevo precio de venta.
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
     * @param fecha_venta La nueva fecha de la venta.
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
     * @param hora_venta La nueva hora de la venta.
     */
    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    /**
     * Retorna una representación en forma de cadena del historial de venta.
     *
     * @return Una cadena que representa el historial de venta.
     */
    @Override
    public String toString() {
        return "HistorialVentaDTO{" + "id=" + id + ", vendedor=" + vendedor + 
                ", comprador=" + comprador + ", boleto=" + boleto + 
                ", precio_venta=" + precio_venta + ", fecha_venta=" + 
                fecha_venta + ", hora_venta=" + hora_venta + '}';
    }
}
