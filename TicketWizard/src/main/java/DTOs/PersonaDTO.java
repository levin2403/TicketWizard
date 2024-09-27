/**
 * PersonaDTO.java
 * 
 * Clase que representa una persona en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información
 * sobre una persona, incluyendo su identificación, nombre, contraseña,
 * fecha de nacimiento, correo electrónico, saldo y domicilio.
 */
package DTOs;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class PersonaDTO {

    private String id;
    private String nombre;
    private String contraseña;
    private Date fechaNacimiento;
    private String correo;
    private BigDecimal saldo;
    private DomicilioDTO domicilioDto;
    private String generatedKey;

     /**
     * Constructor por defecto.
     */
    public PersonaDTO() {
    }

    /**
     * Constructor para crear una persona sin ID.
     *
     * @param nombre El nombre de la persona.
     * @param contraseña La contraseña de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param correo El correo electrónico de la persona.
     * @param saldo El saldo de la cuenta de la persona.
     * @param domicilioDto El domicilio de la persona.
     * @param generatedKey La clave generada para la persona.
     */
    public PersonaDTO(String nombre, String contraseña, Date fechaNacimiento, 
                      String correo, BigDecimal saldo, DomicilioDTO domicilioDto, String generatedKey) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.saldo = saldo;
        this.domicilioDto = domicilioDto;
        this.generatedKey = generatedKey;
    }

    /**
     * Constructor para crear una persona con información completa, 
     * incluyendo el ID.
     *
     * @param id El identificador de la persona.
     * @param nombre El nombre de la persona.
     * @param contraseña La contraseña de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param correo El correo electrónico de la persona.
     * @param saldo El saldo de la cuenta de la persona.
     * @param domicilioDto El domicilio de la persona.
     * @param generatedKey La clave generada para la persona.
     */
    public PersonaDTO(String id, String nombre, String contraseña, Date fechaNacimiento, String correo, BigDecimal saldo, DomicilioDTO domicilioDto, String generatedKey) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.saldo = saldo;
        this.domicilioDto = domicilioDto;
        this.generatedKey = generatedKey;
    }

    /**
     * Obtiene el identificador de la persona.
     *
     * @return El ID de la persona.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la persona.
     *
     * @param id El nuevo ID de la persona.
     */
    public void setId(String id) {
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
     * @param nombre El nuevo nombre de la persona.
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
     * @param contraseña La nueva contraseña de la persona.
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
     * @param fechaNacimiento La nueva fecha de nacimiento de la persona.
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
     * @param correo El nuevo correo electrónico de la persona.
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
     * @param saldo El nuevo saldo de la cuenta de la persona.
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el domicilio de la persona.
     *
     * @return El domicilio de la persona.
     */
    public DomicilioDTO getDomicilioDto() {
        return domicilioDto;
    }

    /**
     * Establece el domicilio de la persona.
     *
     * @param domicilioDto El nuevo domicilio de la persona.
     */
    public void setDomicilioDto(DomicilioDTO domicilioDto) {
        this.domicilioDto = domicilioDto;
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
     * @param generatedKey La nueva clave generada para la persona.
     */
    public void setGeneratedKey(String generatedKey) {
        this.generatedKey = generatedKey;
    }

    /**
     * Retorna una representación en forma de cadena de la persona.
     *
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        return "PersonaDTO{" +
               "id=" + id + 
               ", nombre=" + nombre + 
               ", contraseña=" + contraseña + 
               ", fechaNacimiento=" + fechaNacimiento + 
               ", correo=" + correo + 
               ", saldo=" + saldo + 
               ", domicilioDto=" + domicilioDto + 
               ", generatedKey=" + generatedKey + '}';
    }
}
