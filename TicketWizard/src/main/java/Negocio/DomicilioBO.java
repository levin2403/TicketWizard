/**
 * DomicilioBO.java
 * 
 * La clase DomicilioBO es la implementación de la lógica de negocio para manejar 
 * operaciones relacionadas con domicilios. Implementa la interfaz IDomicilioBO 
 * y utiliza un objeto de acceso a datos (DAO) para interactuar con la base de datos.
 */
package Negocio;

import Convertidores.DomicilioCVR;
import DAO.DomicilioDAO;
import DTOs.DomicilioDTO;
import Entidades.Domicilio;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesDAO.IDomicilioDAO;
import InterfacesNegocio.IDomicilioBO;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioBO implements IDomicilioBO {

    private final IDomicilioDAO domicilioDAO;
    private final DomicilioCVR convertidor;

    /**
     * Constructor de DomicilioBO que inicializa el DAO y el convertidor.
     */
    public DomicilioBO() {
        this.domicilioDAO = new DomicilioDAO(); 
        this.convertidor = new DomicilioCVR();
    }

    /**
     * Agrega un nuevo domicilio a la base de datos.
     *
     * @param dto El objeto DomicilioDTO que contiene la información del domicilio a agregar.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public void agregar(DomicilioDTO dto) throws BOException {
        try {
            // Verificar que dto no sea nulo y tenga valores válidos
            if (dto == null) {
                throw new BOException("DomicilioDTO es nulo.");
            }

            // Convertir DomicilioDTO a Domicilio
            Domicilio domicilio = convertirAEntidad(dto);

            // Agregar el Domicilio usando el DAO
            domicilioDAO.agregar(domicilio);
        } catch (DAOException ex) {
            throw new BOException("Error al agregar el domicilio: " + ex.getMessage(), ex);
        }
    }

    /**
     * Actualiza la información de un domicilio existente en la base de datos.
     *
     * @param dto El objeto DomicilioDTO que contiene la información actualizada del domicilio.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public void actualizar(DomicilioDTO dto) throws BOException {
        try {
            Domicilio domicilio = convertirAEntidad(dto);
            domicilioDAO.actualizar(domicilio);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar el domicilio: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta un domicilio en la base de datos por su identificador.
     *
     * @param id El identificador del domicilio a consultar.
     * @return Un objeto DomicilioDTO que contiene la información del domicilio consultado.
     * @throws BOException Si ocurre un error durante la operación de negocio.
     */
    @Override
    public DomicilioDTO consultar(String id) throws BOException {
        try {
            int idPersona = Integer.parseInt(id);
            Domicilio domicilio = domicilioDAO.consultar(idPersona);
            return convertidor.convertirADTO(domicilio);
        } catch (DAOException ex) {
            throw new BOException("Error al consultar el domicilio: " + ex.getMessage(), ex);
        }
    }

    /**
     * Convierte un objeto DomicilioDTO a un objeto Domicilio utilizando el convertidor.
     *
     * @param dto El objeto DomicilioDTO a convertir.
     * @return El objeto Domicilio correspondiente.
     * @throws BOException Si ocurre un error durante la conversión.
     */
    private Domicilio convertirAEntidad(DomicilioDTO dto) throws BOException {
        return convertidor.convertirAEntidad(dto);
    }
}
