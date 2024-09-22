/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Venue;
import Excepciones.DAOException;

/**
 *
 * @author skevi
 */
public interface IVenueDAO {
    
    public Venue obtenerVenuePorId(int id) throws DAOException;
}
