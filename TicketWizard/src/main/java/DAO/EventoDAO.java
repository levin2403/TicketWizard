/**
 * EventoDAO.java.
 *
 * Clase que maneja la interacción con la base de datos para la entidad Evento.
 * Implementa la interfaz IEventoDAO.
 * Proporciona métodos para agregar, consultar y buscar eventos.
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class EventoDAO implements IEventoDAO {

    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    private final Conexion conexion;
    private final VenueDAO venueDAO;

    /**
     * Constructor de la clase EventoDAO. Inicializa la conexión a la base de
     * datos y crea una instancia de VenueDAO.
     */
    public EventoDAO() {
        this.conexion = new Conexion();
        this.venueDAO = new VenueDAO();
    }

    /**
     * Obtiene una lista de eventos de forma paginada.
     *
     * @param limit el número máximo de eventos a obtener
     * @param offset el número de eventos a omitir antes de comenzar a recuperar
     * @return una lista de eventos
     * @throws DAOException si hay un problema al obtener los eventos
     */
    @Override
    public List<Evento> obtenerEventos(int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento LIMIT ? OFFSET ?"; // Consulta paginada

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }

            // Verifica si se obtuvieron registros
            if (eventos.isEmpty()) {
                System.out.println("No se encontraron eventos.");
            } else {
                System.out.println("Se encontraron eventos.");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo obtener la lista de eventos paginada", ex);
            throw new DAOException("Problemas al obtener la lista paginada", ex);
        }

        return eventos;
    }

    /**
     * Busca eventos que contengan un texto específico en su nombre de forma
     * paginada.
     *
     * @param texto el texto a buscar en los nombres de los eventos
     * @param limit el número máximo de eventos a obtener
     * @param offset el número de eventos a omitir antes de comenzar a recuperar
     * @return una lista de eventos que coinciden con la búsqueda
     * @throws DAOException si hay un problema al buscar los eventos
     */
    @Override
    public List<Evento> buscarEventos(String texto, int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();

        String sql = "SELECT * FROM evento WHERE nombre LIKE ? LIMIT ? OFFSET ?";
        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
                    evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
                    eventos.add(evento);
                }
            }
        } catch (SQLException e) {
            logger.severe("No se pudo obtener la lista de eventos paginada de búsqueda por texto");
            throw new DAOException("Problemas al obtener la lista paginada");
        }

        return eventos;
    }

    /**
     * Busca eventos en un rango de fechas específico de forma paginada.
     *
     * @param fechaInicio la fecha de inicio del rango
     * @param fechaFin la fecha de fin del rango
     * @param limit el número máximo de eventos a obtener
     * @param offset el número de eventos a omitir antes de comenzar a recuperar
     * @return una lista de eventos que ocurren entre las fechas especificadas
     * @throws DAOException si hay un problema al buscar los eventos
     */
    @Override
    public List<Evento> buscarEventosEntreFechas(Date fechaInicio, Date fechaFin, int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento WHERE fecha BETWEEN ? AND ? LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            logger.severe("No se pudo obtener la lista de eventos paginada de búsqueda por fecha");
            throw new DAOException("Problemas al obtener la lista paginada de búsqueda por fecha");
        }

        return eventos;
    }

    /**
     * Busca eventos que contengan un texto específico en su nombre y que
     * ocurran dentro de un rango de fechas de forma paginada.
     *
     * @param texto el texto a buscar en los nombres de los eventos
     * @param fechaInicio la fecha de inicio del rango
     * @param fechaFin la fecha de fin del rango
     * @param limit el número máximo de eventos a obtener
     * @param offset el número de eventos a omitir antes de comenzar a recuperar
     * @return una lista de eventos que coinciden con la búsqueda
     * @throws DAOException si hay un problema al buscar los eventos
     */
    @Override
    public List<Evento> buscarEventos(String texto, Date fechaInicio, Date fechaFin, int limit, int offset) throws DAOException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento WHERE nombre LIKE ? AND fecha BETWEEN ? AND ? LIMIT ? OFFSET ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + texto + "%");
            pstmt.setDate(2, fechaInicio);
            pstmt.setDate(3, fechaFin);
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
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            logger.severe("No se pudo obtener la lista de eventos paginada de búsqueda por texto y fechas");
            throw new DAOException("Problemas al obtener la lista paginada de búsqueda por texto y fechas");
        }

        return eventos;
    }

    /**
     * Obtiene un evento específico por su ID.
     *
     * @param id el ID del evento a obtener
     * @return el evento correspondiente al ID, o null si no se encuentra
     * @throws DAOException si hay un problema al obtener el evento
     */
    @Override
    public Evento obtenerEventoPorId(int id) throws DAOException {
        String sql = "SELECT id, nombre, fecha, descripcion, image_url, id_venue FROM Evento WHERE id = ?";
        Evento evento = null;

        try (Connection conn = new Conexion().crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImageURL(rs.getString("image_url"));
                evento.setVenue(venueDAO.obtenerVenuePorId(rs.getInt("id_venue")));
            }
        } catch (SQLException ex) {
            logger.severe("No se pudo obtener el evento por ID");
            throw new DAOException("Problemas al obtener el evento por ID", ex);
        }

        return evento;
    }

    /**
     * Agrega un nuevo evento a la base de datos.
     *
     * @param evento el evento a agregar
     * @throws DAOException si hay un problema al agregar el evento
     */
    public void agregar(Evento evento) throws DAOException {
        String sql = "INSERT INTO Evento (nombre, fecha, descripcion, image_url, id_venue) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = new Conexion().crearConexion(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, evento.getNombre());
            pstmt.setDate(2, evento.getFecha());
            pstmt.setString(3, evento.getDescripcion());
            pstmt.setString(4, evento.getImageURL());
            pstmt.setInt(5, evento.getVenue().getId());

            pstmt.executeUpdate();

            // Obtener la clave generada para el evento
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    evento.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            logger.severe("No se pudo agregar el evento");
            throw new DAOException("Problemas al agregar el evento", ex);
        }
    }
}
