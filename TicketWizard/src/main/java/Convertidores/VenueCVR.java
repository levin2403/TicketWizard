/**
 * VenueCVR.java.
 *
 * La clase VenueCVR se encarga de convertir entre objetos Venue y VenueDTO.
 * Proporciona métodos para realizar la conversión de entidades Venue a su equivalente en DTO y viceversa.
 *
 */
package Convertidores;

import DTOs.VenueDTO;
import Entidades.Venue;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class VenueCVR {

    /**
     * Convierte una entidad Venue en un objeto VenueDTO.
     *
     * @param venue la entidad Venue a convertir
     * @return el objeto VenueDTO correspondiente
     * @throws BOException si ocurre un error durante la conversión
     * @throws IllegalArgumentException si el objeto Venue es null
     */
    public VenueDTO toDTO(Venue venue) throws BOException {
        try {
            if (venue == null) {
                throw new IllegalArgumentException("El objeto Venue no puede ser null");
            }
            return new VenueDTO(
                    String.valueOf(venue.getId()), // Convertir el ID de int a String
                    venue.getNombre(),
                    venue.getCiudad(),
                    venue.getEstado()
            );
        } catch (NullPointerException e) {
            throw new BOException("Error: El objeto Venue tiene campos nulos", e);
        } catch (IllegalArgumentException e) {
            throw new BOException("Error: Argumento ilegal al convertir Venue a VenueDTO", e);
        } catch (Exception e) {
            throw new BOException("Error inesperado al convertir Venue a VenueDTO", e);
        }
    }

    /**
     * Convierte un objeto VenueDTO en una entidad Venue.
     *
     * @param venueDTO el objeto VenueDTO a convertir
     * @return la entidad Venue correspondiente
     * @throws BOException si ocurre un error durante la conversión
     * @throws IllegalArgumentException si el objeto VenueDTO es null
     * @throws NumberFormatException si el ID del VenueDTO no es un número
     * válido
     */
    public Venue toEntity(VenueDTO venueDTO) throws BOException {
        try {
            if (venueDTO == null) {
                throw new IllegalArgumentException("El objeto VenueDTO no puede ser null");
            }
            return new Venue(
                    Integer.parseInt(venueDTO.getId()), // Convertir el ID de String a int
                    venueDTO.getNombre(),
                    venueDTO.getCiudad(),
                    venueDTO.getEstado()
            );
        } catch (NumberFormatException e) {
            throw new BOException("Error: El ID del VenueDTO no es un número válido", e);
        } catch (NullPointerException e) {
            throw new BOException("Error: El objeto VenueDTO tiene campos nulos", e);
        } catch (IllegalArgumentException e) {
            throw new BOException("Error: Argumento ilegal al convertir VenueDTO a Venue", e);
        } catch (Exception e) {
            throw new BOException("Error inesperado al convertir VenueDTO a Venue", e);
        }
    }
}
