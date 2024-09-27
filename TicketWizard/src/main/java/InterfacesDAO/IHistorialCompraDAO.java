/**
 * IHistorialCompraDAO.java
 *
 * La interfaz IHistorialCompraDAO define las operaciones relacionadas con
 * la gestión del historial de compras en la capa de acceso a datos.
 * Proporciona un método para obtener un historial de compras paginado
 * para un usuario específico.
 */
package InterfacesDAO;

import Entidades.HistorialCompra;
import Excepciones.DAOException;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IHistorialCompraDAO {

    /**
     * Obtiene el historial de compras de un usuario específico en formato
     * paginado.
     *
     * @param id El identificador único del usuario cuyo historial de compras se
     * desea obtener.
     * @param paginaActual El número de la página que se desea obtener.
     * @param registrosPorPagina El número de registros por página.
     * @return Una lista de objetos HistorialCompra que corresponde al historial
     * del usuario.
     * @throws DAOException Si ocurre un error durante la operación de acceso a
     * datos.
     */
    public List<HistorialCompra> obtenerHistorialComprasPaginado(
            int id, int paginaActual, int registrosPorPagina) throws DAOException;

}
