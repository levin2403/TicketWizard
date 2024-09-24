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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        EventoDAO evento = new EventoDAO();
        String nombre = "sno";
        
        // Crear fechas usando java.sql.Date
        Date fecha1 = Date.valueOf("2025-01-01");
        Date fecha2 = Date.valueOf("2025-12-30");

        try {
            // Llamada al método buscarEventosEntreFechas
            List<Evento> lista = evento.buscarEventos(nombre, fecha1, fecha2, 4, 0);
            
            // Mostrar resultados
            for (Evento ev : lista) {
                System.out.println(ev.toString());
            }
        } catch (DAOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
