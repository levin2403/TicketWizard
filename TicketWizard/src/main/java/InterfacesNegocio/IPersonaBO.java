/**
 * 
 */
package InterfacesNegocio;

import DTOs.PersonaDTO;
import Excepciones.BOException;
import java.math.BigDecimal;

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
    public void actualizarSaldo(String idPersona, BigDecimal nuevoSaldo) throws BOException;
    public boolean consultarPorCorreoYContrasena(String correo, String contrasena) throws BOException;
}
