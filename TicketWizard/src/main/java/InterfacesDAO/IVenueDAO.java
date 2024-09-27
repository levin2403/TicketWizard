/**
 * IVenueDAO.java
 * 
 * La interfaz IVenueDAO define las operaciones relacionadas con 
 * la gestión de los lugares (venues) en la capa de acceso a datos.
 * Proporciona métodos para obtener información sobre un venue específico.
 */
package InterfacesDAO;

import Entidades.Venue;
import Excepciones.DAOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IVenueDAO {
    
    /**
     * Obtiene un objeto Venue a partir de su identificador único.
     *
     * @param id El identificador único del venue que se desea obtener.
     * @return Un objeto Venue que representa el lugar correspondiente al id proporcionado.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Venue obtenerVenuePorId(int id) throws DAOException;
}
