/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listado.Exepciones;

/**
 *
 * @author Admin
 */
public class guardarArchivo extends Exception {

    /**
     * Creates a new instance of <code>GuardarArchivoExeption</code> without
     * detail message.
     */
    public guardarArchivo() {
    }

    /**
     * Constructs an instance of <code>GuardarArchivoExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public guardarArchivo(String msg) {
        super(msg);
    }
}

