/**
 * 
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

    public PersonaDTO() {
    }

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
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public DomicilioDTO getDomicilioDto() {
        return domicilioDto;
    }

    public void setDomicilioDto(DomicilioDTO domicilioDto) {
        this.domicilioDto = domicilioDto;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public void setGeneratedKey(String generatedKey) {
        this.generatedKey = generatedKey;
    }

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
