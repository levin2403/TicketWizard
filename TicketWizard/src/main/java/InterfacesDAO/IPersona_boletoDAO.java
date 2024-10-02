/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Persona_Boleto;
import Excepciones.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IPersona_boletoDAO {
    
    public List<Persona_Boleto> buscarBoletos(int idPersona, int limit, 
            int offset) throws DAOException;
    
    public List<Persona_Boleto> buscarBoletosPorEvento(int id, int limit, int offset, 
            String evento) throws DAOException;
    
}
