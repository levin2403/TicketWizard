/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.HistorialCompraCVR;
import DAO.HistorialCompraDAO;
import DTOs.HistorialCompraDTO;
import Entidades.HistorialCompra;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IHistorialCompraBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class HistorialCompraBO implements IHistorialCompraBO{
    
    HistorialCompraDAO hcDAO;
    HistorialCompraCVR hcCVR; 

    public HistorialCompraBO() {
        this.hcDAO = new HistorialCompraDAO();
        this.hcCVR = new HistorialCompraCVR();
    }
    
    @Override
    public List<HistorialCompraDTO> obtenerHistorialComprasPaginado(int id, 
            int limit, int offset) throws BOException {
        try{
            List<HistorialCompra> historial = hcDAO.
                    obtenerHistorialComprasPaginado(id, limit, offset);
            List<HistorialCompraDTO> historialDTO = new ArrayList<>(); 
            
            for (int i = 0; i < historial.size(); i++) {
                historialDTO.add(hcCVR.toDTO(historial.get(i)));
            }
            return historialDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex);
        }
    }
    
    
}
