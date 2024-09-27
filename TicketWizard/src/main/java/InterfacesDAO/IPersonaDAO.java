/**
 * IPersonaDAO.java
 * 
 * La interfaz IPersonaDAO define las operaciones relacionadas con 
 * la gestión de las personas en la capa de acceso a datos. 
 * Proporciona métodos para consultar, agregar y actualizar información 
 * de las personas, así como gestionar sus saldos.
 */
package InterfacesDAO;

import Entidades.Persona;
import Excepciones.DAOException;
import java.math.BigDecimal;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IPersonaDAO {
    
    /**
     * Consulta una persona en la base de datos utilizando su correo electrónico.
     *
     * @param correo El correo electrónico de la persona a consultar.
     * @return Un objeto Persona que representa a la persona consultada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Persona consultar(String correo) throws DAOException;
    
    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona El objeto Persona a agregar.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public void agregar(Persona persona) throws DAOException;
    
    /**
     * Actualiza la información de una persona existente en la base de datos.
     *
     * @param persona El objeto Persona con la información actualizada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public void actualizar(Persona persona) throws DAOException;
    
    /**
     * Actualiza el saldo de una persona en la base de datos.
     *
     * @param idPersona El identificador único de la persona cuyo saldo se desea actualizar.
     * @param nuevoSaldo El nuevo saldo a establecer.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public void actualizarSaldo(int idPersona, BigDecimal nuevoSaldo) throws DAOException;
    
    /**
     * Consulta una persona en la base de datos utilizando su correo electrónico 
     * y contraseña.
     *
     * @param correo El correo electrónico de la persona a consultar.
     * @param contrasena La contraseña de la persona a consultar.
     * @return Un objeto Persona que representa a la persona consultada o null si no se encuentra.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Persona consultarPorCorreoYContrasena(String correo, String contrasena) throws DAOException;
    
    /**
     * Obtiene una persona de la base de datos utilizando su identificador único.
     *
     * @param idPersona El identificador único de la persona a obtener.
     * @return Un objeto Persona que representa a la persona consultada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Persona obtenerPersonaPorId(int idPersona) throws DAOException;
    
    /**
     * Consulta el saldo de una persona en la base de datos.
     *
     * @param id El identificador único de la persona cuyo saldo se desea consultar.
     * @return El saldo actual de la persona como BigDecimal.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public BigDecimal consultarSaldo(int id) throws DAOException; 
    
}
