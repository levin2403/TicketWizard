/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;


import DAO.VentaDAO;
import DTOs.BoletoDTO;
import DTOs.DomicilioDTO;
import DTOs.EventoDTO;
import DTOs.HistorialCompraDTO;
import DTOs.PersonaDTO;
import DTOs.Persona_BoletoDTO;
import DTOs.VentaDTO;
import DTOs.VenueDTO;
import Entidades.Boleto;
import Entidades.Domicilio;
import Entidades.Evento;
import Entidades.HistorialCompra;
import Entidades.Persona;
import Entidades.Tipo_boleto;
import Entidades.Venta;
import Entidades.Venue;
import Excepciones.BOException;
import Excepciones.DAOException;
import Negocio.EventoBO;
import Negocio.HistorialCompraBO;
import Negocio.Persona_BoletoBO;
import Negocio.VentaBO;
import Negocio.VenueBO;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
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
        
        BigDecimal precio = new BigDecimal(803.00);
        BigDecimal precio_original = new BigDecimal(123.123);
        BigDecimal saldo = new BigDecimal(123.123);
        Date fecha = new Date(System.currentTimeMillis());;
        
        DomicilioDTO domicilioDTO = new DomicilioDTO("1", "asdasd", "asdasd", "asdasd", 123, 123, 123);
        VenueDTO venueDTO = new VenueDTO("1", "asd", "asd", "asd");
        EventoDTO eventoDTO = new EventoDTO("2", "nombre", fecha, "descripcion", "URL", venueDTO);
        BoletoDTO boletoDTO = new BoletoDTO("12", precio, "serie", "control", "fila", "asiento", "BOLETERA", precio_original, eventoDTO);
        PersonaDTO personaDTO = new PersonaDTO("1", "nombre", "contraseña", fecha, "correo", saldo, domicilioDTO, "llave");
        PersonaDTO personaDTO2 = new PersonaDTO("2", "nombre", "contraseña", fecha, "correo", saldo, domicilioDTO, "llave");
        VentaDTO ventaDTO = new VentaDTO("5", personaDTO, boletoDTO, precio, fecha, "DISPONIBLE");

//        Domicilio domicilio = new Domicilio(1, "asdasd", "asdasd", "asdasd", 123, 123, 123);
//        Venue venue = new Venue(1, "asd", "asd", "asd");
//        Evento evento = new Evento(2, "nombre", fecha, "descripcion", "URL", venue);
//        Boleto boleto = new Boleto(1, precio, "serie", "control", "fila", "asiento", Tipo_boleto.BOLETERA, precio_original, evento);
//        Persona persona = new Persona(1, "nombre", "contraseña", fecha, "correo", saldo, domicilio, "llave");
//        Persona persona2 = new Persona(1, "nombre", "contraseña", fecha, "correo", saldo, domicilio, "llave");
//        Venta venta = new Venta(1, persona, boleto, precio, fecha, "estado");
        
        HistorialCompraBO ventaBO = new HistorialCompraBO();
        
        BigDecimal minimo = new BigDecimal(300.0);
        BigDecimal maximo = new BigDecimal(700.0);
        
        try{
            List<HistorialCompraDTO> lista = ventaBO.obtenerHistorialComprasPaginado(1, 11, 0);
            
            if (lista.isEmpty()) {
                System.out.println("lista vacia");
            }
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
        }
        catch(BOException ex){
            System.out.println("error: " + ex.getMessage());
        }
            
    }   
}
