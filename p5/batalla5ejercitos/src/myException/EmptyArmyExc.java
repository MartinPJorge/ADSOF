/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

/**
 * Clase de una excepcion propia, que extiende MyException y se lanza
 * cuando intentamos crear un ejército sin Tropas.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class EmptyArmyExc extends MyException {

    public EmptyArmyExc() {
        super("No se han añadido tropas al Ejército que hay que crear."
                + "Añada alguna antes de continuar.");
    }
}
