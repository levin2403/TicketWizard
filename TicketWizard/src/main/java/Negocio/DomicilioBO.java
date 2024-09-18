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
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioBO implements IDomicilioBO {

    private final IDomicilioDAO domicilioDAO;
    private DomicilioCVR convertidor;

    public DomicilioBO() {
        this.domicilioDAO = new DomicilioDAO(); // Asegúrate de pasar la conexión si es necesario
        this.convertidor = new DomicilioCVR();
    }

    @Override
    public void agregar(DomicilioDTO dto) throws BOException {
        try {
            Domicilio domicilio = convertirAEntidad(dto);
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
//        try {
//            Domicilio domicilio = convertirAEntidad(dto);
//            Domicilio resultado = domicilioDAO.consultar(domicilio);
//            return convertirADTO(resultado);
//        } catch (DAOException ex) {
//            throw new BOException("Error al consultar el domicilio: " + ex.getMessage(), ex);
//        }
return null;
    }

    private Domicilio convertirAEntidad(DomicilioDTO dto) {
        return new Domicilio(
                Integer.parseInt(dto.getId()),
                dto.getCiudad(),
                dto.getColonia(),
                dto.getCalle(),
                dto.getNumExterior(),
                dto.getNumInterior(),
                dto.getCodigoPostal()
        );
    }

//    private DomicilioDTO convertirADTO(Domicilio domicilio) {
//        return new DomicilioDTO(
//                domicilio.getCiudad(),
//                domicilio.getColonia(),
//                domicilio.getCalle(),
//                domicilio.getNum_exterior(),
//                domicilio.getNum_interior(),
//                domicilio.getCodigo_postal()
//        );
//    }
}
