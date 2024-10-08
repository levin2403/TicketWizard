/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author skevi
 */
public class HistorialCompraDAO implements IHistorialCompraDAO{

    private static final Logger logger = Logger.getLogger(HistorialCompraDAO.class.getName());
    
    private final Conexion conexion;
    private final PersonaDAO personaDAO;
    private final BoletoDAO boletoDAO;

    public HistorialCompraDAO() {
        this.conexion = new Conexion();
        this.personaDAO = new PersonaDAO();
        this.boletoDAO = new BoletoDAO();
    }
            
    /**
     * 
     * @param id
     * @param paginaActual
     * @param registrosPorPagina
     * @return 
     * @throws Excepciones.DAOException 
     */        
    @Override
    public List<HistorialCompra> obtenerHistorialComprasPaginado(int id, 
            int paginaActual, int registrosPorPagina) throws DAOException {
        List<HistorialCompra> historial = new ArrayList<>();
        int offset = (paginaActual - 1) * registrosPorPagina;

        String sql = "SELECT * FROM HistorialCompras WHERE id = ? LIMIT ? "
                + "OFFSET ?";
        
        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.setInt(2, registrosPorPagina);
            pstmt.setInt(3, offset);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HistorialCompra compra = new HistorialCompra();
                    compra.setId(rs.getInt("id"));
                    compra.setPersona(personaDAO.
                            obtenerPersonaPorId(rs.getInt("id_persona")));
                    compra.setBoleto(boletoDAO.
                            obtenerBoletoPorId(rs.getInt("id_boleto")));
                    compra.setFecha_compra(rs.getDate("fecha_venta"));
                    compra.setHora_compra(rs.getTime("hora_venta"));

                    historial.add(compra);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al consultar el historial de "
                    + "ventas", ex);
            throw new DAOException();
        } 
        logger.log(Level.INFO, "Exito al consultar el historial de ventas");
        return historial;
    }
    
}
