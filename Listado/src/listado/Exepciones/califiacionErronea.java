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
public class califiacionErronea extends Exception {

    /**
     * Creates a new instance of <code>CalificacionErroneaExeption</code>
     * without detail message.
     */
    public califiacionErronea() {
    }

    /**
     * Constructs an instance of <code>CalificacionErroneaExeption</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public califiacionErronea(String msg) {
        super(msg);
    }
}
