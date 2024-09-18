/**
 *
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
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798. Daniel Alejandro Castro
 * Félix - 235294.
 */
public class DomicilioBO implements IDomicilioBO {

    private final IDomicilioDAO domicilioDAO;
    private final DomicilioCVR convertidor;

    public DomicilioBO() {
        this.domicilioDAO = new DomicilioDAO(); // Asegúrate de pasar la conexión si es necesario
        this.convertidor = new DomicilioCVR();
    }

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

    @Override
    public void actualizar(DomicilioDTO dto) throws BOException {
        try {
            Domicilio domicilio = convertirAEntidad(dto);
            domicilioDAO.actualizar(domicilio);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar el domicilio: " + ex.getMessage(), ex);
        }
    }

    @Override
    public DomicilioDTO consultar(DomicilioDTO dto) throws BOException {
        return null; //CAMBIAR
    }

    // Usar el método de convertirAEntidad de DomicilioCVR
    private Domicilio convertirAEntidad(DomicilioDTO dto) throws BOException {
        return convertidor.convertirAEntidad(dto);
    }
}
