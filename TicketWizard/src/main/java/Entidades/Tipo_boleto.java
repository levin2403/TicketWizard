/**
 * Tipo_boleto.java
 * 
 * La enumeración Tipo_boleto representa los tipos de boletos disponibles en el sistema.
 * Puede ser utilizado para clasificar el origen de un boleto, ya sea desde una 
 * boletera oficial o mediante un proceso de reventa.
 */
package Entidades;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public enum Tipo_boleto {

    /**
     * Representa un boleto que se ha adquirido a través de la boletera oficial.
     */
    BOLETERA,

    /**
     * Representa un boleto que se ha adquirido a través de un proceso de reventa.
     */
    REVENTA;
}
