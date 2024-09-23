/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author skevi
 */
public class Evento {
    
    private int id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String imageURL;
    private Venue venue;

    public Evento() {
    }

    public Evento(String nombre, Date fecha, String descripcion, 
            String imageURL, Venue venue) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
    }

    public Evento(int id, String nombre, Date fecha, String descripcion, 
            String imageURL, Venue venue) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + 
                fecha + ", descripcion=" + descripcion + ", imageURL=" + 
                imageURL + ", venue=" + venue + '}';
    }
    
}
