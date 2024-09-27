/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.BoletoCVR;
import Convertidores.PersonaCVR;
import Convertidores.VentaCVR;
import DAO.VentaDAO;
import DTOs.BoletoDTO;
import DTOs.PersonaDTO;
import DTOs.VentaDTO;
import Entidades.Boleto;
import Entidades.Persona;
import Entidades.Venta;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IVentaBO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author skevi
 */
public class VentaBO implements IVentaBO{
    
    private final VentaDAO ventaDAO;
    private final VentaCVR ventaCVR;
    private final PersonaCVR personaCVR;
    private final BoletoCVR boletoCVR;

    public VentaBO() {
        this.ventaDAO = new VentaDAO();
        this.ventaCVR = new VentaCVR();
        this.personaCVR = new PersonaCVR();
        this.boletoCVR = new BoletoCVR();
    }
    

    @Override
    public List<VentaDTO> obtenerVentasPaginadas(int idPersona, int limit, 
            int offset, int id_evento) throws BOException {
        try{
        List<Venta> lista = ventaDAO.obtenerVentasPaginadas(idPersona, 
                limit, offset, id_evento);
        List<VentaDTO> listaDTO = new ArrayList<>();
        
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(ventaCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public List<VentaDTO> obtenerVentasPaginadasPorPrecio(int idPersona, 
            BigDecimal precioMin, BigDecimal precioMax, int limit, 
            int offset, int id_evento) throws BOException {
        
        try{
        List<Venta> lista = ventaDAO.obtenerVentasPaginadasPorPrecio
                   (idPersona, precioMin, precioMax, limit, offset, id_evento);
        List<VentaDTO> listaDTO = new ArrayList<>();
        
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(ventaCVR.toDTO(lista.get(i)));
            }
            return listaDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
        
    }

    @Override
    public VentaDTO obtenerVentaApartada(int id_comprador) throws BOException {
        try{
            return ventaCVR.toDTO(ventaDAO.obtenerVentaApartada(id_comprador));
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public void RegistrarVenta(VentaDTO venta) throws BOException {
        try{
            ventaDAO.RegistrarVenta(ventaCVR.toEntityRegister(venta));
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public void RealizarVentaApartada(PersonaDTO vendedorDTO, PersonaDTO compradorDTO, 
            BoletoDTO boletoDTO, BigDecimal precio, String numero_serie) 
            throws BOException {
        try{
            Persona vendedor = personaCVR.convertirAEntidad(vendedorDTO);
            Persona comprador = personaCVR.convertirAEntidad(compradorDTO);
            Boleto boleto = boletoCVR.toEntity(boletoDTO);
            ventaDAO.RealizarVentaApartada(vendedor, comprador, boleto, precio, numero_serie);
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public void RealizarVenta(PersonaDTO vendedorDTO, PersonaDTO compradorDTO, 
            BoletoDTO boletoDTO, BigDecimal precio, String numero_serie) 
            throws BOException {
        try{
            Persona vendedor = personaCVR.convertirAEntidad(vendedorDTO);
            Persona comprador = personaCVR.convertirAEntidad(compradorDTO);
            Boleto boleto = boletoCVR.toEntity(boletoDTO);
            ventaDAO.RealizarVentaApartada(vendedor, comprador, boleto, precio, numero_serie);
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public void ApartarVenta(PersonaDTO compradorDTO, VentaDTO ventaDTO) 
            throws BOException {
        try{
            Persona comprador = personaCVR.convertirAEntidad(compradorDTO);
            Venta venta = ventaCVR.toEntity(ventaDTO);
            ventaDAO.ApartarVenta(comprador, venta); //apartamos la venta
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

}
