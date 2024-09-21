/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Evento;
import Excepciones.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class EventoDAO {
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private Conexion conexion;
    private VenueDAO venueDAO;

    public EventoDAO() {
        this.conexion = new Conexion();
        this.venueDAO = new VenueDAO();
    }

    public List<Evento> obtenerEventos(int pagina, int tamañoPagina) throws DAOException{
        
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento LIMIT ? OFFSET ?"; // Consulta paginada

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Calcular el límite y el offset
            pstmt.setInt(1, tamañoPagina);
            pstmt.setInt(2, (pagina - 1) * tamañoPagina);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de errores
        }
        logger.info("lista de eventos paginada obtenida con exito");
        return eventos;
    }
    
    public List<Evento> buscarEventos(String texto) throws DAOException{
    List<Evento> eventos = new ArrayList<>();
    String sql = "SELECT * FROM Evento WHERE nombre LIKE ?";

    try (Connection conn = conexion.crearConexion();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Escapar caracteres especiales en el texto
        String busqueda = "%" + texto + "%";
        pstmt.setString(1, busqueda);
        pstmt.setString(2, busqueda);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setNombre(rs.getString("nombre"));
            evento.setFecha(rs.getDate("fecha"));
            evento.setDescripcion(rs.getString("descripcion"));
            evento.setImageURL(rs.getString("image_url"));
            evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
            eventos.add(evento);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de errores
    }
        return eventos;
    }
    
    public List<Evento> buscarEventosEntreFechas(Date fechaInicio, Date fechaFin) throws DAOException{
    List<Evento> eventos = new ArrayList<>();
    String sql = "SELECT * FROM Evento WHERE fecha BETWEEN ? AND ?";

    try (Connection conn = conexion.crearConexion();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setDate(1, (java.sql.Date) fechaInicio);
        pstmt.setDate(2, (java.sql.Date) fechaFin);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setNombre(rs.getString("nombre"));
            evento.setFecha(rs.getDate("fecha"));
            evento.setDescripcion(rs.getString("descripcion"));
            evento.setImageURL(rs.getString("image_url"));
            evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
            eventos.add(evento);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de errores
    }
       return eventos;
    }
   
    
    
}
