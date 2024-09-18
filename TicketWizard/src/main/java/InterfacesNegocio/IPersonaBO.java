/**
 * 
 */
package InterfacesNegocio;

import DTOs.PersonaDTO;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IPersonaBO {
    
    public PersonaDTO consultar(String correo)throws BOException;
    public void agregar(PersonaDTO persona) throws BOException;
    public void actualizar(PersonaDTO persona) throws BOException;
    public boolean consultarContrasena(String correo, String contrasena)throws BOException;
    
}
