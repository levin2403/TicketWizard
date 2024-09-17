/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.PersonaDTO;
import Excepciones.DAOException;

/**
 *
 * @author skevi
 */
public interface IPersonaBO {
    
    public PersonaDTO consultar(String correo)throws DAOException;
    public void agregar(PersonaDTO persona) throws DAOException;
    public void actualizar(PersonaDTO persona) throws DAOException;
    
}
