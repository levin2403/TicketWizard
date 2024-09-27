/**
 * IHistorialCompraBO.java
 * 
 * La interfaz IHistorialCompraBO define las operaciones relacionadas con 
 * la gestión del historial de compras en la capa de negocio.
 * Proporciona un método para obtener un historial de compras paginado.
 */
package InterfacesNegocio;

import DTOs.HistorialCompraDTO;
import Excepciones.BOException;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IHistorialCompraBO {
 
    /**
     * Obtiene el historial de compras de un usuario de forma paginada.
     *
     * @param id El identificador del usuario cuyas compras se desea consultar.
     * @param paginaActual El número de la página actual que se desea obtener.
     * @param registrosPorPagina El número de registros por página.
     * @return Una lista de objetos HistorialCompraDTO correspondiente al historial de compras del usuario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<HistorialCompraDTO> obtenerHistorialComprasPaginado(
            int id, int paginaActual, int registrosPorPagina) throws BOException;
    
}
