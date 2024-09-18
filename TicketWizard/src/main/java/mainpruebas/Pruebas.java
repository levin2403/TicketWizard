/**
 *
 */
package mainpruebas;

import DTOs.DomicilioDTO;
import DTOs.PersonaDTO;
import Excepciones.BOException;
import InterfacesNegocio.IDomicilioBO;
import InterfacesNegocio.IPersonaBO;
import Negocio.DomicilioBO;
import Negocio.PersonaBO;

/**
 *
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. 
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear instancias de PersonaBO y DomicilioBO
        IPersonaBO personaBO = new PersonaBO();

        try {
            // Crear un DomicilioDTO
            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setCalle("Av. Siempre Viva");
            domicilioDTO.setNumExterior(742);
            domicilioDTO.setCiudad("Springfield");
            domicilioDTO.setColonia("Cologne");
            domicilioDTO.setCodigoPostal(62704);

            // Crear una PersonaDTO
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setId("123");
            personaDTO.setNombre("Homero Simpson");
            personaDTO.setContraseña("password123");
            // Convertir java.util.Date a java.sql.Date
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            personaDTO.setFechaNacimiento(sqlDate);
            personaDTO.setCorreo("homero@springfield.com");
            personaDTO.setSaldo(new java.math.BigDecimal("100.00"));
            personaDTO.setDomicilioDto(domicilioDTO); // Asignar el domicilio a la persona
            personaDTO.setGeneratedKey("generated-key-123");

            // Agregar la Persona (que agregará el domicilio si es necesario)
            personaBO.agregar(personaDTO);
            System.out.println("Persona agregada con éxito.");

            // Consultar la Persona
            PersonaDTO personaConsultada = personaBO.consultar("homero@springfield.com");
            System.out.println("Persona consultada: " + personaConsultada.getNombre());

            // Consultar la contraseña
            boolean esContrasenaValida = personaBO.consultarContrasena("homero@springfield.com", "password123");
            System.out.println("Contraseña válida: " + esContrasenaValida);

        } catch (BOException e) {
            e.printStackTrace();
        }
    }

}
