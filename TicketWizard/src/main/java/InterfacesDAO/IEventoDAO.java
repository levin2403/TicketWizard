/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Evento;
import Excepciones.DAOException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IEventoDAO {
    
     public List<Evento> obtenerEventos(int pagina, int tamañoPagina) 
             throws DAOException;
     
     public List<Evento> buscarEventos(String texto, int pagina, 
             int tamanoPagina) throws DAOException;
     
     public List<Evento> buscarEventosEntreFechas(Date fechaInicio, 
             Date fechaFin,int pagina, int tamanoPagina) throws DAOException;
     
     public List<Evento> buscarEventos(String texto, Date fechaInicio, 
        Date fechaFin, int pagina, int tamanoPagina) throws DAOException;
     
     public Evento obtenerEventoPorId(int id) throws DAOException;
    
     public void registrarEvento(Evento evento) throws DAOException;
     
}
