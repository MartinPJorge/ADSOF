/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import myException.EjecucionExcepcion;

/**
 * Clase de una excepcion propia, que extiende EjecucionExcepcion y se lanza
 * cuando hemos intentado crear una Tarea que ya existe.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class TareaExistenteException extends ExistenciaTareaException {

    /**
     * 
     * @return toString de la Exception.
     */
    @Override
    public String toString() {
        return "La tarea ya existe.";
    }
}
