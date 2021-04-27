
package listado.Exepciones;

import controlador.Controller;

/**
 *
 * @author Admin
 */
public class archivoInvalido extends Exception {

    /**
     * Creates a new instance of <code>ArchivoInvalidoExeption</code> without
     * detail message.
     */
    public archivoInvalido() {
    }

    /**
     * Constructs an instance of <code>ArchivoInvalidoExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public archivoInvalido(String msg) throws archivoInvalido, cargarArchivo {
        super(msg);

    }
}

