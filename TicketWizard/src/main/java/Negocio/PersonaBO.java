/**
 *
 */
package Negocio;

import Convertidores.DomicilioCVR;
import Convertidores.PersonaCVR;
import DAO.PersonaDAO;
import DTOs.PersonaDTO;
import Entidades.Domicilio;
import Entidades.Persona;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesDAO.IPersonaDAO;
import InterfacesNegocio.IPersonaBO;
import java.math.BigDecimal;

/**
 *
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. 
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class PersonaBO implements IPersonaBO {

    private final IPersonaDAO personaDAO;
    private final DomicilioBO domicilioBO;
    private final PersonaCVR personaCVR;
    private final DomicilioCVR domicilioCVR;

    public PersonaBO() {
        this.personaDAO = new PersonaDAO();
        this.domicilioBO = new DomicilioBO();
        this.personaCVR = new PersonaCVR(); // Inicializar el convertidor
        this.domicilioCVR = new DomicilioCVR(); // Inicializar el convertidor para Domicilio
    }

    // Método privado para convertir PersonaDTO a Persona usando los convertidores
    private Persona convertirAEntidad(PersonaDTO dto) throws BOException {
        // Convertir DomicilioDTO a Domicilio usando el convertidor
        Domicilio domicilio = domicilioCVR.convertirAEntidad(dto.getDomicilioDto());

        // Utilizar el convertidor de Persona para crear la entidad Persona
        return personaCVR.convertirAEntidad(dto, domicilio);
    }

    // Método para convertir de Persona a PersonaDTO
    private PersonaDTO convertirADTO(Persona persona) {
        // Crear y devolver el DTO a partir de la entidad Persona
        return personaCVR.convertirADTO(persona);
    }

    @Override
    public PersonaDTO consultar(String correo) throws BOException {
        try {
            // Consultar la entidad Persona desde el DAO
            Persona persona = personaDAO.consultar(correo);

            // Convertir la entidad a DTO y devolverlo
            return convertirADTO(persona);
        } catch (DAOException ex) {
            throw new BOException("Error al consultar la persona: " + ex.getMessage());
        }
    }

    @Override
    public void agregar(PersonaDTO personaDTO) throws BOException {
        try {
            // Convertir el DTO a entidad
            Persona persona = convertirAEntidad(personaDTO);

            // Agregar la entidad Persona usando el DAO
            personaDAO.agregar(persona);
        } catch (DAOException ex) {
            throw new BOException("Error al agregar la persona: " + ex.getMessage());
        }
    }

    @Override
    public void actualizar(PersonaDTO personaDTO) throws BOException {
        try {
            // Convertir el DTO a entidad
            Persona persona = convertirAEntidad(personaDTO);

            // Actualizar la entidad Persona usando el DAO
            personaDAO.actualizar(persona);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar la persona: " + ex.getMessage());
        }
    }

    @Override
    public boolean consultarContrasena(String correo, String contrasena) throws BOException {
        try {
            // Consultar la persona usando el DAO
            Persona persona = personaDAO.consultar(correo);

            // Comparar la contraseña proporcionada con la almacenada
            return persona.getContraseña().equals(contrasena);

        } catch (DAOException ex) {
            throw new BOException("Error al consultar la contraseña: " + ex.getMessage());
        }
    }
    
    @Override
    public void actualizarSaldo(int idPersona, BigDecimal nuevoSaldo) throws BOException {
        try {
            personaDAO.actualizarSaldo(idPersona, nuevoSaldo);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar el saldo: " + ex.getMessage(), ex);
        }
    }

}
