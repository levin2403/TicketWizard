/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import DTOs.EventoDTO;
import DTOs.VenueDTO;
import Excepciones.BOException;
import Negocio.EventoBO;
import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        EventoBO eventoBO = new EventoBO();
        VenueDTO venue = new VenueDTO("1", "nombre", "ciudad", "estado");
        EventoDTO evento = new EventoDTO("nombre", new Date(2025, 03, 03), "descripcion", "imageURL", venue);

        try {
            
            eventoBO.registrarEvento(evento);   
            System.out.println("evento registrado con exito");
            
        } catch (BOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
