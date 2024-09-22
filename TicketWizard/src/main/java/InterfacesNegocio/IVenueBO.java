/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.VenueDTO;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public interface IVenueBO {
    
    public VenueDTO obtenerVenuePorId(int id) throws BOException;
    
}
