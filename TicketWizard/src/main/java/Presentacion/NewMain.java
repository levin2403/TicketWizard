/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import Excepciones.BOException;
import Negocio.PersonaBO;
import java.math.BigDecimal;
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
        
        PersonaBO personaBO = new PersonaBO();

        try {
            
            BigDecimal saldo = personaBO.consultarSaldo(1);
            System.out.println(saldo);
            
        } catch (BOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
