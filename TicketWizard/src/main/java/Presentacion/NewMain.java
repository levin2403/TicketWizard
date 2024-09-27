/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import DTOs.VentaDTO;
import Excepciones.BOException;
import Negocio.VentaBO;
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
            List<VentaDTO> lista = venta.obtenerVentasPaginadas(1, 4, 0, 1);
            
            if (lista != null) {
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            
            }else{
                System.out.println("La lista esta vacia, no jalo");
            }
            
            
        } catch (BOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
