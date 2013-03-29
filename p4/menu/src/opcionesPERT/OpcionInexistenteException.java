/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import menuconsola.EjecucionExcepcion;
import menuconsola.OpIncorrectaException;

/**
 *
 * @author Jorge
 */
public class OpcionInexistenteException extends OpIncorrectaException {

    @Override
    public String toString() {
        return "La opcion no existe.";
    }
}
