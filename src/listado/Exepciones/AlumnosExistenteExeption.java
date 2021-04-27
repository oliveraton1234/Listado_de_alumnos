/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listado.Exepciones;

/**
 *<
 * @author Admin
 */
public class AlumnosExistenteExeption extends Exception {

    /**
     * Creates a new instance of <code>AlumnosExistenteExeption</code> without
     * detail message.
     */
    public AlumnosExistenteExeption() {
    }

    /**
     * Constructs an instance of <code>AlumnosExistenteExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnosExistenteExeption(String msg) {
        super(msg);
    }
}