/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import historial.Historial;

/**
 * Esta opcion de MenuConsola se basa en la clase Historial y permite deshacer
 * la ultima accion realizada.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpDeshacer extends MenuItem {

    /**
     * Constructor por defecto de la clase OpDeshacer
     */
    public OpDeshacer() {
        super("Deshacer.", true, "La última opción ejecutada se deshace (si es posible).");
    }

    /**
     * Llama al método undo() de historial
     *
     * @param o - Object(Historial)
     * @return Object (Proyecto) devuelto por undo()
     */
    @Override
    public Object ejecutar(Object o) {
        Historial h = (Historial) o;
        return h.undo();
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
