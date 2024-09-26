/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.HistorialVenta;
import Excepciones.DAOException;
import InterfacesDAO.IHistorialVentaDAO;
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
 * @author skevi
 */
public class HistorialVentaDAO implements IHistorialVentaDAO{

    private static final Logger logger = Logger.getLogger(HistorialVentaDAO.class.getName());
 
    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    public HistorialVentaDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }
    
    /**
     * 
     * @param id
     * @param limit
     * @param offset
     * @return
     * @throws DAOException 
     */
    @Override
    public List<HistorialVenta> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws DAOException {
        List<HistorialVenta> historialVentas = new ArrayList<>();
        String sql = "SELECT * FROM HistorialVenta WHERE id = ? LIMIT ? "
                + "OFFSET ?";

        try (Connection conn = conexion.crearConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurar los parámetros para la paginación
            stmt.setInt(1, id);
            stmt.setInt(2, limit);
            stmt.setInt(3, offset);

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    HistorialVenta historial = new HistorialVenta();
                    historial.setId(rs.getInt("id"));
                    historial.setVendedor(personaDAO.
                            obtenerPersonaPorId(rs.getInt("id_vendedor")));
                    historial.setComprador(personaDAO.
                            obtenerPersonaPorId(rs.getInt("id_comprador")));
                    historial.setBoleto(boletoDAO.
                            obtenerBoletoPorId(rs.getInt("id_boleto")));
                    historial.setPrecio_venta(rs.getBigDecimal("precio_venta"));
                    historial.setFecha_venta(rs.getDate("fecha_venta"));
                    historial.setHora_venta(rs.getTime("hora_venta"));

                    // Agregar el objeto HistorialVenta a la lista
                    historialVentas.add(historial);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error al obtener el historial de "
                    + "ventas en dao");
            throw new DAOException("Error al obtener el historial de"
                    + " ventas paginado.", e);
        }
        logger.log(Level.INFO, "exito al obtener el historial paginado en DAO");
        return historialVentas;
    }

}
