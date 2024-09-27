/**
 * IDomicilioBO.java
 * 1
 * La interfaz IDomicilioBO define las operaciones relacionadas con 
 * la gestión de los domicilios en la capa de negocio. 
 * Proporciona métodos para consultar, agregar y actualizar domicilios.
 */
package InterfacesNegocio;

import DTOs.DomicilioDTO;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public interface IDomicilioBO {
    
     /**
     * Consulta un domicilio basado en su identificador.
     *
     * @param id El identificador del domicilio que se desea consultar.
     * @return Un objeto DomicilioDTO que representa el domicilio correspondiente al id proporcionado.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public DomicilioDTO consultar(String id) throws BOException;
    
    /**
     * Agrega un nuevo domicilio.
     *
     * @param domicilio El objeto DomicilioDTO que contiene la información del domicilio a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void agregar(DomicilioDTO domicilio) throws BOException;
    
    /**
     * Actualiza la información de un domicilio existente.
     *
     * @param domicilio El objeto DomicilioDTO que contiene la nueva información del domicilio.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    public void actualizar(DomicilioDTO domicilio) throws BOException;
    
}
