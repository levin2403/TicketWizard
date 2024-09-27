/**
 * HistorialCompraDAO.java.
 *
 * Clase que maneja la interacción con la base de datos para la entidad HistorialCompra.
 * Implementa la interfaz IHistorialCompraDAO.
 * Proporciona métodos para obtener el historial de compras de un usuario.
 */
package DAO;

import Conexion.Conexion;
import Entidades.HistorialCompra;
import Excepciones.DAOException;
import InterfacesDAO.IHistorialCompraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialCompraDAO implements IHistorialCompraDAO {

    private static final Logger logger = Logger.getLogger(HistorialCompraDAO.class.getName());

    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    /**
     * Constructor de la clase HistorialCompraDAO. Inicializa la conexión a la
     * base de datos y crea instancias de PersonaDAO y BoletoDAO.
     */
    public HistorialCompraDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }

    /**
     * Obtiene el historial de compras de un usuario de forma paginada.
     *
     * @param id el ID del usuario del que se desea obtener el historial
     * @param paginaActual la página actual de resultados
     * @param registrosPorPagina el número de registros a obtener por página
     * @return una lista de objetos HistorialCompra correspondientes al
     * historial de compras del usuario
     * @throws DAOException si hay un problema al obtener el historial de
     * compras
     */
    @Override
    public List<HistorialCompra> obtenerHistorialComprasPaginado(int id,
            int paginaActual, int registrosPorPagina) throws DAOException {
        List<HistorialCompra> historial = new ArrayList<>();
        int offset = (paginaActual - 1) * registrosPorPagina;

        String sql = "SELECT * FROM HistorialCompras WHERE id = ? LIMIT ? "
                + "OFFSET ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, registrosPorPagina);
            pstmt.setInt(3, offset);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HistorialCompra compra = new HistorialCompra();
                    compra.setId(rs.getInt("id"));
                    compra.setPersona(personaDAO.obtenerPersonaPorId(rs.getInt("id_persona")));
                    compra.setBoleto(boletoDAO.obtenerBoletoPorId(rs.getInt("id_boleto")));
                    compra.setFecha_compra(rs.getDate("fecha_venta"));
                    compra.setHora_compra(rs.getTime("hora_venta"));

                    historial.add(compra);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al consultar el historial de ventas", ex);
            throw new DAOException();
        }

        logger.log(Level.INFO, "Éxito al consultar el historial de ventas");
        return historial;
    }
}
