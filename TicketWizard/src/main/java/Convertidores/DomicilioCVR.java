/**
 * 
 */
package Convertidores;

import DTOs.DomicilioDTO;
import Entidades.Domicilio;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioCVR {

    public Domicilio convertirAEntidad(DomicilioDTO dto) {
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
}
