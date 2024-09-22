/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DAO.EventoDAO;
import DTOs.EventoDTO;
import Entidades.Evento;
import Excepciones.BOException;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class EventoCVR {
    
    private static final Logger logger = Logger.getLogger(EventoDAO.class.getName());
    VenueCVR venueCVR;

    public EventoCVR() {
        this.venueCVR = new VenueCVR();
    }
    
    
    public EventoDTO toDTO(Evento evento) throws BOException{
        try{
        if (evento == null) {
            return null;
        }    

        return new EventoDTO(
           String.valueOf(evento.getId()),
           evento.getNombre(),
           evento.getFecha(),
           evento.getDescripcion(),
           evento.getImageURL(),
           venueCVR.toDTO(evento.getVenue())
       ); 
       } catch(BOException ex){
            throw new BOException(ex.getMessage());
       }
    }
    
    public Evento toEntity(EventoDTO eventoDTO) throws BOException{
        try{
            if (eventoDTO == null) {
                return null;
            }  
            
        return new Evento(
           Integer.parseInt(eventoDTO.getId()),
           eventoDTO.getNombre(),
           eventoDTO.getFecha(),
           eventoDTO.getDescripcion(),
           eventoDTO.getImageURL(),
           venueCVR.toEntity(eventoDTO.getVenue())
        );
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
