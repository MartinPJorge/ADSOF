/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import myException.EjecucionExcepcion;

/**
 * Clase de una excepcion propia, que extiende ExistenciaTareaException y se
 * lanza cuando hemos buscado una Tarea que no existe.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class TareaNoEncontradaException extends ExistenciaTareaException {

    /**
     * 
     * @return toString de la Exception.
     */
    @Override
    public String toString() {
        return "Error: tarea no encontrada.";
    }
}
