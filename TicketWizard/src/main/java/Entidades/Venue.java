/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author skevi
 */
public class Venue {
    
    private int id; 
    private String nombre;
    private String ciudad;
    private String estado;

    public Venue() {
    }

    public Venue(String nombre, String ciudad, String estado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Venue(int id, String nombre, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + ", " +  ciudad + ", " + estado ;
    }
    
    
}
