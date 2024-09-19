/**
 * 
 */
package Convertidores;

import DTOs.DomicilioDTO;
import Entidades.Domicilio;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioCVR {

    public Domicilio convertirAEntidad(DomicilioDTO dto) throws BOException {
        if (dto == null) {
            throw new IllegalArgumentException("DomicilioDTO no puede ser nulo.");
        }

        int id = dto.getId() != null ? Integer.parseInt(dto.getId()) : 0; // Usar un valor predeterminado si es nulo

        // Convertir DomicilioDTO a Domicilio
        return new Domicilio(
            id, // ID convertido a int
            dto.getCiudad(),
            dto.getColonia(),
            dto.getCalle(),
            dto.getNumExterior(),
            dto.getNumInterior(),
            dto.getCodigoPostal()
        );
    }
    
    public DomicilioDTO convertirADTO(Domicilio domicilio) throws BOException{
        try{
        String id = String.valueOf(domicilio.getId());
        
        return new DomicilioDTO(
            id, // ID convertido a int
            domicilio.getCiudad(),
            domicilio.getColonia(),
            domicilio.getCalle(),
            domicilio.getNum_exterior(),
            domicilio.getNum_interior(),
            domicilio.getCodigo_postal()
        );
        }
        catch(NullPointerException ex){
            throw new BOException("Error al convertir a DTO");
        }
    } 
    
    public Domicilio convertirAEntidadAgregar(DomicilioDTO dto) throws BOException{
        if (dto == null) {
            throw new IllegalArgumentException("DomicilioDTO no puede ser nulo.");
        }

        // Convertir DomicilioDTO a Domicilio
        return new Domicilio(
            dto.getCiudad(),
            dto.getColonia(),
            dto.getCalle(),
            dto.getNumExterior(),
            dto.getNumInterior(),
            dto.getCodigoPostal()
        );
    }
    
}
