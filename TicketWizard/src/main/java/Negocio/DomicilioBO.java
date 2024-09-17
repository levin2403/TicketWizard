/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.DomicilioDAO;
import DTOs.DomicilioDTO;
import Excepciones.BOException;
import InterfacesDAO.IDomicilioDAO;
import InterfacesNegocio.IDomicilioBO;

/**
 *
 * @author skevi
 */
public class DomicilioBO implements IDomicilioBO{

    IDomicilioDAO domicilio;

    public DomicilioBO() {
        this.domicilio = new DomicilioDAO();
    }
 
    
    @Override
    public void agregar(DomicilioDTO domicilio) throws BOException {
 
    }

    @Override
    public void actualizar(DomicilioDTO domicilio) throws BOException {
        
    }

    @Override
    public DomicilioDTO consultar(DomicilioDTO domicilio) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
