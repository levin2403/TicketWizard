/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.HistorialVenta;
import Excepciones.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IHistorialVentaDAO {
    
    
    public List<HistorialVenta> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws DAOException;
    
    
}
