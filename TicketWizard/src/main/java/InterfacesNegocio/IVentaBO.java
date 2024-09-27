/**
 * IVentaBO.java
 * 
 * La interfaz IVentaBO define las operaciones relacionadas con la gestión de 
 * las ventas en la capa de negocio. Proporciona métodos para obtener 
 * ventas paginadas y filtrar por precio.
 */
package InterfacesNegocio;

import DTOs.VentaDTO;
import Excepciones.BOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IVentaBO {
    
    
    /**
     * Obtiene una lista de ventas paginadas para un usuario específico.
     *
     * @param idPersona El identificador de la persona cuyas ventas se desean obtener.
     * @param limit El número máximo de ventas a devolver.
     * @param offset El desplazamiento desde el cual comenzar a devolver las ventas.
     * @return Una lista de objetos VentaDTO que representan las ventas de la persona.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<VentaDTO> obtenerVentasPaginadas(int idPersona, int limit, 
            int offset) throws BOException;
    
    /**
     * Obtiene una lista de ventas paginadas para un usuario específico, 
     * filtrando por rango de precio.
     *
     * @param idPersona El identificador de la persona cuyas ventas se desean obtener.
     * @param precioMin El precio mínimo para filtrar las ventas.
     * @param precioMax El precio máximo para filtrar las ventas.
     * @param limit El número máximo de ventas a devolver.
     * @param offset El desplazamiento desde el cual comenzar a devolver las ventas.
     * @return Una lista de objetos VentaDTO que representan las ventas de la persona dentro del rango de precio.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public List<VentaDTO> obtenerVentasPaginadasPorPrecio(int idPersona, 
                BigDecimal precioMin, BigDecimal precioMax, int limit, 
                int offset) throws BOException;
    
}
