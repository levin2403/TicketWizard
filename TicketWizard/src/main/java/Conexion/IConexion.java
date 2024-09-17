/**
 * 
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IConexion {
    
    public Connection crearConexion() throws SQLException;
    
}
