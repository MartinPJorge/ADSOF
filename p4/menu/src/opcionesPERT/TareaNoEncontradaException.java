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
public class TareaNoEncontradaException extends ExistenciaTareaException {

    @Override
    public String toString() {
        return "Error tarea no encontrada.";
    }
}
