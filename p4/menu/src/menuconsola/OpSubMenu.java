/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import myException.EjecucionExcepcion;

/**
 * Esta opcion de MenuConsola crea un Submenu al que añade una opEjemplo para
 * mostrar que, extendiendo el codigo, podemos crear submenus tan complejos como
 * deseemos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpSubMenu extends MenuItem {

    private boolean fin;

    /**
     * Constructor por defecto de la clase OpSubMenu
     */
    public OpSubMenu() {
        super("Submenu", true, "Lanza un submenu.");
        this.fin = false;
    }

    /**
     * Crea un nuevo MenuConsola con un solo MenuItem de la clase OpEjemplo y lo
     * ejecuta, demostrando que es posible crear submenús (tan complejos como
     * queramos, llegado el caso).
     *
     * @param o - Object
     * @return o - Object
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        MenuConsola submenu = new MenuConsola("Submenu");

        submenu.addOpcion(new OpEjemplo());

        submenu.ejecutar(o);

        return o;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
