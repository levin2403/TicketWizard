/**
 * HistorialCompra.java
 * 
 * La clase HistorialCompra representa el historial de compras de boletos
 * por parte de una persona. Contiene información sobre el boleto comprado,
 * la persona que realizó la compra, la fecha y hora de la compra, 
 * así como el tipo de boleto adquirido.
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialCompra {
    
    private int id;
    private Persona persona; //persona que compro el boleto
    private Boleto boleto; //boleto que fue comprado
    private Date fecha_compra;
    private Time hora_compra;
    private Tipo_boleto tipo_compra;

    /**
     * Constructor por defecto.
     */
    public HistorialCompra() {
    }

    /**
     * Constructor que inicializa el historial de compra con los parámetros dados.
     *
     * @param persona La persona que realiza la compra.
     * @param boleto El boleto que fue comprado.
     * @param fecha_compra La fecha de la compra.
     * @param hora_compra La hora de la compra.
     * @param tipo_compra El tipo de boleto comprado.
     */
    public HistorialCompra(Persona persona, Boleto boleto, Date fecha_compra, 
            Time hora_compra, Tipo_boleto tipo_compra) {
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    /**
     * Constructor que inicializa el historial de compra con el ID y los parámetros dados.
     *
     * @param id El identificador del historial de compra.
     * @param persona La persona que realiza la compra.
     * @param boleto El boleto que fue comprado.
     * @param fecha_compra La fecha de la compra.
     * @param hora_compra La hora de la compra.
     * @param tipo_compra El tipo de boleto comprado.
     */
    public HistorialCompra(int id, Persona persona, Boleto boleto, 
            Date fecha_compra, Time hora_compra, Tipo_boleto tipo_compra) {
        this.id = id;
        this.persona = persona;
        this.boleto = boleto;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.tipo_compra = tipo_compra;
    }

    /**
     * Obtiene el ID del historial de compra.
     *
     * @return El ID del historial de compra.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del historial de compra.
     *
     * @param id El ID del historial de compra a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la persona que realizó la compra.
     *
     * @return La persona que realizó la compra.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona que realizó la compra.
     *
     * @param persona La persona que realizó la compra.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el boleto que fue comprado.
     *
     * @return El boleto que fue comprado.
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * Establece el boleto que fue comprado.
     *
     * @param boleto El boleto que fue comprado.
     */
    public void setBoleto(Boleto boleto) {
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
     * @param fecha_compra La fecha de la compra a establecer.
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
     * @param hora_compra La hora de la compra a establecer.
     */
    public void setHora_compra(Time hora_compra) {
        this.hora_compra = hora_compra;
    }

    /**
     * Obtiene el tipo de boleto comprado.
     *
     * @return El tipo de boleto comprado.
     */
    public Tipo_boleto getTipo_compra() {
        return tipo_compra;
    }

    /**
     * Establece el tipo de boleto comprado.
     *
     * @param tipo_compra El tipo de boleto a establecer.
     */
    public void setTipo_compra(Tipo_boleto tipo_compra) {
        this.tipo_compra = tipo_compra;
    }
}
