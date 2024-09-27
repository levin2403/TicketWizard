/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOs.BoletoDTO;
import DTOs.PersonaDTO;
import DTOs.VentaDTO;
import Excepciones.BOException;
import InterfacesNegocio.IVentaBO;
import java.math.BigDecimal;
import java.util.List;



/**
 *
 * @author skevi
 */
public class VentaBO implements IVentaBO{

    @Override
    public List<VentaDTO> obtenerVentasPaginadas(int idPersona, int limit, int offset) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaDTO> obtenerVentasPaginadasPorPrecio(int idPersona, BigDecimal precioMin, BigDecimal precioMax, int limit, int offset) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VentaDTO obtenerVentaApartada(int id_comprador) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void RegistrarVenta(VentaDTO venta) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void RealizarVentaApartada(PersonaDTO vendedor, PersonaDTO comprador, BoletoDTO boleto, BigDecimal precio, String numero_serie) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void RealizarVenta(PersonaDTO vendedor, PersonaDTO comprador, BoletoDTO boleto, BigDecimal precio, String numero_serie) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
