/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 *
 * @author Jorge
 */
public class OpIncorrectaException extends EjecucionExcepcion{
    
    @Override
    public String toString() {
        return "La opcion elegida no es valida.";
    }
}
