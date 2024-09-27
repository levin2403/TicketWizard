/**
 * IEventoBO.java
 * 
 * La interfaz IEventoBO define las operaciones relacionadas con 
 * la gestión de eventos en la capa de negocio. 
 * Proporciona métodos para obtener, buscar y agregar eventos.
 */
package InterfacesNegocio;

import DTOs.EventoDTO;
import Excepciones.BOException;
import java.sql.Date;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IEventoBO {
    
     /**
     * Obtiene una lista paginada de eventos.
     *
     * @param pagina El número de página a obtener.
     * @param tamañoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO correspondiente a la página solicitada.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<EventoDTO> obtenerEventos(int pagina, int tamañoPagina) 
         throws BOException;

    /**
     * Busca eventos que coincidan con el texto proporcionado.
     *
     * @param texto El texto a buscar en los eventos.
     * @param pagina El número de página a obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que coinciden con la búsqueda.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<EventoDTO> buscarEventos(String texto, int pagina, 
             int tamanoPagina) throws BOException;

    /**
     * Busca eventos entre las fechas especificadas.
     *
     * @param fechaInicio La fecha de inicio del rango de búsqueda.
     * @param fechaFin La fecha de fin del rango de búsqueda.
     * @param pagina El número de página a obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que se encuentran dentro del rango de fechas.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<EventoDTO> buscarEventosEntreFechas(Date fechaInicio, 
             Date fechaFin,int pagina, int tamanoPagina) throws BOException;

    /**
     * Busca eventos que coincidan con el texto proporcionado y 
     * que se encuentren dentro de un rango de fechas.
     *
     * @param texto El texto a buscar en los eventos.
     * @param fechaInicio La fecha de inicio del rango de búsqueda.
     * @param fechaFin La fecha de fin del rango de búsqueda.
     * @param pagina El número de página a obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que coinciden con la búsqueda y el rango de fechas.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<EventoDTO> buscarEventos(String texto, Date fechaInicio, 
        Date fechaFin, int pagina, int tamanoPagina) throws BOException;
     
    /**
     * Obtiene un evento basado en su identificador.
     *
     * @param id El identificador del evento que se desea obtener.
     * @return Un objeto EventoDTO que representa el evento correspondiente al id proporcionado.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public EventoDTO obtenerEventoPorId(int id) throws BOException;
    
    /**
     * Agrega un nuevo evento.
     *
     * @param eventoDTO El objeto EventoDTO que contiene la información del evento a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void agregar(EventoDTO eventoDTO) throws BOException;
}
