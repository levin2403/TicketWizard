/**
 * IConexion.java. 
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

    /**
     * Establece y devuelve una conexión a la base de datos.
     *
     * Este método intenta crear una conexión con la base de datos utilizando
     * los parámetros de conexión predefinidos (cadena de conexión, usuario, y
     * contraseña). En caso de éxito, devuelve un objeto {@code Connection}.
     *
     * @return una instancia de Connection si la conexión es exitosa.
     * @throws SQLException si ocurre un error al intentar establecer la
     * conexión a la base de datos. Este error debe ser manejado por el código
     * que llame al método.
     */
    public Connection crearConexion() throws SQLException;

}
