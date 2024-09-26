/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.HistorialCompraDTO;
import Excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IHistorialVentaBO {
    
    public List<HistorialCompraDTO> obtenerHistorialComprasPaginado(
            int id,int paginaActual, int registrosPorPagina) throws BOException; 
}
