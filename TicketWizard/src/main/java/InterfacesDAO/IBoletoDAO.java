/**
 * IBoletoDAO.java
 * 
 * La interfaz IBoletoDAO define las operaciones relacionadas con la 
 * gestión de boletos en la capa de acceso a datos. Esta interfaz 
 * proporciona un contrato para las implementaciones de acceso a datos 
 * relacionadas con los boletos.
 */
package InterfacesDAO;

import Entidades.Boleto;
import Excepciones.DAOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IBoletoDAO {
    
     /**
     * Obtiene un boleto específico utilizando su ID.
     *
     * @param id El identificador único del boleto que se desea obtener.
     * @return El boleto correspondiente al ID especificado.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public Boleto obtenerBoletoPorId(int id) throws DAOException;
    
}
