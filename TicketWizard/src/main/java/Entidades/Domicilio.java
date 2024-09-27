/**
 * Domicilio.java
 *
 * Clase que representa un domicilio en el sistema.
 * Esta clase contiene información sobre la ubicación, incluyendo
 * ciudad, colonia, calle, números exterior e interior, y código postal.
 */
package Entidades;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class Domicilio {

    private int id;
    private String ciudad;
    private String colonia;
    private String calle;
    private int num_exterior;
    private int num_interior;
    private int codigo_postal;

    /**
     * Constructor por defecto.
     */
    public Domicilio() {
    }

    /**
     * Constructor que crea un domicilio con un ID específico.
     *
     * @param id El identificador del domicilio.
     */
    public Domicilio(int id) {
        this.id = id;
    }

    /**
     * Constructor para crear un domicilio con información completa sin ID.
     *
     * @param ciudad Ciudad del domicilio.
     * @param colonia Colonia del domicilio.
     * @param calle Calle del domicilio.
     * @param num_exterior Número exterior del domicilio.
     * @param num_interior Número interior del domicilio.
     * @param codigo_postal Código postal del domicilio.
     */
    public Domicilio(String ciudad, String colonia, String calle,
            int num_exterior, int num_interior, int codigo_postal) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.num_exterior = num_exterior;
        this.num_interior = num_interior;
        this.codigo_postal = codigo_postal;
    }

    /**
     * Constructor para crear un domicilio con información completa incluyendo
     * el ID.
     *
     * @param id Identificador del domicilio.
     * @param ciudad Ciudad del domicilio.
     * @param colonia Colonia del domicilio.
     * @param calle Calle del domicilio.
     * @param num_exterior Número exterior del domicilio.
     * @param num_interior Número interior del domicilio.
     * @param codigo_postal Código postal del domicilio.
     */
    public Domicilio(int id, String ciudad, String colonia, String calle,
            int num_exterior, int num_interior, int codigo_postal) {
        this.id = id;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.num_exterior = num_exterior;
        this.num_interior = num_interior;
        this.codigo_postal = codigo_postal;
    }

    /**
     * Constructor para crear un domicilio sin el número interior.
     *
     * @param ciudad Ciudad del domicilio.
     * @param colonia Colonia del domicilio.
     * @param calle Calle del domicilio.
     * @param num_exterior Número exterior del domicilio.
     * @param codigo_postal Código postal del domicilio.
     */
    public Domicilio(String ciudad, String colonia, String calle,
            int num_exterior, int codigo_postal) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.num_exterior = num_exterior;
        this.codigo_postal = codigo_postal;
    }

    /**
     * Constructor para crear un domicilio utilizando calle, número exterior,
     * ciudad y código postal.
     *
     * @param calle Calle del domicilio.
     * @param numExterior Número exterior del domicilio.
     * @param ciudad Ciudad del domicilio.
     * @param codigoPostal Código postal del domicilio.
     */
    public Domicilio(String calle, int numExterior, String ciudad, int codigoPostal) {
        this.calle = calle;
        this.num_exterior = numExterior;
        this.ciudad = ciudad;
        this.codigo_postal = codigoPostal;
    }

    /**
     * Obtiene el identificador del domicilio.
     *
     * @return El ID del domicilio.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del domicilio.
     *
     * @param id El nuevo ID del domicilio.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la ciudad del domicilio.
     *
     * @return La ciudad del domicilio.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del domicilio.
     *
     * @param ciudad La nueva ciudad del domicilio.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la colonia del domicilio.
     *
     * @return La colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia del domicilio.
     *
     * @param colonia La nueva colonia del domicilio.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene la calle del domicilio.
     *
     * @return La calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle del domicilio.
     *
     * @param calle La nueva calle del domicilio.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número exterior del domicilio.
     *
     * @return El número exterior del domicilio.
     */
    public int getNum_exterior() {
        return num_exterior;
    }

    /**
     * Establece el número exterior del domicilio.
     *
     * @param num_exterior El nuevo número exterior del domicilio.
     */
    public void setNum_exterior(int num_exterior) {
        this.num_exterior = num_exterior;
    }

    /**
     * Obtiene el número interior del domicilio.
     *
     * @return El número interior del domicilio.
     */
    public int getNum_interior() {
        return num_interior;
    }

    /**
     * Establece el número interior del domicilio.
     *
     * @param num_interior El nuevo número interior del domicilio.
     */
    public void setNum_interior(int num_interior) {
        this.num_interior = num_interior;
    }

    /**
     * Obtiene el código postal del domicilio.
     *
     * @return El código postal del domicilio.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal del domicilio.
     *
     * @param codigo_postal El nuevo código postal del domicilio.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Devuelve una representación en forma de cadena del domicilio. Esta
     * representación incluye el ID, la ciudad, la colonia, la calle, el número
     * exterior, el número interior y el código postal.
     *
     * @return Una cadena que representa el domicilio.
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", ciudad=" + ciudad + ", colonia="
                + colonia + ", calle=" + calle + ", num_exterior=" + num_exterior
                + ", num_interior=" + num_interior + ", codigo_postal="
                + codigo_postal + '}';
    }
}
