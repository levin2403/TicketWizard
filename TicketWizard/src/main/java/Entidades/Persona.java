/**
 * Persona.java
 * 
 * La clase Persona representa a un usuario del sistema, incluyendo 
 * información personal como nombre, contraseña, fecha de nacimiento, 
 * correo electrónico, saldo, domicilio y una clave generada.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Persona {
    
    private int id;
    private String nombre;
    private String contraseña;
    private Date fechaNacimiento;
    private String correo;
    private BigDecimal saldo;
    private Domicilio domicilio;
    private String generatedKey;

    /**
     * Constructor por defecto.
     */
    public Persona() {
    }

    /**
     * Constructor que inicializa la persona con los parámetros dados.
     *
     * @param nombre El nombre de la persona.
     * @param contraseña La contraseña de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param correo El correo electrónico de la persona.
     * @param saldo El saldo de la cuenta de la persona.
     * @param domicilio El domicilio de la persona.
     * @param generatedKey La clave generada para la persona.
     */
    public Persona(String nombre, String contraseña, Date fechaNacimiento, 
            String correo, BigDecimal saldo, Domicilio domicilio, 
            String generatedKey) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.generatedKey = generatedKey;
    }

    /**
     * Constructor que inicializa la persona con el ID y los parámetros dados.
     *
     * @param id El identificador único de la persona.
     * @param nombre El nombre de la persona.
     * @param contraseña La contraseña de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param correo El correo electrónico de la persona.
     * @param saldo El saldo de la cuenta de la persona.
     * @param domicilio El domicilio de la persona.
     * @param generatedKey La clave generada para la persona.
     */
    public Persona(int id, String nombre, String contraseña, Date fechaNacimiento, 
            String correo, BigDecimal saldo, Domicilio domicilio, 
            String generatedKey) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.generatedKey = generatedKey;
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param id El ID de la persona a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña de la persona.
     *
     * @return La contraseña de la persona.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña de la persona.
     *
     * @param contraseña La contraseña de la persona a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona a establecer.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo El correo electrónico de la persona a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el saldo de la cuenta de la persona.
     *
     * @return El saldo de la cuenta de la persona.
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta de la persona.
     *
     * @param saldo El saldo de la cuenta a establecer.
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el domicilio de la persona.
     *
     * @return El domicilio de la persona.
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio de la persona.
     *
     * @param domicilio El domicilio de la persona a establecer.
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene la clave generada para la persona.
     *
     * @return La clave generada para la persona.
     */
    public String getGeneratedKey() {
        return generatedKey;
    }

    /**
     * Establece la clave generada para la persona.
     *
     * @param generatedKey La clave generada para la persona a establecer.
     */
    public void setGeneratedKey(String generatedKey) {
        this.generatedKey = generatedKey;
    }

    /**
     * Devuelve una representación en cadena de la persona.
     *
     * @return Una cadena que representa a la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + 
                ", contrase\u00f1a=" + contraseña + ", fechaNacimiento=" + 
                fechaNacimiento + ", correo=" + correo + ", saldo=" + saldo + 
                ", domicilio=" + domicilio + ", generatedKey=" + generatedKey + 
                '}';
    } 
}
