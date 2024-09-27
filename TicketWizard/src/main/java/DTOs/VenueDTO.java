/**
 * VenueDTO.java
 * 
 * Clase que representa un lugar (venue) en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información
 * sobre un lugar, incluyendo su identificador, nombre, ciudad y estado.
 */
package DTOs;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class VenueDTO {
    
    private String id;
    private String nombre;
    private String ciudad;
    private String estado;

    /**
     * Constructor por defecto.
     */
    public VenueDTO() {
    }

    /**
     * Constructor para crear un lugar sin ID.
     *
     * @param nombre El nombre del lugar.
     * @param ciudad La ciudad donde se encuentra el lugar.
     * @param estado El estado donde se encuentra el lugar.
     */
    public VenueDTO(String nombre, String ciudad, String estado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    /**
     * Constructor para crear un lugar con información completa, 
     * incluyendo el ID.
     *
     * @param id El identificador del lugar.
     * @param nombre El nombre del lugar.
     * @param ciudad La ciudad donde se encuentra el lugar.
     * @param estado El estado donde se encuentra el lugar.
     */
    public VenueDTO(String id, String nombre, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador del lugar.
     *
     * @return El ID del lugar.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del lugar.
     *
     * @param id El nuevo ID del lugar.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del lugar.
     *
     * @return El nombre del lugar.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del lugar.
     *
     * @param nombre El nuevo nombre del lugar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ciudad donde se encuentra el lugar.
     *
     * @return La ciudad del lugar.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde se encuentra el lugar.
     *
     * @param ciudad La nueva ciudad del lugar.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el estado donde se encuentra el lugar.
     *
     * @return El estado del lugar.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado donde se encuentra el lugar.
     *
     * @param estado El nuevo estado del lugar.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
