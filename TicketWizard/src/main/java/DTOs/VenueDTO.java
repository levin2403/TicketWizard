/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author skevi
 */
public class VenueDTO {
    
    private String id;
    private String nombre;
    private String ciudad;
    private String estado;

    public VenueDTO() {
    }

    public VenueDTO(String nombre, String ciudad, String estado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public VenueDTO(String id, String nombre, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
