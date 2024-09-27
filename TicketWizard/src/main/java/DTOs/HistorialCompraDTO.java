/**
 * HistorialCompraDTO.java
 *
 * Clase que representa el historial de compras de boletos en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información sobre
 * una compra de boleto realizada por una persona, incluyendo detalles sobre
 * la compra como la fecha, la hora y el tipo de compra.
 */
package DTOs;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialCompraDTO {

    private String id;
    private PersonaDTO persona; //persona que compro el boleto
    private BoletoDTO boleto; //boleto que fue comprado
    private Date fecha_compra;
    private Time hora_compra;
    private String tipo_compra;

    /**
     * Constructor por defecto.
     */
    public HistorialCompraDTO() {
    }

    /**
     * Constructor para crear un historial de compra sin ID.
     *
     * @param persona La persona que compró el boleto.
     * @param boleto El boleto que fue comprado.
     * @param fecha_compra La fecha de la compra.
     * @param hora_compra La hora de la compra.
     * @param tipo_compra El tipo de compra.
     */
    public HistorialCompraDTO(PersonaDTO persona, BoletoDTO boleto,
            Date fecha_compra, Time hora_compra, String tipo_compra) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    /**
     * Constructor para crear un historial de compra con información completa,
     * incluyendo el ID.
     *
     * @param id El identificador de la compra.
     * @param persona La persona que compró el boleto.
     * @param boleto El boleto que fue comprado.
     * @param fecha_compra La fecha de la compra.
     * @param hora_compra La hora de la compra.
     * @param tipo_compra El tipo de compra.
     */
    public HistorialCompraDTO(String id, PersonaDTO persona, BoletoDTO boleto,
            Date fecha_compra, Time hora_compra, String tipo_compra) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    /**
     * Obtiene el identificador de la compra.
     *
     * @return El ID de la compra.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la compra.
     *
     * @param id El nuevo ID de la compra.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la persona que compró el boleto.
     *
     * @return La persona que compró el boleto.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona que compró el boleto.
     *
     * @param persona La nueva persona que compró el boleto.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el boleto que fue comprado.
     *
     * @return El boleto que fue comprado.
     */
    public BoletoDTO getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que fue comprado.
     *
     * @param boleto El nuevo boleto que fue comprado.
     */
    public void setBoleto(BoletoDTO boleto) {
        this.boleto = boleto;
    }

    /**
     * Obtiene la fecha de la compra.
     *
     * @return La fecha de la compra.
     */
    public Date getFecha_compra() {
        return fecha_compra;
    }

    /**
     * Establece la fecha de la compra.
     *
     * @param fecha_compra La nueva fecha de la compra.
     */
    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    /**
     * Obtiene la hora de la compra.
     *
     * @return La hora de la compra.
     */
    public Time getHora_compra() {
        return hora_compra;
    }

    /**
     * Establece la hora de la compra.
     *
     * @param hora_compra La nueva hora de la compra.
     */
    public void setHora_compra(Time hora_compra) {
        this.hora_compra = hora_compra;
    }

    /**
     * Obtiene el tipo de compra.
     *
     * @return El tipo de compra.
     */
    public String getTipo_compra() {
        return tipo_compra;
    }

    /**
     * Establece el tipo de compra.
     *
     * @param tipo_compra El nuevo tipo de compra.
     */
    public void setTipo_compra(String tipo_compra) {
        this.tipo_compra = tipo_compra;
    }
}
