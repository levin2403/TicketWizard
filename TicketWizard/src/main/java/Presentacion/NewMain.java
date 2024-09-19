/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import DTOs.DomicilioDTO;
import DTOs.PersonaDTO;
import Excepciones.BOException;
import Negocio.PersonaBO;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaBO personaBO = new PersonaBO();
        
        try{
            PersonaDTO persona= new PersonaDTO(
                "9",
                "levin",
                "coyote",
                new Date(),
                "levin@gmail.com",
                new BigDecimal(400.0),
                new DomicilioDTO(
                    "9",
                    "asdasd",
                    "asdasdasd",
                    "asdasdasdasd",
                    12,
                    32,
                    42    
                ),
                "llave nueva"
            );
            personaBO.actualizar(persona);
        }
        catch(BOException ex){
            System.out.println("fallo al actualizar la persona");
        }
    }
    
}
