/**
 * Venue.java
 * 
 * La clase Venue representa un lugar donde se llevan a cabo eventos. 
 * Esta clase contiene información sobre el nombre del lugar, la ciudad 
 * y el estado en el que se encuentra. 
 */
package Entidades;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Venue {
    
    private int id; 
    private String nombre;
    private String ciudad;
    private String estado;

     /**
     * Constructor vacío de la clase Venue.
     */
    public Venue() {
    }

    /**
     * Constructor que inicializa el venue con los datos proporcionados.
     * 
     * @param nombre El nombre del venue.
     * @param ciudad La ciudad donde se localiza el venue.
     * @param estado El estado donde se localiza el venue.
     */
    public Venue(String nombre, String ciudad, String estado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa el venue con el ID y los datos proporcionados.
     * 
     * @param id El identificador del venue.
     * @param nombre El nombre del venue.
     * @param ciudad La ciudad donde se localiza el venue.
     * @param estado El estado donde se localiza el venue.
     */
    public Venue(int id, String nombre, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    /**
     * Obtiene el ID del venue.
     * 
     * @return El ID del venue.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del venue.
     * 
     * @param id El nuevo ID del venue.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del venue.
     * 
     * @return El nombre del venue.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del venue.
     * 
     * @param nombre El nuevo nombre del venue.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ciudad donde se localiza el venue.
     * 
     * @return La ciudad del venue.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde se localiza el venue.
     * 
     * @param ciudad La nueva ciudad del venue.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el estado donde se localiza el venue.
     * 
     * @return El estado del venue.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado donde se localiza el venue.
     * 
     * @param estado El nuevo estado del venue.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
