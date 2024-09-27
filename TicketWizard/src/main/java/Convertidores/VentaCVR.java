/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.VentaDTO;
import Entidades.Venta;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class VentaCVR {
    
    private PersonaCVR personaCVR;
    private BoletoCVR boletoCVR;

    public VentaCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }
    
    public VentaDTO toDTO(Venta venta) throws BOException{
        
        if (venta == null) {
            return null;
        }
        
        try{
            return new VentaDTO(
                String.valueOf(venta.getId()),
                personaCVR.convertirADTO(venta.getPersona()),
                boletoCVR.toDTO(venta.getBoleto()),
                venta.getPrecio_reventa(),    
                venta.getFecha_limite(),
                venta.getEstado()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public Venta toEntity(VentaDTO ventaDTO) throws BOException{
        
        if (ventaDTO == null) {
            return null;
        }
        
        try{
            return new Venta(
                Integer.parseInt(ventaDTO.getId()),
                personaCVR.convertirAEntidad(ventaDTO.getPersona()),
                boletoCVR.toEntity(ventaDTO.getBoleto()),
                ventaDTO.getPrecio_reventa(),    
                ventaDTO.getFecha_limite(),
                ventaDTO.getEstado()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public Venta toEntityRegister(VentaDTO ventaDTO) throws BOException{
        
        if (ventaDTO == null) {
            return null;
        }
        
        try{
            return new Venta(
                personaCVR.convertirAEntidad(ventaDTO.getPersona()),
                boletoCVR.toEntity(ventaDTO.getBoleto()),
                ventaDTO.getPrecio_reventa(),    
                ventaDTO.getFecha_limite(),
                ventaDTO.getEstado()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
