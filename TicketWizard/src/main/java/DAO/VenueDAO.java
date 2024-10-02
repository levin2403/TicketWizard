/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class VenueDAO implements IVenueDAO{
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private Conexion conexion;

    public VenueDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    @Override
    public Venue obtenerVenuePorId(int id) throws DAOException{
        Venue venue = null;
        String sql = "SELECT * FROM Venue WHERE id = ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
            throw new DAOException("error al obtener el venue en dao", ex);
        }
        logger.info("venue obtenido con exito");
        return venue;
    }
    
    public List<Venue> obtenerListaVenues() throws DAOException{
        List<Venue> venue = new ArrayList<>();
        String sql = "SELECT * FROM Venue";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venue venues = new Venue();
                venues.setId(rs.getInt("id"));
                venues.setNombre(rs.getString("nombre"));
                venues.setCiudad(rs.getString("ciudad"));
                venues.setEstado(rs.getString("estado"));
                venue.add(venues);
            }
        } catch (SQLException ex) {
            logger.severe("Error al obtener el venue");
            throw new DAOException("error al obtener los venues en dao", ex);
        }
        logger.info("venues obtenido con exito");
        return venue;
    }
    
}
