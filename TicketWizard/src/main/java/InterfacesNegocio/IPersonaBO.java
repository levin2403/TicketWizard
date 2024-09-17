/**
 * 
 */
package InterfacesNegocio;

import DTOs.PersonaDTO;
import Excepciones.DAOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IPersonaBO {
    
    public PersonaDTO consultar(String correo)throws DAOException;
    public void agregar(PersonaDTO persona) throws DAOException;
    public void actualizar(PersonaDTO persona) throws DAOException;
    
}
