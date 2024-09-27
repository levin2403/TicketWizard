/**
 * VentaDTO.java
 * 
 * Clase que representa una venta de boletos en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información
 * sobre una venta, incluyendo la persona involucrada, el boleto,
 * el precio de reventa y la fecha límite para la reventa.
 */
package DTOs;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class VentaDTO {
    
    private String id;
    private PersonaDTO persona;
    private BoletoDTO boleto;
    private BigDecimal precio_reventa;
    private Date fecha_limite;

    /**
     * Constructor por defecto.
     */
    public VentaDTO() {
    }

    /**
     * Constructor para crear una venta sin ID.
     *
     * @param persona La persona involucrada en la venta.
     * @param boleto El boleto que se está revendiendo.
     * @param precio_reventa El precio de reventa del boleto.
     * @param fecha_limite La fecha límite para la reventa.
     */
    public VentaDTO(PersonaDTO persona, BoletoDTO boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    /**
     * Constructor para crear una venta con información completa, 
     * incluyendo el ID.
     *
     * @param id El identificador de la venta.
     * @param persona La persona involucrada en la venta.
     * @param boleto El boleto que se está revendiendo.
     * @param precio_reventa El precio de reventa del boleto.
     * @param fecha_limite La fecha límite para la reventa.
     */
    public VentaDTO(String id, PersonaDTO persona, BoletoDTO boleto, 
            BigDecimal precio_reventa, Date fecha_limite) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.precio_reventa = precio_reventa;
        this.fecha_limite = fecha_limite;
    }

    /**
     * Obtiene el identificador de la venta.
     *
     * @return El ID de la venta.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la venta.
     *
     * @param id El nuevo ID de la venta.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la persona involucrada en la venta.
     *
     * @return La persona de la venta.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona involucrada en la venta.
     *
     * @param cliente La nueva persona de la venta.
     */
    public void setPersona(PersonaDTO cliente) {
        this.persona = cliente;
    }

    /**
     * Obtiene el boleto que se está revendiendo.
     *
     * @return El boleto de la venta.
     */
    public BoletoDTO getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que se está revendiendo.
     *
     * @param boleto El nuevo boleto de la venta.
     */
    public void setBoleto(BoletoDTO boleto) {
        this.boleto = boleto;
    }

    /**
     * Obtiene el precio de reventa del boleto.
     *
     * @return El precio de reventa.
     */
    public BigDecimal getPrecio_reventa() {
        return precio_reventa;
    }

    /**
     * Establece el precio de reventa del boleto.
     *
     * @param precio_reventa El nuevo precio de reventa.
     */
    public void setPrecio_reventa(BigDecimal precio_reventa) {
        this.precio_reventa = precio_reventa;
    }

    /**
     * Obtiene la fecha límite para la reventa del boleto.
     *
     * @return La fecha límite para la reventa.
     */
    public Date getFecha_limite() {
        return fecha_limite;
    }

    /**
     * Establece la fecha límite para la reventa del boleto.
     *
     * @param fecha_limite La nueva fecha límite para la reventa.
     */
    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
}
