/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.VenueCVR;
import DAO.VenueDAO;
import DTOs.VenueDTO;
import Entidades.Venue;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IVenueBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class VenueBO implements IVenueBO{

    private VenueDAO venueDAO;
    private VenueCVR venueCVR;

    public VenueBO() {
        this.venueDAO = new VenueDAO();
        this.venueCVR = new VenueCVR();
    }
    
    /**
     * 
     * @return
     * @throws BOException 
     */
    @Override
    public List<VenueDTO> obtenerListaVenues() throws BOException {
        try{
            List<Venue> lista = venueDAO.obtenerListaVenues();
            List<VenueDTO> listaDTO = new ArrayList<>();
            
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(venueCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        }
        catch(DAOException ex){
            throw new BOException();
        }
    }
    
    
    
}
