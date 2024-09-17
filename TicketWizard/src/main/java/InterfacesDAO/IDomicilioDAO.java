/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Domicilio;
import Excepciones.DAOException;

/**
 *
 * @author skevi
 */
public interface IDomicilioDAO {
    
    public void agregar(Domicilio domicilio) throws DAOException;
    public void actualizar(Domicilio domicilio) throws DAOException;
       
}
