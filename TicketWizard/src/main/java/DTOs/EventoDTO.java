/**
 * EventoDTO.java
 *
 * Clase que representa un evento en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información sobre un evento,
 * incluyendo su nombre, fecha, descripción, URL de imagen y el lugar donde se llevará a cabo.
 *
 */
package DTOs;

import java.sql.Date;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class EventoDTO {

    private String id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String imageURL;
    private VenueDTO venue;

    /**
     * Constructor por defecto.
     */
    public EventoDTO() {
    }

    /**
     * Constructor para crear un evento sin ID.
     *
     * @param nombre El nombre del evento.
     * @param fecha La fecha del evento.
     * @param descripcion La descripción del evento.
     * @param imageURL La URL de la imagen del evento.
     * @param venue El lugar donde se lleva a cabo el evento.
     */
    public EventoDTO(String nombre, Date fecha, String descripcion,
            String imageURL, VenueDTO venue) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imageURL = imageURL;
        this.venue = venue;
    }

    /**
     * Constructor para crear un evento con información completa, incluyendo el
     * ID.
     *
     * @param id El identificador del evento.
     * @param nombre El nombre del evento.
     * @param fecha La fecha del evento.
     * @param descripcion La descripción del evento.
     * @param imageURL La URL de la imagen del evento.
     * @param venue El lugar donde se lleva a cabo el evento.
     */
    public EventoDTO(String id, String nombre, Date fecha, String descripcion,
            String imageURL, VenueDTO venue) {
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
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del evento.
     *
     * @param id El nuevo ID del evento.
     */
    public void setId(String id) {
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
     * Obtiene el lugar donde se lleva a cabo el evento.
     *
     * @return El venue del evento.
     */
    public VenueDTO getVenue() {
        return venue;
    }

    /**
     * Establece el lugar donde se lleva a cabo el evento.
     *
     * @param venue El nuevo venue del evento.
     */
    public void setVenue(VenueDTO venue) {
        this.venue = venue;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto EventoDTO.
     *
     * @return Una cadena que representa el evento, incluyendo su ID, nombre,
     * fecha, descripción, URL de imagen y venue.
     */
    @Override
    public String toString() {
        return "EventoDTO{" + "id=" + id + ", nombre=" + nombre
                + ", fecha=" + fecha + ", descripcion=" + descripcion
                + ", imageURL=" + imageURL + ", venue=" + venue + '}';
    }
}
