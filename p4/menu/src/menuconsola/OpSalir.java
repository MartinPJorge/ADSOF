/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import myException.EjecucionExcepcion;

/**
 * Esta opcion de MenuConsola permite salir correctamente de la aplicacion.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpSalir extends MenuItem {

    /**
     * Constructor por defecto de la clase OpSalir
     */
    public OpSalir() {
        super("Salir.", true, "Permite salir de la aplicación correctamente.");
    }

    /**
     * No hace nada, pero al ser llamada, procesarOpcion() se encarga de cambiar
     * la variable necesaria para salir del bucle while() en el que se encuentra
     * la aplicación.
     *
     * @param o - Object
     * @return o - Object
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        return o;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
