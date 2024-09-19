/**
 * 
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */

public class Conexion implements IConexion {
    private static final Logger logger = Logger.getLogger(Conexion.class.getName()); // Instancia del logger
    String cadena = "jdbc:mysql://localhost:3306/ticketwizard";
    String user = "root";
    String password = "Saymyname15";
    
    @Override
    public Connection crearConexion() {
        try {
            Connection conn = DriverManager.getConnection(cadena, user, password);
            logger.log(Level.INFO, "Conexión exitosa a la base de datos");
            return conn;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al conectar a la base de datos: {0}", ex.getMessage());
            logger.log(Level.SEVERE, "Stack Trace:", ex); // Incluye el stack trace en los logs
        }
        return null;
    }
}
