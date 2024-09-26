/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Boleto;
import Excepciones.DAOException;

/**
 *
 * @author skevi
 */
public interface IBoletoDAO {
    
    public Boleto obtenerBoletoPorId(int id) throws DAOException;
    
}
