/**
 * Conexion.java.
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

    /**
     * Crea una conexión a la base de datos utilizando los parámetros de
     * conexión establecidos.
     *
     * Este método intenta establecer una conexión con la base de datos
     * utilizando la cadena de conexión, el usuario y la contraseña
     * proporcionados. Si la conexión es exitosa, se devuelve el objeto
     * Connection, y se registra un mensaje informativo en el log. En
     * caso de que ocurra una excepción SQLException, se registran
     * mensajes de error junto con el stack trace.
     *
     * @return un objeto {@code Connection} si la conexión es exitosa, o
     * null si ocurre una excepción.
     */
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
