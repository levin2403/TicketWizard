/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.HistorialVentaDTO;
import Entidades.HistorialVenta;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class HistorialVentaCVR {
    
    private PersonaCVR personaCVR;
    private BoletoCVR boletoCVR;

    public HistorialVentaCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }
    
    public HistorialVentaDTO toDTO(HistorialVenta hv) throws BOException{
        try{
            return new HistorialVentaDTO(
               String.valueOf(hv.getId()),
               personaCVR.convertirADTO(hv.getVendedor()),
               personaCVR.convertirADTO(hv.getComprador()),
               boletoCVR.toDTO(hv.getBoleto()),
               hv.getPrecio_venta(),
               hv.getFecha_venta(),
               hv.getHora_venta()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public HistorialVenta toEntity(HistorialVentaDTO hvDTO) throws BOException{
        try{
            return new HistorialVenta(
               Integer.parseInt(hvDTO.getId()),
               personaCVR.convertirAEntidad(hvDTO.getVendedor()),
               personaCVR.convertirAEntidad(hvDTO.getComprador()),
               boletoCVR.toEntity(hvDTO.getBoleto()),
               hvDTO.getPrecio_venta(),
               hvDTO.getFecha_venta(),
               hvDTO.getHora_venta()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
