/**
 *
 */
package Convertidores;

import DTOs.PersonaDTO;
import Entidades.Persona;
import Excepciones.BOException;

/**
 *
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. 
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class PersonaCVR {

    private DomicilioCVR domicilioCVR;

    public PersonaCVR() {
        domicilioCVR = new DomicilioCVR();
    }
    
    public Persona convertirAEntidad(PersonaDTO dto) throws BOException{
        try{
        // Convertir el ID de String a int
        int id = Integer.parseInt(dto.getId());
        return new Persona(
                id,
                dto.getNombre(),
                dto.getContraseña(),
                dto.getFechaNacimiento(),
                dto.getCorreo(),
                dto.getSaldo(),
                domicilioCVR.convertirAEntidad(dto.getDomicilioDto()),
                dto.getGeneratedKey()
        );
        }
        catch(BOException ex) {
            throw new BOException("Error al covertir a entidad");
        }
    }
    
    // Método para convertir de Persona a PersonaDTO
    public PersonaDTO convertirADTO(Persona persona) throws BOException{
        // Crear y devolver el DTO a partir de la entidad Persona
        return new PersonaDTO(
                String.valueOf(persona.getId()), // Convertir el ID de int a String
                persona.getNombre(),
                persona.getContraseña(),
                persona.getFechaNacimiento(),
                persona.getCorreo(),
                persona.getSaldo(),
                domicilioCVR.convertirADTO(persona.getDomicilio()),
                persona.getGeneratedKey()
        );
    }
    
    public Persona convertirAEntidadAgregar(PersonaDTO dto) throws BOException{

        return new Persona(
                dto.getNombre(),
                dto.getContraseña(),
                dto.getFechaNacimiento(),
                dto.getCorreo(),
                dto.getSaldo(),
                domicilioCVR.convertirAEntidadAgregar(dto.getDomicilioDto()),
                dto.getGeneratedKey()
        );
    }
    
}
