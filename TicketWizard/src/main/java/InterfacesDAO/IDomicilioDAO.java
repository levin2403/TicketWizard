/**
 * 
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
    
    public Domicilio consultar(Domicilio domicilio)throws DAOException;
    public void agregar(Domicilio domicilio) throws DAOException;
    public void actualizar(Domicilio domicilio) throws DAOException;
       
}
