/**
 * Evento.java
 *
 * Clase que representa un evento en el sistema.
 * Esta clase contiene información sobre el evento, incluyendo
 * su nombre, fecha, descripción, URL de la imagen y el venue
 * donde se llevará a cabo.
 */
package Entidades;

import java.sql.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Evento {

    private int id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String imageURL;
    private Venue venue;

    /**
     * Constructor por defecto.
     */
    public Evento() {
    }

    /**
     * Constructor que crea un evento con la información proporcionada,
     * excluyendo el ID.
     *
     * @param nombre Nombre del evento.
     * @param fecha Fecha del evento.
     * @param descripcion Descripción del evento.
     * @param imageURL URL de la imagen del evento.
     * @param venue Lugar donde se lleva a cabo el evento.
     */
    public Evento(String nombre, Date fecha, String descripcion,
            String imageURL, Venue venue) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
    }

    /**
     * Constructor que crea un evento con la información proporcionada,
     * incluyendo el ID.
     *
     * @param id Identificador del evento.
     * @param nombre Nombre del evento.
     * @param fecha Fecha del evento.
     * @param descripcion Descripción del evento.
     * @param imageURL URL de la imagen del evento.
     * @param venue Lugar donde se lleva a cabo el evento.
     */
    public Evento(int id, String nombre, Date fecha, String descripcion,
            String imageURL, Venue venue) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
    }

    /**
     * Obtiene el identificador del evento.
     *
     * @return El ID del evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del evento.
     *
     * @param id El nuevo ID del evento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del evento.
     *
     * @return El nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     *
     * @param nombre El nuevo nombre del evento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha del evento.
     *
     * @return La fecha del evento.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento.
     *
     * @param fecha La nueva fecha del evento.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la descripción del evento.
     *
     * @return La descripción del evento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     *
     * @param descripcion La nueva descripción del evento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la URL de la imagen del evento.
     *
     * @return La URL de la imagen del evento.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Establece la URL de la imagen del evento.
     *
     * @param imageURL La nueva URL de la imagen del evento.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Obtiene el lugar donde se realiza el evento.
     *
     * @return El venue del evento.
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Establece el lugar donde se realiza el evento.
     *
     * @param venue El nuevo venue del evento.
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * Devuelve una representación en forma de cadena del evento. Esta
     * representación incluye el ID, el nombre, la fecha, la descripción, la URL
     * de la imagen y el venue del evento.
     *
     * @return Una cadena que representa el evento.
     */
    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fecha="
                + fecha + ", descripcion=" + descripcion + ", imageURL="
                + imageURL + ", venue=" + venue + '}';
    }
}
