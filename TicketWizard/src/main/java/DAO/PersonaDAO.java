/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import Excepciones.DAOException;
import InterfacesDAO.IDomicilioDAO;
import InterfacesDAO.IPersonaDAO;

/**
 *
 * @author skevi
 */
public class PersonaDAO implements IPersonaDAO{

    IDomicilioDAO domicilio;

    public PersonaDAO() {
        this.domicilio = new DomicilioDAO();
    }
    
    @Override
    public void agregar(Persona persona) throws DAOException {
        
        
    }

    @Override
    public void actualizar(Persona persona) throws DAOException {
        
    }

    @Override
    public Persona consultar(String correo) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
