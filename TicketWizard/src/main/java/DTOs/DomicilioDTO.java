/**
 * DomicilioDTO.java.
 *
 * Clase que representa un domicilio en el sistema.
 * Esta clase es un Data Transfer Object (DTO) que contiene información sobre un domicilio,
 * incluyendo su ciudad, colonia, calle, número exterior, número interior y código postal.
 *
 */
package DTOs;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioDTO {

    private String id;
    private String ciudad;
    private String colonia;
    private String calle;
    private int numExterior;
    private int numInterior;
    private int codigoPostal;

    /**
     * Constructor por defecto.
     */
    public DomicilioDTO() {
    }

    /**
     * Constructor para crear un domicilio con el identificador único.
     *
     * @param id El identificador del domicilio.
     */
    public DomicilioDTO(String id) {
        this.id = id;
    }

    /**
     * Constructor para crear un domicilio sin ID.
     *
     * @param ciudad La ciudad del domicilio.
     * @param colonia La colonia del domicilio.
     * @param calle La calle del domicilio.
     * @param numExterior El número exterior del domicilio.
     * @param numInterior El número interior del domicilio.
     * @param codigoPostal El código postal del domicilio.
     */
    public DomicilioDTO(String ciudad, String colonia, String calle,
            int numExterior, int numInterior, int codigoPostal) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor para crear un domicilio con información completa, incluyendo
     * el ID.
     *
     * @param id El identificador del domicilio.
     * @param ciudad La ciudad del domicilio.
     * @param colonia La colonia del domicilio.
     * @param calle La calle del domicilio.
     * @param numExterior El número exterior del domicilio.
     * @param numInterior El número interior del domicilio.
     * @param codigoPostal El código postal del domicilio.
     */
    public DomicilioDTO(String id, String ciudad, String colonia, String calle,
            int numExterior, Integer numInterior, int codigoPostal) {
        this.id = id;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el identificador del domicilio.
     *
     * @return El ID del domicilio.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del domicilio.
     *
     * @param id El nuevo ID del domicilio.
     */
    public void setId(String id) {
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
    public int getNumExterior() {
        return numExterior;
    }

    /**
     * Establece el número exterior del domicilio.
     *
     * @param numExterior El nuevo número exterior del domicilio.
     */
    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * Obtiene el número interior del domicilio.
     *
     * @return El número interior del domicilio.
     */
    public Integer getNumInterior() {
        return numInterior;
    }

    /**
     * Establece el número interior del domicilio.
     *
     * @param numInterior El nuevo número interior del domicilio.
     */
    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    /**
     * Obtiene el código postal del domicilio.
     *
     * @return El código postal del domicilio.
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal del domicilio.
     *
     * @param codigoPostal El nuevo código postal del domicilio.
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto
     * DomicilioDTO.
     *
     * @return Una cadena que representa el domicilio, incluyendo su ID, ciudad,
     * colonia, calle, número exterior, número interior y código postal.
     */
    @Override
    public String toString() {
        return "DomicilioDTO{" + "id=" + id
                + ", ciudad=" + ciudad
                + ", colonia=" + colonia
                + ", calle=" + calle
                + ", numExterior=" + numExterior
                + ", numInterior=" + numInterior
                + ", codigoPostal=" + codigoPostal + '}';
    }
}
