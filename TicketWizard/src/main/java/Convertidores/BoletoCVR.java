 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.BoletoDTO;
import Entidades.Boleto;
import Entidades.Tipo_boleto;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class BoletoCVR {
    
    private final EventoCVR eventoCVR;

    public BoletoCVR() {
        this.eventoCVR = new EventoCVR();
    }
    
    
    /**
     * 
     * @param boleto
     * @return 
     * @throws Excepciones.BOException 
     */
    public BoletoDTO toDTO(Boleto boleto) throws BOException{
        try{
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
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    /**
     * 
     * @param boletoDTO
     * @return 
     * @throws Excepciones.BOException 
     */
    public Boleto toEntity(BoletoDTO boletoDTO) throws BOException{
        try{
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
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    
}
