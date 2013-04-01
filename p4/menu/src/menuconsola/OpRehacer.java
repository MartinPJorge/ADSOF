/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import historial.Historial;

/**
 * Esta opcion de MenuConsola se basa en la clase Historial y permite rehacer la
 * ultima accion deshecha.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpRehacer extends MenuItem {

    /**
     * Constructor por defecto de la clase OpRehacer
     */
    public OpRehacer() {
        super("Rehacer.", true, "Rehace la última opción deshecha.");
    }

    /**
     * Llama al método redo() de historial
     *
     * @param o - Object(Historial)
     * @return Object (Proyecto) devuelto por redo()
     */
    @Override
    public Object ejecutar(Object o) {
        Historial h = (Historial) o;
        return h.redo();
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
