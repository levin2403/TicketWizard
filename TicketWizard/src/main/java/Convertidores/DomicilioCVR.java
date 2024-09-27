/**
 * DomicilioCVR.java.
 *
 * La clase DomicilioCVR es responsable de convertir entre objetos Domicilio y DomicilioDTO.
 * Proporciona métodos para convertir entidades a objetos de transferencia de datos y viceversa.
 * Además, maneja la conversión para operaciones de agregado de domicilios sin ID.
 *
 * Los métodos lanzan excepciones si los parámetros son nulos o si ocurre algún problema
 * durante la conversión.
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

    /**
     * Convierte un objeto DomicilioDTO en una entidad Domicilio. Si el ID es
     * nulo, se usa un valor predeterminado de 0.
     *
     * @param dto el objeto DomicilioDTO a convertir
     * @return un objeto Domicilio correspondiente
     * @throws BOException si ocurre un error durante la conversión
     * @throws IllegalArgumentException si el DomicilioDTO es nulo
     */
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

    /**
     * Convierte una entidad Domicilio en un objeto DomicilioDTO.
     *
     * @param domicilio el objeto Domicilio a convertir
     * @return un objeto DomicilioDTO correspondiente
     * @throws BOException si ocurre un error durante la conversión
     */
    public DomicilioDTO convertirADTO(Domicilio domicilio) throws BOException {
        try {
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
        } catch (NullPointerException ex) {
            throw new BOException("Error al convertir a DTO");
        }
    }
    /**
     * Convierte un objeto DomicilioDTO en una entidad Domicilio sin un ID inicial.
     * Este método es útil para operaciones de agregado, donde el ID aún no existe.
     * 
     * @param dto el objeto DomicilioDTO a convertir
     * @return un objeto Domicilio correspondiente
     * @throws BOException si ocurre un error durante la conversión
     * @throws IllegalArgumentException si el DomicilioDTO es nulo
     */
    public Domicilio convertirAEntidadAgregar(DomicilioDTO dto) throws BOException {
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
