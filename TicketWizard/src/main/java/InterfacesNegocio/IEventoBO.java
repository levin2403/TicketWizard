/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.EventoDTO;
import Excepciones.BOException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IEventoBO {
    
     public List<EventoDTO> obtenerEventos(int pagina, int tamañoPagina) 
         throws BOException;

     public List<EventoDTO> buscarEventos(String texto, int pagina, 
             int tamanoPagina) throws BOException;

     public List<EventoDTO> buscarEventosEntreFechas(Date fechaInicio, 
             Date fechaFin,int pagina, int tamanoPagina) throws BOException;

     public List<EventoDTO> buscarEventos(String texto, Date fechaInicio, 
        Date fechaFin, int pagina, int tamanoPagina) throws BOException;
     
     public EventoDTO obtenerEventoPorId(int id) throws BOException;
     
       public void registrarEvento(EventoDTO evento) throws BOException;
}
