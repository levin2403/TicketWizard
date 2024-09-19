/**
 *
 */
package Negocio;


import Convertidores.PersonaCVR;
import DAO.PersonaDAO;
import DTOs.PersonaDTO;
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

    public PersonaBO() {
        this.personaDAO = new PersonaDAO();
        this.domicilioBO = new DomicilioBO();
        this.personaCVR = new PersonaCVR(); 
    }


    @Override
    public PersonaDTO consultar(String correo) throws BOException {
        try {
            // Consultar la entidad Persona desde el DAO
            Persona persona = personaDAO.consultar(correo);

            // Convertir la entidad a DTO y devolverlo
            return personaCVR.convertirADTO(persona);
        } catch (DAOException ex) {
            throw new BOException("Error al consultar la persona: " + ex.getMessage());
        }
    }

    @Override
    public void agregar(PersonaDTO personaDTO) throws BOException {
        try {
            // Convertir el DTO a entidad
            Persona persona = personaCVR.convertirAEntidadAgregar(personaDTO);

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
            Persona persona = personaCVR.convertirAEntidad(personaDTO);

            // Actualizar la entidad Persona usando el DAO
            personaDAO.actualizar(persona);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar la persona: " + ex.getMessage());
        }
    }

    @Override
    public boolean consultarContrasena(String correo, String contrasena) throws BOException {
//        try {
//            // Consultar la persona usando el DAO
//            Persona persona = personaDAO.consultar(correo);
//
//            // Comparar la contraseña proporcionada con la almacenada
//            return persona.getContraseña().equals(contrasena);
return true;

//        } catch (DAOException ex) {
//            throw new BOException("Error al consultar la contraseña: " + ex.getMessage());
//        }
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
