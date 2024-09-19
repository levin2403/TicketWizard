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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. Daniel Alejandro Castro
 * Félix - 235294.
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

        // Crear una instancia de PersonaDTO
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre("Juan Pérez");
        personaDTO.setContraseña("miContrasena");
        personaDTO.setCorreo("juan.perez@ejemplo.com");
        personaDTO.setSaldo(new BigDecimal("1000.50"));

        // Asignar una fecha de nacimiento válida
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = formatoFecha.parse("1990-05-15");
            personaDTO.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Asignar un DomicilioDTO válido
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCiudad("Ciudad Ejemplo");
        domicilioDTO.setColonia("Colonia Ejemplo");
        domicilioDTO.setCalle("Calle Ejemplo");
        domicilioDTO.setNumExterior(123);
        domicilioDTO.setNumInterior(10);
        domicilioDTO.setCodigoPostal(12345);

        personaDTO.setDomicilioDto(domicilioDTO);
        
        // Generar una clave única para generatedKey
        String generatedKey = UUID.randomUUID().toString(); // Generar un UUID
        personaDTO.setGeneratedKey(generatedKey);

        // Ahora puedes usar personaDTO con una fecha de nacimiento válida
        try {
            personaBO.agregar(personaDTO);  // Aquí se invocará el método agregar
            System.out.println("Persona agregada exitosamente.");
        } catch (BOException e) {
            System.err.println("Error al agregar la persona: " + e.getMessage());
        }
        // Probar el método consultarContrasena
        String correo = "juan.perez@ejemplo.com";
        String contrasena = "miContrasena";  // La misma que se usó para crear personaDTO

        try {
            boolean esValido = personaBO.consultarContrasena(correo, contrasena);

            if (esValido) {
                System.out.println("La combinación de correo y contraseña es válida.");
            } else {
                System.out.println("Correo o contraseña incorrectos.");
            }

        } catch (BOException e) {
            System.err.println("Error al consultar la contraseña: " + e.getMessage());
        }

        // Probar la consulta por correo
        try {
            PersonaDTO personaConsultada = personaBO.consultar(correo);

            if (personaConsultada != null) {
                System.out.println("Persona encontrada: " + personaConsultada.getNombre());
            } else {
                System.out.println("No se encontró a la persona.");
            }

        } catch (BOException e) {
            System.err.println("Error al consultar la persona: " + e.getMessage());
        }
        
    }

}
