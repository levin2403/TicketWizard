/**
 * 
 */
package DTOs;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class DomicilioDTO {

    private int id;
    private String ciudad;
    private String colonia;
    private String calle;
    private int numExterior;
    private Integer numInterior;
    private int codigoPostal;

    public DomicilioDTO() {
    }
    
    public DomicilioDTO(int id){
        this.id = id;
    }

    public DomicilioDTO(int id, String ciudad, String colonia, String calle, 
                        int numExterior, Integer numInterior, int codigoPostal) {
        this.id = id;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.codigoPostal = codigoPostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "DomicilioDTO{" + "id=" + id + 
               ", ciudad=" + ciudad + 
               ", colonia=" + colonia + 
               ", calle=" + calle + 
               ", numExterior=" + numExterior + 
               ", numInterior=" + numInterior + 
               ", codigoPostal=" + codigoPostal + '}';
    }
}
