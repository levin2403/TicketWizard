/**
 * 
 */
package Convertidores;

import Entidades.Persona;
import Entidades.Domicilio;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */

public class PersonaCVR {

    public Persona convertirAEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String nombre = resultado.getString("nombre");
        String contraseña = resultado.getString("contraseña");
        java.sql.Date fechaNacimientoSQL = resultado.getDate("fecha_nacimiento");
        java.util.Date fechaNacimiento = new java.util.Date(fechaNacimientoSQL.getTime());
        String correo = resultado.getString("correo");
        int edad = resultado.getInt("edad");
        BigDecimal saldo = resultado.getBigDecimal("saldo");
        String generatedKey = resultado.getString("generated_key");

        // Obtener el domicilio asociado
        int idDomicilio = resultado.getInt("id_domicilio");
        Domicilio domicilio = new Domicilio();
        domicilio.setId(idDomicilio);

        // Crear y devolver el objeto Persona
        return new Persona(id, nombre, contraseña, (Date) fechaNacimiento, correo, edad, saldo, domicilio, generatedKey);
    }
}