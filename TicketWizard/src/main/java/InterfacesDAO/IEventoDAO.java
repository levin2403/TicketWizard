/**
 * IEventoDAO.java
 * 
 * La interfaz IEventoDAO define las operaciones relacionadas con la 
 * gestión de eventos en la capa de acceso a datos. Proporciona métodos 
 * para obtener, buscar y filtrar eventos según diferentes criterios.
 */
package InterfacesDAO;

import Entidades.Evento;
import Excepciones.DAOException;
import java.sql.Date;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IEventoDAO {
    
     /**
     * Obtiene una lista paginada de eventos.
     *
     * @param pagina El número de la página que se desea obtener.
     * @param tamañoPagina El número de eventos por página.
     * @return Una lista de eventos en la página solicitada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Evento> obtenerEventos(int pagina, int tamañoPagina) 
            throws DAOException;

    /**
     * Busca eventos que contengan un texto específico en su nombre o descripción.
     *
     * @param texto El texto a buscar en los eventos.
     * @param pagina El número de la página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de eventos que coinciden con el texto de búsqueda.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Evento> buscarEventos(String texto, int pagina, 
            int tamanoPagina) throws DAOException;

    /**
     * Busca eventos que ocurran entre dos fechas específicas.
     *
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @param pagina El número de la página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de eventos que ocurren entre las fechas especificadas.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Evento> buscarEventosEntreFechas(Date fechaInicio, 
            Date fechaFin, int pagina, int tamanoPagina) throws DAOException;

    /**
     * Busca eventos que contengan un texto específico en su nombre o descripción 
     * y que ocurran entre dos fechas.
     *
     * @param texto El texto a buscar en los eventos.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @param pagina El número de la página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de eventos que coinciden con el texto de búsqueda y 
     *         ocurren entre las fechas especificadas.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Evento> buscarEventos(String texto, Date fechaInicio, 
        Date fechaFin, int pagina, int tamanoPagina) throws DAOException;

    /**
     * Obtiene un evento específico utilizando su ID.
     *
     * @param id El identificador único del evento que se desea obtener.
     * @return El evento correspondiente al ID especificado.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Evento obtenerEventoPorId(int id) throws DAOException;
    
}
