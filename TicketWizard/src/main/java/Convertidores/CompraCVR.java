/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.CompraDTO;
import Entidades.Compra;
import Entidades.Tipo_compra;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class CompraCVR {
    
    private PersonaCVR personaCVR;
    private BoletoCVR boletoCVR;

    public CompraCVR() {
        this.boletoCVR = new BoletoCVR();
        this.personaCVR = new PersonaCVR();
    }
    
    public CompraDTO toDTO(Compra compra) throws BOException{
        try{
            return new CompraDTO(
                String.valueOf(compra.getId()),
                personaCVR.convertirADTO(compra.getPersonaDTO()),
                boletoCVR.toDTO(compra.getBoletoDTO()),
                compra.getId_transaccion(),
                compra.getFecha_compra(),
                compra.getHora_compra(),
                compra.getTipo_compra().name(),
                compra.getMonto()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public Compra toEmtity(CompraDTO compraDTO)throws BOException{
        try{
            return new Compra(
                Integer.parseInt(compraDTO.getId()),
                personaCVR.convertirAEntidad(compraDTO.getPersonaDTO()),
                boletoCVR.toEntity(compraDTO.getBoletoDTO()),
                compraDTO.getId_transaccion(),
                compraDTO.getFecha_compra(),
                compraDTO.getHora_compra(),
                Tipo_compra.valueOf(compraDTO.getTipo_compra().toUpperCase()),
                compraDTO.getMonto()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
