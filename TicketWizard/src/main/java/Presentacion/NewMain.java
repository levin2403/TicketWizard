/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;


import DAO.VentaDAO;
import DTOs.VentaDTO;
import Entidades.Venta;
import Excepciones.BOException;
import Excepciones.DAOException;
import Negocio.VentaBO;
import java.math.BigDecimal;
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
        
        VentaBO venta = new VentaBO();


        try {
            
            BigDecimal minimo = new BigDecimal(300.00);
            BigDecimal maximo = new BigDecimal(600.00);
            
            List<VentaDTO> lista;
            lista = venta.obtenerVentasPaginadasPorPrecio(1, 2, minimo, maximo, 4, 0);
            
            
            
        } catch (BOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
