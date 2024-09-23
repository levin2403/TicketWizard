/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.EventoCVR;
import DAO.EventoDAO;
import DTOs.EventoDTO;
import Entidades.Evento;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IEventoBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author skevi
 */
public class EventoBO implements IEventoBO{

    EventoDAO eventoDAO;
    EventoCVR eventoCVR;

    public EventoBO() {
        this.eventoDAO = new EventoDAO();
        this.eventoCVR = new EventoCVR();
    }
    
    
    @Override
    public List<EventoDTO> obtenerEventos(int pagina, int tamañoPagina) throws BOException {
        try{
            List<Evento> lista = eventoDAO.obtenerEventos(pagina, tamañoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch(DAOException ex){
            throw new BOException("error al obtener la lista en negocio");
        }
    }

    @Override
    public List<EventoDTO> buscarEventos(String texto, int pagina, int tamanoPagina) throws BOException {
        try{
            List<Evento> lista = eventoDAO.buscarEventos(texto, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch(DAOException ex){
            throw new BOException();    
        }    
    }

    @Override
    public List<EventoDTO> buscarEventosEntreFechas(Date fechaInicio, Date fechaFin, int pagina, int tamanoPagina) throws BOException {
        try{
            List<Evento> lista = eventoDAO.buscarEventosEntreFechas(fechaInicio, fechaFin, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch(DAOException ex){
            throw new BOException(); 
        }    
    }

    @Override
    public List<EventoDTO> buscarEventos(String texto, Date fechaInicio, Date fechaFin, int pagina, int tamanoPagina) throws BOException {
         try{
            List<Evento> lista = eventoDAO.buscarEventos(texto, fechaInicio, fechaFin, pagina, tamanoPagina);
            List<EventoDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(eventoCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        } catch(DAOException ex){
            throw new BOException();     
        }    
    }
    
}
