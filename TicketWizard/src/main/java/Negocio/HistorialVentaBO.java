/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Convertidores.HistorialVentaCVR;
import DAO.HistorialVentaDAO;
import DTOs.HistorialVentaDTO;
import Entidades.HistorialVenta;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesNegocio.IHistorialVentaBO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author skevi
 */
public class HistorialVentaBO implements IHistorialVentaBO{

    HistorialVentaDAO hvDAO;
    HistorialVentaCVR hvCVR; 

    public HistorialVentaBO() {
        this.hvDAO = new HistorialVentaDAO();
        this.hvCVR = new HistorialVentaCVR();
    }
    
    /**
     * 
     * @param id
     * @param limit
     * @param offset
     * @return
     * @throws BOException 
     */
    @Override
    public List<HistorialVentaDTO> obtenerHistorialVentasPaginado(int id, 
            int limit, int offset) throws BOException {
        try{
            List<HistorialVenta> historial = hvDAO.
                    obtenerHistorialVentasPaginado(id, limit, offset);
            List<HistorialVentaDTO> historialDTO = new ArrayList<>();
            
            for (int i = 0; i < historial.size(); i++) {
                historialDTO.add(hvCVR.toDTO(historial.get(i)));
            }
               return historialDTO;
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
  
}
