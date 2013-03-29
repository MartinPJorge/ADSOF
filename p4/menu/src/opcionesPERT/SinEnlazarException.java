/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import menuconsola.EjecucionExcepcion;

/**
 *
 * @author Jorge
 */
public class SinEnlazarException extends EjecucionExcepcion {

    @Override
    public String toString() {
        return "Error hay tareas sin enlazar.";
    }
}
