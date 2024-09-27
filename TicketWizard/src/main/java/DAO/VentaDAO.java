/**
 * VentaDAO.java.
 *
 * Clase que maneja la interacción con la base de datos para la entidad Venta.
 * Implementa la interfaz IVentaDAO.
 * Proporciona métodos para obtener las ventas de manera paginada,
 * filtrando por persona y rango de precios.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Venta;
import Excepciones.DAOException;
import InterfacesDAO.IVentaDAO;
import java.math.BigDecimal;
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

/**
 * Implementación de la interfaz IVentaDAO para gestionar la entidad Venta en la
 * base de datos.
 */
public class VentaDAO implements IVentaDAO {

    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    /**
     * Constructor de la clase VentaDAO. Inicializa la conexión a la base de
     * datos y las instancias de PersonaDAO y BoletoDAO.
     */
    public VentaDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }

    /**
     * Obtiene una lista de ventas paginadas, excluyendo las realizadas por la
     * persona en sesión.
     *
     * @param idPersona El ID de la persona en sesión, cuyo historial de ventas
     * no debe incluirse.
     * @param limit El número máximo de resultados a devolver por página.
     * @param offset El número de resultados a omitir, para la paginación.
     * @return Una lista de objetos Venta que cumplen con los criterios
     * especificados.
     * @throws DAOException Si ocurre un error al obtener las ventas paginadas.
     */
    @Override
    public List<Venta> obtenerVentasPaginadas(int idPersona, int limit,
            int offset) throws DAOException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Venta WHERE id_persona != ? "
                + "LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersona); // Excluir el ID de la persona en sesión
            pstmt.setInt(2, limit); // Límite de resultados por página
            pstmt.setInt(3, offset); // Offset (para paginación)

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setPersona(personaDAO.obtenerPersonaPorId(rs.getInt("id_persona")));
                venta.setBoleto(boletoDAO.obtenerBoletoPorId(rs.getInt("id_boleto")));
                venta.setPrecio_reventa(rs.getBigDecimal("precio_reventa"));
                venta.setFecha_limite(rs.getDate("fecha_limite_venta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo obtener las ventas paginadas", ex);
            throw new DAOException("Error al obtener las ventas paginadas");
        }

        logger.info("Boletos para venta obtenidos con éxito");
        return ventas;
    }

    /**
     * Obtiene una lista de ventas paginadas, filtrando por rango de precios y
     * excluyendo las realizadas por la persona en sesión.
     *
     * @param idPersona El ID de la persona en sesión, cuyo historial de ventas
     * no debe incluirse.
     * @param precioMin El precio mínimo de las ventas a incluir.
     * @param precioMax El precio máximo de las ventas a incluir.
     * @param limit El número máximo de resultados a devolver por página.
     * @param offset El número de resultados a omitir, para la paginación.
     * @return Una lista de objetos Venta que cumplen con los criterios
     * especificados.
     * @throws DAOException Si ocurre un error al obtener las ventas filtradas
     * por precio.
     */
    @Override
    public List<Venta> obtenerVentasPaginadasPorPrecio(int idPersona,
            BigDecimal precioMin, BigDecimal precioMax, int limit,
            int offset) throws DAOException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Venta WHERE id_cliente != ? "
                + "AND precio_reventa BETWEEN ? AND ? LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersona); // Excluir el ID de la persona en sesión
            pstmt.setBigDecimal(2, precioMin); // Precio mínimo
            pstmt.setBigDecimal(3, precioMax); // Precio máximo
            pstmt.setInt(4, limit); // Límite de resultados por página
            pstmt.setInt(5, offset); // Offset (para paginación)

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setPersona(personaDAO.obtenerPersonaPorId(rs.getInt("id_persona")));
                venta.setBoleto(boletoDAO.obtenerBoletoPorId(rs.getInt("id_boleto")));
                venta.setPrecio_reventa(rs.getBigDecimal("precio_reventa"));
                venta.setFecha_limite(rs.getDate("fecha_limite_venta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener las ventas por rango en DAO", ex);
            throw new DAOException("Error al obtener las ventas por rango");
        }

        logger.info("Boletos para venta obtenidos con éxito");
        return ventas;
    }
}
