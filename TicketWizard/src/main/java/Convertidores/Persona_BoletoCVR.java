/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTOs.Persona_BoletoDTO;
import Entidades.Persona_Boleto;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public class Persona_BoletoCVR {
    
    private final PersonaCVR personaCVR;
    private final BoletoCVR boletoCVR;

    public Persona_BoletoCVR() {
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }
    
    
    public Persona_BoletoDTO toDTO(Persona_Boleto pb) throws BOException{
        try{
            return new Persona_BoletoDTO(
                String.valueOf(pb.getId()),
                personaCVR.convertirADTO(pb.getPersona()),
                boletoCVR.toDTO(pb.getBoleto()),
                pb.getFecha_adquisicion()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    public Persona_Boleto toEntity(Persona_BoletoDTO pbDTO) throws BOException{
        try{
            return new Persona_Boleto(
                Integer.parseInt(pbDTO.getId()),
                personaCVR.convertirAEntidad(pbDTO.getPersona()),
                boletoCVR.toEntity(pbDTO.getBoleto()),
                pbDTO.getFecha_adquisicion()
            );
        }
        catch(BOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
}
