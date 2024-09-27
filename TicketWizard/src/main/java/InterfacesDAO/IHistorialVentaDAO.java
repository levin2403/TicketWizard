/**
 * IHistorialVentaDAO.java
 * 
 * La interfaz IHistorialVentaDAO define las operaciones relacionadas con 
 * la gestión del historial de ventas en la capa de acceso a datos. 
 * Proporciona un método para obtener un historial de ventas paginado 
 * para un usuario específico.
 */
package InterfacesDAO;

import Entidades.HistorialVenta;
import Excepciones.DAOException;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IHistorialVentaDAO {
    
    /**
     * Obtiene el historial de ventas de un usuario específico en formato 
     * paginado.
     *
     * @param id El identificador único del usuario cuyo historial de ventas se desea obtener.
     * @param limit El número máximo de registros a devolver.
     * @param offset El número de registros a omitir antes de comenzar a devolver los resultados.
     * @return Una lista de objetos HistorialVenta que corresponde al historial de ventas del usuario.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<HistorialVenta> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws DAOException; 
}
