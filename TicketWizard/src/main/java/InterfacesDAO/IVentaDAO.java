/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Boleto;
import Entidades.Persona;
import Entidades.Venta;
import Excepciones.DAOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IVentaDAO {
    
    public List<Venta> obtenerVentasPaginadas(int idPersona, int id_evento, 
            int limit, int offset) throws DAOException;
    
    public List<Venta> obtenerVentasPaginadasPorPrecio(int idPersona, 
            int id_evento, BigDecimal precioMin, BigDecimal precioMax, 
            int limit, int offset) throws DAOException;
    
   public Venta obtenerVentaApartada(int id_comprador) throws DAOException;
   
   public void RegistrarVenta(int id_persona, int id_boleto, BigDecimal precio) 
           throws DAOException;
   
   public void RealizarVentaApartada(Persona vendedor, Persona comprador, 
           Boleto boleto, BigDecimal precio, String numero_serie) 
           throws DAOException;
   
   public void RealizarVenta(Persona vendedor, Persona comprador, Boleto boleto, 
           BigDecimal precio, String numero_serie) throws DAOException;
   
   public void ApartarVenta(Persona comprador, Venta venta) throws DAOException;
}
