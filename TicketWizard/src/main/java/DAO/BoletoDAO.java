/**
 * BoletoDAO.java.
 *
 * Clase que implementa los métodos de acceso a datos de la entidad Boleto.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Boleto;
import Excepciones.DAOException;
import InterfacesDAO.IBoletoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class BoletoDAO implements IBoletoDAO {

    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final EventoDAO eventoDAO;

    /**
     * Constructor de BoletoDAO.
     * Inicializa la conexión a la base de datos y el objeto EventoDAO.
     */
    public BoletoDAO() {
        this.conexion = new Conexion();
        this.eventoDAO = new EventoDAO();
    }

    /**
     * Método para obtener un Boleto por su ID.
     *
     * @param id El ID del boleto.
     * @return El objeto Boleto correspondiente al ID.
     * @throws DAOException Si ocurre un error al obtener el boleto.
     */
    @Override
    public Boleto obtenerBoletoPorId(int id) throws DAOException {
        String sql = "SELECT * FROM Boleto WHERE id = ?";  // Añadido "FROM Boleto"
        Boleto boleto = null;

        try (Connection conn = conexion.crearConexion(); // Utilizar la conexión existente
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    boleto = new Boleto();
                    boleto.setId(rs.getInt("id"));
                    boleto.setNumero_serie(rs.getString("numero_serie"));
                    boleto.setNumero_control(rs.getString("numero_control"));
                    boleto.setFila(rs.getString("fila"));
                    boleto.setAsiento(rs.getString("asiento"));
                    boleto.setPrecio_original(rs.getBigDecimal("precio_original"));
                    boleto.setEvento(eventoDAO.obtenerEventoPorId(rs.getInt("id_evento")));
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener el boleto por ID: {0}", ex.getMessage());
            throw new DAOException("Error al obtener el boleto por ID: " + id, ex);
        }
        return boleto;
    }
}
