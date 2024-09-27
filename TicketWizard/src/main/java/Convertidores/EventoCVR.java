/**
 * EventoCVR.java.
 *
 * La clase EventoCVR se encarga de convertir entre objetos Evento y EventoDTO.
 * Proporciona métodos para realizar la conversión bidireccional entre las entidades de negocio
 * y los objetos de transferencia de datos, asegurando que las relaciones anidadas como Venue
 * también sean convertidas adecuadamente utilizando VenueCVR.
 *
 * Los métodos lanzan excepciones BOException si ocurre algún problema durante la conversión.
 *
 */
package Convertidores;

import DAO.EventoDAO;
import DTOs.EventoDTO;
import Entidades.Evento;
import Excepciones.BOException;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class EventoCVR {

    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    VenueCVR venueCVR;

    /**
     * Constructor que inicializa el conversor de Venue (VenueCVR) necesario
     * para convertir la relación Venue dentro de un Evento.
     */
    public EventoCVR() {
        this.venueCVR = new VenueCVR();
    }

    /**
     * Convierte un objeto Evento en un objeto EventoDTO. Si el objeto Evento es
     * nulo, se devuelve null.
     *
     * @param evento el objeto Evento a convertir
     * @return un objeto EventoDTO correspondiente, o null si el evento es nulo
     * @throws BOException si ocurre un error durante la conversión
     */
    public EventoDTO toDTO(Evento evento) throws BOException {
        try {
            if (evento == null) {
                return null;
            }

            return new EventoDTO(
                    String.valueOf(evento.getId()), // Convierte el ID de int a String
                    evento.getNombre(),
                    evento.getFecha(),
                    evento.getDescripcion(),
                    evento.getImageURL(),
                    venueCVR.toDTO(evento.getVenue()) // Convierte el objeto Venue relacionado
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    /**
     * Convierte un objeto EventoDTO en una entidad Evento. Si el objeto
     * EventoDTO es nulo, se devuelve null.
     *
     * @param eventoDTO el objeto EventoDTO a convertir
     * @return un objeto Evento correspondiente, o null si el DTO es nulo
     * @throws BOException si ocurre un error durante la conversión
     */
    public Evento toEntity(EventoDTO eventoDTO) throws BOException {
        try {
            if (eventoDTO == null) {
                return null;
            }

            return new Evento(
                    Integer.parseInt(eventoDTO.getId()), // Convierte el ID de String a int
                    eventoDTO.getNombre(),
                    eventoDTO.getFecha(),
                    eventoDTO.getDescripcion(),
                    eventoDTO.getImageURL(),
                    venueCVR.toEntity(eventoDTO.getVenue()) // Convierte el objeto Venue relacionado
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }
}
