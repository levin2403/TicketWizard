/**
 * IHistorialVentaBO.java
 * 
 * La interfaz IHistorialVentaBO define las operaciones relacionadas con 
 * la gestión del historial de ventas en la capa de negocio.
 * Proporciona un método para obtener un historial de ventas paginado.
 */
package InterfacesNegocio;

import DTOs.HistorialVentaDTO;
import Excepciones.BOException;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IHistorialVentaBO {
    
    /**
     * Obtiene el historial de ventas de un usuario de forma paginada.
     *
     * @param id El identificador del usuario cuyas ventas se desea consultar.
     * @param limit El número máximo de registros a devolver.
     * @param offset La posición desde la cual empezar a devolver los registros.
     * @return Una lista de objetos HistorialVentaDTO correspondiente al historial de ventas del usuario.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<HistorialVentaDTO> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws BOException;
    
}
