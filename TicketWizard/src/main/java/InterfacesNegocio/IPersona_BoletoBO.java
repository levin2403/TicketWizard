/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.Persona_BoletoDTO;
import Excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IPersona_BoletoBO {
    
    public List<Persona_BoletoDTO> buscarBoletos(int id, int limit, int offset) 
            throws BOException;
    
    public List<Persona_BoletoDTO> buscarBoletosPorEvento(int id, int limit, int offset, 
            String evento) throws BOException;
    
    
}
