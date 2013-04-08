/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import myException.MyException;

/**
 * Clase de una excepcion propia, que extiende MyException y se lanza
 * cuando intentamos crear un Ejército con Tropas de distintos bandos 
 * incompatibles.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class IncompatibleTypesExc extends MyException {

    public IncompatibleTypesExc() {
        super("Existen Tropas incompatibles en el Ejército. No se creará.");
    }

}
