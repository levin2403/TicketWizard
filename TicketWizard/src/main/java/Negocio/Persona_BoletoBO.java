/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.Persona_BoletoCVR;
import DAO.Persona_BoletoDAO;
import DTOs.Persona_BoletoDTO;
import Entidades.Persona_Boleto;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IPersona_BoletoBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Persona_BoletoBO implements IPersona_BoletoBO{

    private final Persona_BoletoDAO pbDAO;
    private final Persona_BoletoCVR pbCVR;

    public Persona_BoletoBO() {
        this.pbDAO = new Persona_BoletoDAO();
        this.pbCVR = new Persona_BoletoCVR();   
    }

    /**
     * 
     * @param id
     * @param limit
     * @param offset
     * @return
     * @throws BOException 
     */
    @Override
    public List<Persona_BoletoDTO> buscarBoletos(int id, int limit, 
            int offset) throws BOException {
        try{
            List<Persona_Boleto> lista = pbDAO.buscarBoletos(id, limit, offset);
            List<Persona_BoletoDTO> listaDTO = new ArrayList<>();
            
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(pbCVR.toDTO(lista.get(id)));
            }
            
            return listaDTO; //retornamos la lista convertida
        }
        catch(DAOException ex){
            throw new BOException("Error en negocio", ex);
        }    
    }

    /**
     * 
     * @param id
     * @param limit
     * @param offset
     * @param evento
     * @return
     * @throws BOException 
     */
    @Override
    public List<Persona_BoletoDTO> buscarBoletosPorEvento(int id, int limit, 
            int offset, String evento) throws BOException {
        try{
            List<Persona_Boleto> lista = pbDAO.buscarBoletosPorEvento(id, 
                    limit, offset, evento);
            List<Persona_BoletoDTO> listaDTO = new ArrayList<>();
            
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(pbCVR.toDTO(lista.get(id)));
            }
            return listaDTO; //retornamos la lista convertida
        }
        catch(DAOException ex){
            throw new BOException("Error en negocio", ex);
        }     
    }
    
    
}
