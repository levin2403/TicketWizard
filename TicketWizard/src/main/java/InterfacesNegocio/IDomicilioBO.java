/**
 * 
 */
package InterfacesNegocio;

import DTOs.DomicilioDTO;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IDomicilioBO {
    
    public DomicilioDTO consultar(String id) throws BOException;
    public void agregar(DomicilioDTO domicilio) throws BOException;
    public void actualizar(DomicilioDTO domicilio) throws BOException;
    
}
