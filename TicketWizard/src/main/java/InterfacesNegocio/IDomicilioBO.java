/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.DomicilioDTO;
import Excepciones.BOException;

/**
 *
 * @author skevi
 */
public interface IDomicilioBO {
    
    public DomicilioDTO consultar(DomicilioDTO domicilio) throws BOException;
    public void agregar(DomicilioDTO domicilio) throws BOException;
    public void actualizar(DomicilioDTO domicilio) throws BOException;
    
}
