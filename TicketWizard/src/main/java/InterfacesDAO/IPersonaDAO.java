/**
 * 
 */
package InterfacesDAO;

import Entidades.Persona;
import Excepciones.DAOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IPersonaDAO {
    
    public Persona consultar(String correo)throws DAOException;
    public void agregar(Persona persona) throws DAOException;
    public void actualizar(Persona persona) throws DAOException;
    
}
