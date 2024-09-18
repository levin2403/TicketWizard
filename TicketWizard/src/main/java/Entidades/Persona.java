/**
 * 
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Date;

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

    public Persona() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public void setGeneratedKey(String generatedKey) {
        this.generatedKey = generatedKey;
    }
    
    
}
