/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Evento;
import Excepciones.DAOException;
import InterfacesDAO.IEventoDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class EventoDAO implements IEventoDAO{
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final VenueDAO venueDAO;

    public EventoDAO() {
        this.conexion = new Conexion();
        this.venueDAO = new VenueDAO();
    }

    /**
     * 
     * @param limit
     * @param offset
     * @return
     * @throws DAOException 
     */
    @Override
    public List<Evento> obtenerEventos(int limit, int offset) 
            throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento LIMIT ? OFFSET ?"; //Consulta paginada

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Calcular el límite y el offset
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.
                        getInt("id_venue")));
                eventos.add(evento);
            }

            // Verifica si se obtuvieron registros
            if (eventos.isEmpty()) {
                System.out.println("No se encontraron eventos.");
            }
            else{
                System.out.println("si se encontraron eventos");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo obtener la lista de eventos"
                    + " paginada", ex);
            throw new DAOException("Problemas al obtener la lista paginada",
                    ex);
        }
        
        return eventos;
    }
    
    /**
     * 
     * @param texto
     * @param limit
     * @param offset
     * @return 
     * @throws Excepciones.DAOException 
     */
    @Override
    public List<Evento> buscarEventos(String texto, int limit, int offset) 
            throws DAOException{
        List<Evento> eventos = new ArrayList<>();

        String sql = "SELECT * FROM evento WHERE nombre LIKE ? LIMIT ? OFFSET ?";
        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + texto + "%");
            pstmt.setInt(2, limit);
            pstmt.setInt(3, offset);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Evento evento = new Evento();
                    evento.setId(rs.getInt("id"));
                    evento.setNombre(rs.getString("nombre"));
                    evento.setFecha(rs.getDate("fecha"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    evento.setImageURL(rs.getString("image_url"));
                    evento.setVenue(venueDAO.obtenerVenuePorId(rs.
                            getInt("id_venue")));
                    eventos.add(evento);
                }
            }
        } catch (SQLException e) {
            logger.severe("no se pudo obtener la lista de eventos paginada "
                    + "de busqueda por texto");
            throw new DAOException("problemas al obtener la lista paginada");
        }

        return eventos;
    }
    
    
    /**
     * 
     * @param fechaInicio
     * @param fechaFin
     * @param limit
     * @param offset
     * @return
     * @throws DAOException 
     */
    @Override
    public List<Evento> buscarEventosEntreFechas(Date fechaInicio, Date fechaFin, 
            int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento WHERE fecha BETWEEN ? AND ? LIMIT ? "
                + "OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, fechaInicio);
            pstmt.setDate(2, fechaFin);
            pstmt.setInt(3, limit);
            pstmt.setInt(4, offset);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.
                        obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            logger.severe("no se pudo obtener la lista de eventos paginada "
                    + "de busqueda por fecha");
            throw new DAOException("problemas al obtener la lista paginada "
                    + "de busqueda por fecha");
        }

        return eventos;
    }
   
    
    /**
     * 
     * @param texto
     * @param fechaInicio
     * @param fechaFin
     * @param limit
     * @param offset
     * @return
     * @throws DAOException 
     */
    @Override
    public List<Evento> buscarEventos(String texto, Date fechaInicio, 
        Date fechaFin, int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento WHERE nombre LIKE ? AND fecha "
                + "BETWEEN ? AND ? LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + texto + "%");
            pstmt.setDate(2, (java.sql.Date) fechaInicio);
            pstmt.setDate(3, (java.sql.Date) fechaFin);
            pstmt.setInt(4, limit);
            pstmt.setInt(5, offset);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.
                        obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            logger.severe("no se pudo obtener la lista de eventos paginada de "
                    + "busqueda por texto y fechas");
            throw new DAOException("problemas al obtener la lista paginada de "
                    + "busqueda por texto y fechas");
        }

        return eventos;
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    public Evento obtenerEventoPorId(int id) throws DAOException {
        String sql = "SELECT id, nombre, fecha, descripcion, image_url, "
                + "id_venue FROM Evento WHERE id = ?";
        Evento evento = null;

        try (Connection conn = new Conexion().crearConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.
                        obtenerVenuePorId(rs.getInt("id_venue")));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al obtener el evento por ID: {0}", 
                    ex.getMessage());
            throw new DAOException(ex.getMessage());
        }
        return evento;
        }

    @Override
    public void registrarEvento(Evento evento) throws DAOException{
        Connection conn = null;
        PreparedStatement pstmtEvento = null;

        try {
            // Obtener conexión utilizando la clase Conexion
            Conexion conexion = new Conexion();
            conn = conexion.crearConexion();

            // Verificar si la conexión es válida
            if (conn == null) {
                logger.log(Level.SEVERE, "No se pudo establecer la conexión a la base de datos.");
            }

            // Deshabilitar el auto-commit para comenzar la transacción
            conn.setAutoCommit(false);

            // Insertar el Evento
            String sqlInsertEvento = "INSERT INTO Evento(nombre, descripcion,"
                    + " fecha_hora, id_venue) VALUES(?, ?, ?, ?)";
            pstmtEvento = conn.prepareStatement(sqlInsertEvento);
            pstmtEvento.setString(1, evento.getNombre());
            pstmtEvento.setString(2, evento.getDescripcion());
            pstmtEvento.setString(3, evento.getImageURL()); 
            pstmtEvento.setInt(4, evento.getVenue().getId()); 
            pstmtEvento.executeUpdate();

            // Confirmar la transacción si todo salió bien
            conn.commit();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar el evento: {0}", 
                    e.getMessage());
            if (conn != null) {
                try {
                    // Si hay algún error, deshacer los cambios
                    conn.rollback();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "Error al realizar el rollback: "
                            + "{0}", ex.getMessage());
                }
            }
            throw new DAOException("Error al registrar el evento");
        } finally {
            // Cerrar los recursos en el orden correcto
            try {
                if (pstmtEvento != null) pstmtEvento.close();
                if (conn != null) conn.setAutoCommit(true); // Restaurar el auto-commit
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar los recursos: {0}", 
                        e.getMessage());
            }
        }
    }

    
}
