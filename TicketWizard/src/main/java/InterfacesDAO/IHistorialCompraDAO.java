/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.HistorialCompra;
import Excepciones.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IHistorialCompraDAO {
    
    public List<HistorialCompra> obtenerHistorialComprasPaginado(
          int id ,int paginaActual, int registrosPorPagina) throws DAOException; 
    
}
