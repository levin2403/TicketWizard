/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singletone;

import DTOs.BoletoDTO;
import DTOs.EventoDTO;
import DTOs.PersonaDTO;
import DTOs.VentaDTO;

/**
 *
 * @author skevi
 */
public class Singletone {
    
    private static PersonaDTO persona;
    private static EventoDTO evento;
    private static VentaDTO venta;
    private static BoletoDTO boleto;

    public BoletoDTO getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoDTO boleto) {
        Singletone.boleto = boleto;
    }

    public Singletone() {
    }
    
    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        Singletone.persona = persona;
    }

    public EventoDTO getEvento() {
        return evento;
    }

    public void setEvento(EventoDTO evento) {
        Singletone.evento = evento;
    }

    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
        Singletone.venta = venta;
    }
    
    
}
