/**
 * 
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

    public Domicilio() {
    }
    
    public Domicilio(int id) {
        this.id = id;
    }

    public Domicilio(String ciudad, String colonia, String calle, 
            int num_exterior, int num_interior, int codigo_postal) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.num_exterior = num_exterior;
        this.num_interior = num_interior;
        this.codigo_postal = codigo_postal;
    }

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

    public Domicilio(String ciudad, String colonia, String calle, 
            int num_exterior, int codigo_postal) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.num_exterior = num_exterior;
        this.codigo_postal = codigo_postal;
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

    public int getNum_exterior() {
        return num_exterior;
    }

    public void setNum_exterior(int num_exterior) {
        this.num_exterior = num_exterior;
    }

    public int getNum_interior() {
        return num_interior;
    }

    public void setNum_interior(int num_interior) {
        this.num_interior = num_interior;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    
    
}
