/**
 * IPersonaBO.java
 * 
 * La interfaz IPersonaBO define las operaciones relacionadas con la gestión de 
 * las personas en la capa de negocio. Proporciona métodos para consultar, 
 * agregar y actualizar la información de las personas, así como verificar 
 * credenciales y saldo.
 */
package InterfacesNegocio;

import DTOs.PersonaDTO;
import Excepciones.BOException;
import Excepciones.DAOException;
import java.math.BigDecimal;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IPersonaBO {
    
    /**
     * Consulta una persona mediante su correo electrónico.
     *
     * @param correo El correo electrónico de la persona a consultar.
     * @return Un objeto PersonaDTO que contiene la información de la persona.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public PersonaDTO consultar(String correo) throws BOException;

    /**
     * Agrega una nueva persona al sistema.
     *
     * @param persona Un objeto PersonaDTO que contiene la información de la persona a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void agregar(PersonaDTO persona) throws BOException;

    /**
     * Actualiza la información de una persona existente en el sistema.
     *
     * @param persona Un objeto PersonaDTO que contiene la información actualizada de la persona.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void actualizar(PersonaDTO persona) throws BOException;

    /**
     * Verifica si la contraseña proporcionada coincide con la registrada para un correo específico.
     *
     * @param correo El correo electrónico de la persona cuya contraseña se va a verificar.
     * @param contrasena La contraseña a verificar.
     * @return true si la contraseña es correcta; false en caso contrario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public boolean consultarContrasena(String correo, String contrasena) throws BOException;

    /**
     * Actualiza el saldo de una persona identificada por su ID.
     *
     * @param idPersona El identificador de la persona cuyo saldo se va a actualizar.
     * @param nuevoSaldo El nuevo saldo que se establecerá.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void actualizarSaldo(String idPersona, BigDecimal nuevoSaldo) throws BOException;

    /**
     * Verifica si el correo y la contraseña proporcionados coinciden con una persona existente.
     *
     * @param correo El correo electrónico de la persona a verificar.
     * @param contrasena La contraseña a verificar.
     * @return true si las credenciales son correctas; false en caso contrario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public boolean consultarPorCorreoYContrasena(String correo, String contrasena) throws BOException;

    /**
     * Obtiene la información de una persona a partir de su ID.
     *
     * @param idPersona El identificador de la persona a consultar.
     * @return Un objeto PersonaDTO que contiene la información de la persona.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public PersonaDTO obtenerPersonaPorId(int idPersona) throws DAOException;

    /**
     * Consulta el saldo de una persona a partir de su ID.
     *
     * @param id El identificador de la persona cuyo saldo se desea consultar.
     * @return El saldo de la persona.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public BigDecimal consultarSaldo(int id) throws DAOException; 
    
}
