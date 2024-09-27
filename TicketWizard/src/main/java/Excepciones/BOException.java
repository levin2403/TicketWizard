/**
 * BOException.java
 * 
 * La clase BOException es una excepción personalizada que se utiliza para 
 * manejar errores específicos en la capa de negocio de la aplicación. 
 * Esta clase extiende la clase Exception de Java.
 */
package Excepciones;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class BOException extends Exception{

    /**
     * Crea una nueva instancia de BOException sin un mensaje de error.
     */
    public BOException() {
    }

    /**
     * Crea una nueva instancia de BOException con un mensaje de error especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de BOException con un mensaje de error y una causa especificados.
     *
     * @param message El mensaje que describe la excepción.
     * @param cause La causa de la excepción.
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de BOException con una causa especificada.
     *
     * @param cause La causa de la excepción.
     */
    public BOException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva instancia de BOException con un mensaje de error, una causa, 
     * y opciones para habilitar la supresión y la escritura de la traza de pila.
     *
     * @param message El mensaje que describe la excepción.
     * @param cause La causa de la excepción.
     * @param enableSuppression Indica si se debe habilitar la supresión de excepciones.
     * @param writableStackTrace Indica si la traza de pila es escribible.
     */
    public BOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
