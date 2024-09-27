/**
 * VentaCVR.java.
 *
 * La clase VentaCVR se encarga de convertir entre objetos Venta y VentaDTO.
 * Utiliza los conversores PersonaCVR y BoletoCVR para manejar las conversiones de los atributos
 * relacionados con la persona y el boleto.
 */
package Convertidores;

import DTOs.VentaDTO;
import Entidades.Venta;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class VentaCVR {

    private final PersonaCVR personaCVR;
    private final BoletoCVR boletoCVR;

    /**
     * Constructor que inicializa los conversores PersonaCVR y BoletoCVR,
     * necesarios para convertir los atributos Persona y Boleto de la clase
     * Venta.
     */
    public VentaCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }

    /**
     * Convierte una entidad Venta en un objeto VentaDTO.
     *
     * @param venta la entidad Venta a convertir
     * @return el objeto VentaDTO correspondiente
     * @throws BOException si ocurre un error durante la conversión
     */
    public VentaDTO toDTO(Venta venta) throws BOException {
        try {
            return new VentaDTO(
                    String.valueOf(venta.getId()), // Convertir el ID de int a String
                    personaCVR.convertirADTO(venta.getPersona()),
                    boletoCVR.toDTO(venta.getBoleto()),
                    venta.getPrecio_reventa(),
                    venta.getFecha_limite()
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    /**
     * Convierte un objeto VentaDTO en una entidad Venta.
     *
     * @param ventaDTO el objeto VentaDTO a convertir
     * @return la entidad Venta correspondiente
     * @throws BOException si ocurre un error durante la conversión
     */
    public Venta toDTO(VentaDTO ventaDTO) throws BOException {
        try {
            return new Venta(
                    Integer.parseInt(ventaDTO.getId()), // Convertir el ID de String a int
                    personaCVR.convertirAEntidad(ventaDTO.getPersona()),
                    boletoCVR.toEntity(ventaDTO.getBoleto()),
                    ventaDTO.getPrecio_reventa(),
                    ventaDTO.getFecha_limite()
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }
}
