/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Persona;
import Excepciones.DAOException;

/**
 *
 * @author skevi
 */
public interface IPersonaDAO {
    
    public void agregar(Persona persona) throws DAOException;
    public void actualizar(Persona persona) throws DAOException;
    
}
