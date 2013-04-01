/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import myException.EjecucionExcepcion;

/**
 * Clase de una excepcion propia, que extiende EjecucionExcepcion y agrupa las
 * excepciones relacionadas con la existencia o no de Tareas.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class ExistenciaTareaException extends EjecucionExcepcion {

    /**
     * 
     * @return toString de la Exception.
     */
    @Override
    public String toString() {
        return "Error con tarea.";
    }
}
