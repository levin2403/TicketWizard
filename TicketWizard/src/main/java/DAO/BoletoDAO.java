/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Boleto;
import Entidades.Tipo_boleto;
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
 * @author skevi
 */
public class BoletoDAO implements IBoletoDAO{
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final EventoDAO eventoDAO;

    public BoletoDAO() {
        this.conexion = new Conexion();
        this.eventoDAO = new EventoDAO();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public Boleto obtenerBoletoPorId(int id) throws DAOException{
        String sql = "SELECT * FROM Boleto WHERE id = ?";
        Boleto boleto = null;

        try (Connection conn = new Conexion().crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                boleto = new Boleto();
                boleto.setId(rs.getInt("id"));
                boleto.setPrecio(rs.getBigDecimal("precio"));
                boleto.setNumero_serie(rs.getString("numero_serie"));
                boleto.setNumero_control(rs.getString("numero_control"));
                boleto.setFila(rs.getString("fila"));
                boleto.setAsiento(rs.getString("asiento"));
                boleto.setTipo_boleto(Tipo_boleto.valueOf(rs.getString("tipo_boleto")));
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
