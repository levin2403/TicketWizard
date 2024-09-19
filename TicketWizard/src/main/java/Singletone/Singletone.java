/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singletone;

import DTOs.PersonaDTO;

/**
 *
 * @author skevi
 */
public class Singletone {
    
    private static PersonaDTO persona;

    public Singletone() {
    }
    
    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        Singletone.persona = persona;
    }
    
}
