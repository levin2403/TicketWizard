/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.VenueDTO;
import Excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IVenueBO {
    
    public List<VenueDTO> obtenerListaVenues() throws BOException;
    
}
