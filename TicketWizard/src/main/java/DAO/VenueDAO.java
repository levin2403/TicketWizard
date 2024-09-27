/**
 * VenueDAO.java
 *
 * Clase que maneja la interacción con la base de datos para la entidad Venue.
 * Implementa la interfaz IVenueDAO.
 * Proporciona métodos para obtener un venue a partir de su ID.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Venue;
import Excepciones.DAOException;
import InterfacesDAO.IVenueDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */

/**
 * Implementación de la interfaz IVenueDAO para gestionar la entidad Venue en la
 * base de datos.
 */
public class VenueDAO implements IVenueDAO {

    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;

    /**
     * Constructor de la clase VenueDAO. Inicializa la conexión a la base de
     * datos.
     */
    public VenueDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Obtiene un objeto Venue a partir de su ID.
     *
     * @param id El ID del venue a obtener.
     * @return El objeto Venue correspondiente al ID especificado, o null si no
     * se encuentra.
     * @throws DAOException Si ocurre un error al obtener el venue de la base de
     * datos.
     */
    @Override
    public Venue obtenerVenuePorId(int id) throws DAOException {
        Venue venue = null;
        String sql = "SELECT * FROM Venue WHERE id = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                venue = new Venue();
                venue.setId(rs.getInt("id"));
                venue.setNombre(rs.getString("nombre"));
                venue.setCiudad(rs.getString("ciudad"));
                venue.setEstado(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            logger.severe("Error al obtener el venue");
            throw new DAOException("Error al obtener el venue en DAO", ex);
        }

        logger.info("Venue obtenido con éxito");
        return venue;
    }
}
