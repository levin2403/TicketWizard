/**
 * PersonaBO.java
 * 
 * La clase PersonaBO implementa la lógica de negocio para manejar operaciones relacionadas 
 * con las personas. Implementa la interfaz IPersonaBO y utiliza un objeto de acceso a datos 
 * (DAO) para interactuar con la base de datos.
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
    private final PersonaCVR personaCVR;

    /**
     * Constructor de PersonaBO que inicializa el DAO y el convertidor.
     */
    public PersonaBO() {
        this.personaDAO = new PersonaDAO();
        this.personaCVR = new PersonaCVR();
    }

    /**
     * Consulta una persona por su correo electrónico.
     *
     * @param correo El correo electrónico de la persona a consultar.
     * @return Un objeto PersonaDTO que representa la persona consultada.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
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

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param personaDTO El objeto PersonaDTO que contiene la información de la persona a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
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

    /**
     * Actualiza la información de una persona en la base de datos.
     *
     * @param personaDTO El objeto PersonaDTO que contiene la información actualizada de la persona.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
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

    /**
     * Consulta si la contraseña proporcionada coincide con la almacenada para la persona 
     * asociada al correo electrónico.
     *
     * @param correo El correo electrónico de la persona.
     * @param contrasena La contraseña a verificar.
     * @return true si la contraseña coincide; false en caso contrario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public boolean consultarContrasena(String correo, String contrasena) throws BOException {
        // Implementación temporal que siempre devuelve true
        return true;
    }

    /**
     * Actualiza el saldo de una persona.
     *
     * @param idPersona El identificador de la persona cuyo saldo se actualizará.
     * @param nuevoSaldo El nuevo saldo a establecer.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public void actualizarSaldo(String idPersona, BigDecimal nuevoSaldo) throws BOException {
        try {
            int id = Integer.parseInt(idPersona);
            personaDAO.actualizarSaldo(id, nuevoSaldo);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar el saldo: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta si existe una persona con el correo electrónico y la contraseña proporcionados.
     *
     * @param correo El correo electrónico de la persona.
     * @param contrasena La contraseña a verificar.
     * @return true si se encuentra una persona con las credenciales; false en caso contrario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public boolean consultarPorCorreoYContrasena(String correo, String contrasena) throws BOException {
        try {
            // Consultar la persona con el correo y la contraseña
            Persona persona = personaDAO.consultarPorCorreoYContrasena(correo, contrasena);

            // Si se encuentra la persona, significa que la combinación de correo y contraseña es válida
            return persona != null;

        } catch (DAOException ex) {
            throw new BOException("Error al consultar la contraseña: " + ex.getMessage());
        }
    }

    /**
     * Obtiene una persona por su identificador.
     *
     * @param idPersona El identificador de la persona a consultar.
     * @return Un objeto PersonaDTO que representa la persona consultada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public PersonaDTO obtenerPersonaPorId(int idPersona) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Consulta el saldo de una persona por su identificador.
     *
     * @param id El identificador de la persona.
     * @return El saldo actual de la persona.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    @Override
    public BigDecimal consultarSaldo(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
