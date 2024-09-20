/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import DTOs.PersonaDTO;
import Excepciones.BOException;
import Negocio.PersonaBO;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaBO persona = new PersonaBO();
        
        try{
            boolean personaDTO = persona.consultarPorCorreoYContrasena("kevin@gmail.com", "Cq1woIfMR3kPNmo+bs/JAQ==");
            
            if (personaDTO) {
                System.out.println("si existe");
            }
            else{
                System.out.println("no existe");
            }
        }
        catch(BOException ex){
            System.out.println("no jalo");
        }
    }
    
}
