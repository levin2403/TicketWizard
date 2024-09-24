/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Boleto;
import Excepciones.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class BoletoDAO {
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private EventoDAO eventoDAO;

    public BoletoDAO() {
        this.conexion = new Conexion();
        this.eventoDAO = new EventoDAO();
    }
    
    
    public Boleto obtenerBoletoPorId(int id) throws DAOException{
        String sql = "SELECT * WHERE id = ?";
        Boleto boleto = null;

        try (Connection conn = new Conexion().crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

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
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener el boleto por ID: {0}", 
                    ex.getMessage());
            throw new DAOException("error al obtener el boleto por id");
        }
        return boleto;
    }
    
    

}
