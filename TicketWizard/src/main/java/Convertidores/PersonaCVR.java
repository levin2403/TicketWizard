/**
 *
 */
package Convertidores;

import DTOs.PersonaDTO;
import Entidades.Persona;
import Entidades.Domicilio;

/**
 *
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. 
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class PersonaCVR {

    public Persona convertirAEntidad(PersonaDTO dto, Domicilio domicilio) {

        // Convertir el ID de String a int
        int id = Integer.parseInt(dto.getId());
        return new Persona(
                id,
                dto.getNombre(),
                dto.getContraseña(),
                dto.getFechaNacimiento(),
                dto.getCorreo(),
                dto.getSaldo(),
                domicilio,
                dto.getGeneratedKey()
        );
    }
    
    // Método para convertir de Persona a PersonaDTO
    public PersonaDTO convertirADTO(Persona persona) {
        // Crear y devolver el DTO a partir de la entidad Persona
        return new PersonaDTO(
                String.valueOf(persona.getId()), // Convertir el ID de int a String
                persona.getNombre(),
                persona.getContraseña(),
                persona.getFechaNacimiento(),
                persona.getCorreo(),
                persona.getSaldo(),
                // No se necesita idDomicilio en PersonaDTO.
                // Asumiendo que no se utiliza, o se pasa el objeto DomicilioDTO a otro lugar si es necesario.
                null,
                persona.getGeneratedKey()
        );
    }
}
