/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.BoletoDTO;
import Entidades.Boleto;
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
            boleto.getNumero_serie(),
            boleto.getFila(),
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
            int id = Integer.parseInt(boletoDTO.getId());
        return new Boleto(
            id,
            boletoDTO.getNumero_serie(),
            boletoDTO.getFila(),
            boletoDTO.getAsiento(),
            boletoDTO.getPrecio_original(),
            eventoCVR.toEntity(boletoDTO.getEvento())
        );
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    
}
