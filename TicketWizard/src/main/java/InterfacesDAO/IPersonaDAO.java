/**
 * 
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
    
    public Persona consultar(String correo)throws DAOException;
    public void agregar(Persona persona) throws DAOException;
    public void actualizar(Persona persona) throws DAOException;
    public void actualizarSaldo(int idPersona, BigDecimal nuevoSaldo) throws DAOException;
    public Persona consultarPorCorreoYContrasena(String correo, String contrasena) throws DAOException;
    public Persona obtenerPersonaPorId(int idPersona) throws DAOException;
    public BigDecimal consultarSaldo(int id) throws DAOException; 
    
}
