/**
 * 
 */
package Convertidores;

import Entidades.Domicilio;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioCVR {
    
    public Domicilio convertirAEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String ciudad = resultado.getString("ciudad");
        String colonia = resultado.getString("colonia");
        String calle = resultado.getString("calle");
        int numExterior = resultado.getInt("num_exterior");
        Integer numInterior = resultado.getObject("num_interior") != null ? resultado.getInt("num_interior") : null;
        int codigoPostal = resultado.getInt("codigo_postal");

        return new Domicilio(id, ciudad, colonia, calle, numExterior, numInterior, codigoPostal);
    }
}
