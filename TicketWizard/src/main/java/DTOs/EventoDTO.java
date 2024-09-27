/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.sql.Date;


/**
 *
 * @author skevi
 */
public class EventoDTO {
    
    private String id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String imageURL;
    private VenueDTO venue;

    public EventoDTO() {
    }

    public EventoDTO(String nombre, Date fecha, String descripcion, 
            String imageURL, VenueDTO venue) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
    }

    public EventoDTO(String id, String nombre, Date fecha, String descripcion, 
            String imageURL, VenueDTO venue) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public VenueDTO getVenue() {
        return venue;
    }

    public void setVenue(VenueDTO venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "EventoDTO{" + "id=" + id + ", nombre=" + nombre + 
                ", fecha=" + fecha + ", descripcion=" + descripcion + 
                ", imageURL=" + imageURL + ", venue=" + venue + '}';
    }
    
}
