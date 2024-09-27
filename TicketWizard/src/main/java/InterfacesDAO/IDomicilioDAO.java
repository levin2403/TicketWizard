/**
 * IDomicilioDAO.java
 * 
 * La interfaz IDomicilioDAO define las operaciones relacionadas con la 
 * gestión de domicilios en la capa de acceso a datos. Esta interfaz 
 * proporciona un contrato para las implementaciones de acceso a datos 
 * relacionadas con los domicilios.
 */
package InterfacesDAO;

import Entidades.Domicilio;
import Excepciones.DAOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IDomicilioDAO {
    
    /**
     * Consulta un domicilio específico utilizando su ID.
     *
     * @param id El identificador único del domicilio que se desea consultar.
     * @return El domicilio correspondiente al ID especificado.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Domicilio consultar(int id) throws DAOException;

    /**
     * Agrega un nuevo domicilio al sistema.
     *
     * @param domicilio El objeto Domicilio que se desea agregar.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public void agregar(Domicilio domicilio) throws DAOException;

    /**
     * Actualiza la información de un domicilio existente en el sistema.
     *
     * @param domicilio El objeto Domicilio con la información actualizada.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public void actualizar(Domicilio domicilio) throws DAOException;
       
}
