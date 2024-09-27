/**
 * IVentaDAO.java
 * 
 * La interfaz IVentaDAO define las operaciones relacionadas con 
 * la gestión de las ventas en la capa de acceso a datos. 
 * Proporciona métodos para obtener ventas paginadas, 
 * así como filtrar ventas por precio.
 */
package InterfacesDAO;

import Entidades.Venta;
import Excepciones.DAOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IVentaDAO {
    
    /**
     * Obtiene una lista de ventas paginadas para un persona específica.
     *
     * @param idPersona El identificador único de la persona cuyas ventas se desean obtener.
     * @param limit El número máximo de ventas a retornar.
     * @param offset El desplazamiento desde el cual comenzar a retornar ventas.
     * @return Una lista de objetos Venta que representan las ventas obtenidas.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Venta> obtenerVentasPaginadas(int idPersona, int limit, 
            int offset) throws DAOException;
    
    /**
     * Obtiene una lista de ventas paginadas para una persona específica,
     * filtrando por un rango de precios.
     *
     * @param idPersona El identificador único de la persona cuyas ventas se desean obtener.
     * @param precioMin El precio mínimo para filtrar las ventas.
     * @param precioMax El precio máximo para filtrar las ventas.
     * @param limit El número máximo de ventas a retornar.
     * @param offset El desplazamiento desde el cual comenzar a retornar ventas.
     * @return Una lista de objetos Venta que representan las ventas filtradas y paginadas.
     * @throws DAOException Si ocurre un error durante la operación de acceso a datos.
     */
    public List<Venta> obtenerVentasPaginadasPorPrecio(int idPersona, 
                BigDecimal precioMin, BigDecimal precioMax, int limit, 
                int offset) throws DAOException;
}
