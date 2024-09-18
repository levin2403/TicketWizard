/**
 * 
 */
package DTOs;

import java.sql.Date;

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
    private int edad;
    private double saldo;
    private int idDomicilio;
    private String generatedKey;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String contraseña, Date fechaNacimiento, 
                      String correo, int edad, double saldo, int idDomicilio, String generatedKey) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.edad = edad;
        this.saldo = saldo;
        this.idDomicilio = idDomicilio;
        this.generatedKey = generatedKey;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
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
               ", nombre=" + nombre + 
               ", contraseña=" + contraseña + 
               ", fechaNacimiento=" + fechaNacimiento + 
               ", correo=" + correo + 
               ", edad=" + edad + 
               ", saldo=" + saldo + 
               ", idDomicilio=" + idDomicilio + 
               ", generatedKey=" + generatedKey + '}';
    }
}
