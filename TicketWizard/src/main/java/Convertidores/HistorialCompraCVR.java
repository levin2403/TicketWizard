/**
 * HistorialCompraCVR.java.
 *
 * La clase HistorialCompraCVR se encarga de convertir entre objetos HistorialCompra y HistorialCompraDTO.
 * Utiliza los conversores PersonaCVR y BoletoCVR para manejar las conversiones de los atributos
 * relacionados con Persona y Boleto respectivamente.
 *
 */
package Convertidores;

import DTOs.HistorialCompraDTO;
import Entidades.HistorialCompra;
import Entidades.Tipo_boleto;
import Excepciones.BOException;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class HistorialCompraCVR {

    private final PersonaCVR personaCVR;
    private final BoletoCVR boletoCVR;

    /**
     * Constructor que inicializa los conversores PersonaCVR y BoletoCVR
     * necesarios para convertir los objetos relacionados en la clase
     * HistorialCompra.
     */
    public HistorialCompraCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }

    /**
     * Convierte un objeto HistorialCompra en un objeto HistorialCompraDTO. Si
     * el objeto HistorialCompra es nulo, devuelve null.
     *
     * @param hc el objeto HistorialCompra a convertir
     * @return un objeto HistorialCompraDTO correspondiente, o null si hc es
     * nulo
     * @throws BOException si ocurre un error durante la conversión
     */
    public HistorialCompraDTO toDTO(HistorialCompra hc) throws BOException {
        if (hc == null) {
            return null;
        }

        try {
            return new HistorialCompraDTO(
                    String.valueOf(hc.getId()), // Convierte el ID de int a String
                    personaCVR.convertirADTO(hc.getPersona()), // Convierte la entidad Persona
                    boletoCVR.toDTO(hc.getBoleto()), // Convierte el objeto Boleto
                    hc.getFecha_compra(),
                    hc.getHora_compra(),
                    hc.getTipo_compra().name() // Convierte el tipo de compra a String
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    /**
     * Convierte un objeto HistorialCompraDTO en una entidad HistorialCompra. Si
     * el objeto HistorialCompraDTO es nulo, devuelve null.
     *
     * @param hcDTO el objeto HistorialCompraDTO a convertir
     * @return un objeto HistorialCompra correspondiente, o null si hcDTO es
     * nulo
     * @throws BOException si ocurre un error durante la conversión
     */
    public HistorialCompra toDTO(HistorialCompraDTO hcDTO) throws BOException {
        if (hcDTO == null) {
            return null;
        }

        try {
            return new HistorialCompra(
                    Integer.parseInt(hcDTO.getId()), // Convierte el ID de String a int
                    personaCVR.convertirAEntidad(hcDTO.getPersona()), // Convierte el DTO Persona
                    boletoCVR.toEntity(hcDTO.getBoleto()), // Convierte el DTO Boleto
                    hcDTO.getFecha_compra(),
                    hcDTO.getHora_compra(),
                    Tipo_boleto.valueOf(hcDTO.getTipo_compra()) // Convierte el tipo de compra a Tipo_boleto
            );
        } catch (BOException ex) {
            throw new BOException(ex.getMessage());
        }
    }
}
