/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import myException.EjecucionExcepcion;
import myException.OpIncorrectaException;

/**
 * Clase de una excepcion propia, que extiende EjecucionExcepcion y se lanza
 * cuando la opcion que hemos elegido no existe.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpcionInexistenteException extends OpIncorrectaException {

    /**
     * 
     * @return toString de la Exception.
     */
    @Override
    public String toString() {
        return "La opcion no existe.";
    }
}
