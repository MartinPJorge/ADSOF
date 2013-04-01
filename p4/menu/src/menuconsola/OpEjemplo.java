/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import myException.EjecucionExcepcion;

/**
 * Esta opcion de MenuConsola solamente despliega un mensaje informativo.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpEjemplo extends MenuItem {

    /**
     * Constructor por defecto de la clase OpEjemplo
     */
    public OpEjemplo() {
        super("Opcion Ejemplo", true, "Es una mera opcion de ejemplo.");
    }

    /**
     * Simplemente imprime una línea por pantalla.
     *
     * @param o - Object
     * @return o - Object
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        System.out.println("Se ha ejecutado la opcion de ejemplo.");
        return o;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
