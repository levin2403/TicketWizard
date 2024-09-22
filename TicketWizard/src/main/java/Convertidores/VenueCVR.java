/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DAO.EventoDAO;
import DTOs.VenueDTO;
import Entidades.Venue;
import Excepciones.BOException;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class VenueCVR {
    
    /**
     * 
     * @param venue
     * @return
     * @throws BOException 
     */
    public VenueDTO toDTO(Venue venue) throws BOException {
        try {
            if (venue == null) {
                throw new IllegalArgumentException("El objeto Venue no puede ser null");
            }
            return new VenueDTO(
                String.valueOf(venue.getId()),
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
     * 
     * @param venueDTO
     * @return
     * @throws BOException 
     */
    public Venue toEntity(VenueDTO venueDTO) throws BOException {
        try {
            if (venueDTO == null) {
                throw new IllegalArgumentException("El objeto VenueDTO no puede ser null");
            }
            return new Venue(
                Integer.parseInt(venueDTO.getId()),
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
