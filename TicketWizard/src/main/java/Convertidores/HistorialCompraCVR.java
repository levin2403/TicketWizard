/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.HistorialCompraDTO;
import Entidades.HistorialCompra;
import Entidades.Tipo_boleto;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class HistorialCompraCVR {
    
    private final PersonaCVR personaCVR;
    private final BoletoCVR boletoCVR;

    public HistorialCompraCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }

    
    public HistorialCompraDTO toDTO(HistorialCompra hc) throws BOException{
        if (hc == null) {
            return null;
        }
        
        try{
        return new HistorialCompraDTO(
            String.valueOf(hc.getId()),
            personaCVR.convertirADTO(hc.getPersona()),
            boletoCVR.toDTO(hc.getBoleto()),
            hc.getFecha_compra(),
            hc.getHora_compra(),
            hc.getTipo_compra().name()
        );
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public HistorialCompra toDTO(HistorialCompraDTO hcDTO) throws BOException{
        if (hcDTO == null) {
            return null;
        }
        
        try{
        return new HistorialCompra(
            Integer.parseInt(hcDTO.getId()),
            personaCVR.convertirAEntidad(hcDTO.getPersona()),
            boletoCVR.toEntity(hcDTO.getBoleto()),
            hcDTO.getFecha_compra(),
            hcDTO.getHora_compra(),
            Tipo_boleto.valueOf(hcDTO.getTipo_compra())
        );
        }catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
}
