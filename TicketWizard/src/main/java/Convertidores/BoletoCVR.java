/**
 * BoletoCVR.java
 *
 * La clase BoletoCVR es responsable de convertir objetos de tipo Boleto
 * a su correspondiente objeto de transferencia de datos (@code BoletoDTO) y viceversa.
 *
 * Utiliza la clase EventoCVR para manejar la conversión del atributo
 * Evento que forma parte de los objetos code Boleto y BoletoDTO.
 */
package Convertidores;

import DTOs.BoletoDTO;
import Entidades.Boleto;
import Entidades.Tipo_boleto;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class BoletoCVR {

    private final EventoCVR eventoCVR;

    /**
     * Constructor por defecto.
     *
     * Inicializa una instancia de EventoCVR, que es utilizada en la conversión
     * de los eventos asociados con los boletos.
     */
    public BoletoCVR() {
        this.eventoCVR = new EventoCVR();
    }

    /**
     * Convierte un objeto Boleto a su equivalente {@code BoletoDTO}.
     *
     * @param boleto el objeto Boleto a convertir.
     * @return un objeto BoletoDTO que representa los datos del boleto.
     * @throws BOException si ocurre un error durante la conversión.
     */
    public BoletoDTO toDTO(Boleto boleto) throws BOException {
        try {
            return new BoletoDTO(
                    String.valueOf(boleto.getId()),
                    boleto.getPrecio(),
                    boleto.getNumero_serie(),
                    boleto.getNumero_control(),
                    boleto.getFila(),
                    boleto.getAsiento(),
                    boleto.getTipo_boleto().name(),
                    boleto.getPrecio_original(),
                    eventoCVR.toDTO(boleto.getEvento())
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    /**
     * Convierte un objeto {@code BoletoDTO} a su equivalente entidad
     * {@code Boleto}.
     *
     * @param boletoDTO el objeto BoletoDTO a convertir.
     * @return un objeto {@code Boleto} que representa la entidad del boleto.
     * @throws BOException si ocurre un error durante la conversión.
     */
    public Boleto toEntity(BoletoDTO boletoDTO) throws BOException {
        try {
            return new Boleto(
                    Integer.parseInt(boletoDTO.getId()),
                    boletoDTO.getPrecio(),
                    boletoDTO.getNumero_serie(),
                    boletoDTO.getNumero_control(),
                    boletoDTO.getFila(),
                    boletoDTO.getAsiento(),
                    Tipo_boleto.valueOf(boletoDTO.getTipo_boleto()),
                    boletoDTO.getPrecio_original(),
                    eventoCVR.toEntity(boletoDTO.getEvento())
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

}
