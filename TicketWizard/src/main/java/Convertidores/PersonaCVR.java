/**
 * PersonaCVR.java.
 *
 * La clase PersonaCVR se encarga de convertir entre objetos Persona y PersonaDTO.
 * Utiliza el conversor DomicilioCVR para manejar la conversión del atributo relacionado con el domicilio.
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

    private final DomicilioCVR domicilioCVR;

    /**
     * Constructor que inicializa el conversor DomicilioCVR necesario para
     * convertir el atributo Domicilio en la clase Persona.
     */
    public PersonaCVR() {
        domicilioCVR = new DomicilioCVR();
    }

    /**
     * Convierte un objeto PersonaDTO en una entidad Persona. Si ocurre algún
     * error durante la conversión, lanza una excepción BOException.
     *
     * @param dto el objeto PersonaDTO a convertir
     * @return la entidad Persona correspondiente
     * @throws BOException si ocurre un error durante la conversión
     */
    public Persona convertirAEntidad(PersonaDTO dto) throws BOException {
        try {
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
        } catch (BOException ex) {
            throw new BOException("Error al convertir a entidad");
        }
    }

    /**
     * Convierte una entidad Persona en un objeto PersonaDTO.
     *
     * @param persona la entidad Persona a convertir
     * @return un objeto PersonaDTO correspondiente
     * @throws BOException si ocurre un error durante la conversión
     */
    public PersonaDTO convertirADTO(Persona persona) throws BOException {
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

    /**
     * Convierte un objeto PersonaDTO en una entidad Persona cuando se agrega un
     * nuevo registro.
     *
     * @param dto el objeto PersonaDTO a convertir
     * @return la entidad Persona correspondiente para agregar
     * @throws BOException si ocurre un error durante la conversión
     */
    public Persona convertirAEntidadAgregar(PersonaDTO dto) throws BOException {
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
