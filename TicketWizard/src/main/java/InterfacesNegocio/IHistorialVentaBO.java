/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.HistorialVentaDTO;
import Excepciones.BOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IHistorialVentaBO {
    
    public List<HistorialVentaDTO> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws BOException;
    
}
