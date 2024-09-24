/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Venta;
import Excepciones.DAOException;
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
 * @author skevi
 */
public class VentaDAO {
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private PersonaDAO personaDAO;
    private BoletoDAO boletoDAO;

    public VentaDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }

    /**
     * 
     * @param idPersona
     * @param limit
     * @param offset
     * @return 
     */
    public List<Venta> obtenerVentasPaginadas(int idPersona, int limit, 
            int offset) throws DAOException {
            List<Venta> ventas = new ArrayList<>();
            String sql = "SELECT * FROM Venta WHERE id_persona != ? "
                    + "LIMIT ? OFFSET ?";

            try (Connection conn = conexion.crearConexion();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
                logger.log(Level.SEVERE, "no se pudo obtener las ventas paginadas", ex);
            }
            logger.info("Boletos para venta obtenidos con exito");
            return ventas;
        }
    
    
    /**
     * 
     * @param idPersona
     * @param precioMin
     * @param precioMax
     * @param limit
     * @param offset
     * @return 
     * @throws Excepciones.DAOException 
     */
    public List<Venta> obtenerVentasPaginadasPorPrecio(int idPersona, 
                BigDecimal precioMin, BigDecimal precioMax, int limit, 
                int offset) throws DAOException{
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Venta WHERE id_cliente != ? "
                + "AND precio_reventa BETWEEN ? AND ? LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
            logger.log(Level.SEVERE, "error al obtener las ventas por rango en DAO", ex);
            throw new DAOException("error al obtener las ventas");
        }
        
        logger.info("Boletos para venta obtenidos con exito");
        return ventas;
        
    }
    
    
    
    
 }

    

