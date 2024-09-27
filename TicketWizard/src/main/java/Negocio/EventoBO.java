/**
 * EventoBO.java
 * 
 * La clase EventoBO implementa la lógica de negocio para manejar operaciones relacionadas 
 * con eventos. Implementa la interfaz IEventoBO y utiliza un objeto de acceso a datos 
 * (DAO) para interactuar con la base de datos.
 */
package Negocio;

import Convertidores.EventoCVR;
import DAO.EventoDAO;
import DTOs.EventoDTO;
import Entidades.Evento;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IEventoBO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class EventoBO implements IEventoBO{

    EventoDAO eventoDAO;
    EventoCVR eventoCVR;

    /**
     * Constructor de EventoBO que inicializa el DAO y el convertidor.
     */
    public EventoBO() {
        this.eventoDAO = new EventoDAO();
        this.eventoCVR = new EventoCVR();
    }

    /**
     * Obtiene una lista de eventos paginada.
     *
     * @param pagina El número de página que se desea obtener.
     * @param tamañoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que representan los eventos.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public List<EventoDTO> obtenerEventos(int pagina, int tamañoPagina) throws BOException {
        try {
            List<Evento> lista = eventoDAO.obtenerEventos(pagina, tamañoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BOException("Error al obtener la lista en negocio");
        }
    }

    /**
     * Busca eventos que coincidan con el texto proporcionado en una lista paginada.
     *
     * @param texto El texto a buscar en los eventos.
     * @param pagina El número de página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que representan los eventos encontrados.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public List<EventoDTO> buscarEventos(String texto, int pagina, int tamanoPagina) throws BOException {
        try {
            List<Evento> lista = eventoDAO.buscarEventos(texto, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BOException();    
        }    
    }

    /**
     * Busca eventos entre dos fechas en una lista paginada.
     *
     * @param fechaInicio La fecha de inicio del rango a buscar.
     * @param fechaFin La fecha de fin del rango a buscar.
     * @param pagina El número de página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que representan los eventos encontrados.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public List<EventoDTO> buscarEventosEntreFechas(Date fechaInicio, Date fechaFin, int pagina, int tamanoPagina) throws BOException {
        try {
            List<Evento> lista = eventoDAO.buscarEventosEntreFechas(fechaInicio, fechaFin, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BOException(); 
        }    
    }

    /**
     * Busca eventos que coincidan con el texto y estén dentro de un rango de fechas en una lista paginada.
     *
     * @param texto El texto a buscar en los eventos.
     * @param fechaInicio La fecha de inicio del rango a buscar.
     * @param fechaFin La fecha de fin del rango a buscar.
     * @param pagina El número de página que se desea obtener.
     * @param tamanoPagina El número de eventos por página.
     * @return Una lista de objetos EventoDTO que representan los eventos encontrados.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public List<EventoDTO> buscarEventos(String texto, Date fechaInicio, Date fechaFin, int pagina, int tamanoPagina) throws BOException {
        try {
            List<Evento> lista = eventoDAO.buscarEventos(texto, fechaInicio, fechaFin, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BOException();     
        }    
    }

    /**
     * Obtiene un evento por su identificador.
     *
     * @param id El identificador del evento a consultar.
     * @return Un objeto EventoDTO que representa el evento encontrado.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public EventoDTO obtenerEventoPorId(int id) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Agrega un nuevo evento a la base de datos.
     *
     * @param eventoDTO El objeto EventoDTO que contiene la información del evento a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public void agregar(EventoDTO eventoDTO) throws BOException {
        try {
            // Convertir el DTO a entidad
            Evento evento = eventoCVR.toEntity(eventoDTO);

            // Agregar la entidad Evento usando el DAO
            eventoDAO.agregar(evento);
        } catch (DAOException ex) {
            throw new BOException("Error al agregar el evento: " + ex.getMessage());
        }
    } 
}
