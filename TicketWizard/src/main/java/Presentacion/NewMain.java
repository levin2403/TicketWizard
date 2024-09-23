/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import DAO.EventoDAO;
import DTOs.EventoDTO;
import Entidades.Evento;
import Excepciones.BOException;
import Excepciones.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventoDAO evento = new EventoDAO();
        String  nombre = "JACON";
        
        try{
            List<Evento> lista = evento.obtenerEventos(4, 0);
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            
        }
        catch(DAOException ex){
            System.out.println("no jalo");
        }
    }
    
}
