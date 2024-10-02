/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.BoletoDTO;
import DTOs.PersonaDTO;
import DTOs.VentaDTO;
import Excepciones.BOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IVentaBO {
    
    
   public List<VentaDTO> obtenerVentasPaginadas(int idPersona, int id_evento, int limit, 
            int offset) throws BOException;
    
   public List<VentaDTO> obtenerVentasPaginadasPorPrecio(int idPersona, int id_evento, 
            BigDecimal precioMin, BigDecimal precioMax, int limit, 
            int offset) throws BOException;
    
   public VentaDTO obtenerVentaApartada(int id_comprador) throws BOException;
   
   public void RegistrarVenta(int id_persona, int id_boleto, BigDecimal precio) 
           throws BOException;
   
   public void RealizarVentaApartada(PersonaDTO vendedor, PersonaDTO comprador, 
           BoletoDTO boleto, BigDecimal precio, String numero_serie) 
           throws BOException;
   
   public void RealizarVenta(PersonaDTO vendedor, PersonaDTO comprador, 
           BoletoDTO boleto, BigDecimal precio, String numero_serie) 
           throws BOException;
   
   public void ApartarVenta(PersonaDTO comprador, VentaDTO venta) 
           throws BOException;
   
}
