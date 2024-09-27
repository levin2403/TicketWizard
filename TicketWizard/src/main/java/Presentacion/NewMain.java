/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;


import DAO.VentaDAO;
import Entidades.Venta;
import Excepciones.DAOException;
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
        
        VentaDAO venta = new VentaDAO();


        try {
            List<Venta> lista;
            lista = venta.obtenerVentasPaginadasPorPrecio(1, 2, BigDecimal(200.00), BigDecimal(600.00), 4, 0);
            
            if (lista != null) {
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            
            }else{
                System.out.println("La lista esta vacia, no jalo");
            }
            
            
        } catch (DAOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
