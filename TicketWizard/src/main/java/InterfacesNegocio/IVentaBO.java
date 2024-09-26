/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.VentaDTO;
import Excepciones.BOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IVentaBO {
    
    
    public List<VentaDTO> obtenerVentasPaginadas(int idPersona, int limit, 
            int offset) throws BOException;
    
    public List<VentaDTO> obtenerVentasPaginadasPorPrecio(int idPersona, 
                BigDecimal precioMin, BigDecimal precioMax, int limit, 
                int offset) throws BOException;
    
}
