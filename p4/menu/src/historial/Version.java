/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package historial;

/**
 * Esta clase almacena una version de un objeto (un Proyecto) y la opcion
 * elegida (asociada a la accion que ha modificado nuestro Proyecto).
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Version {

    private int opcion;
    private Object o;

    /**
     * Constructor de la clase Version
     *
     * @param opcion - int
     * @param o - Object
     */
    public Version(int opcion, Object o) {
        this.opcion = opcion;
        this.o = o;
    }

    /**
     *
     * @return o - Object
     */
    public Object getO() {
        return o;
    }

    /**
     *
     * @param o
     */
    public void setO(Object o) {
        this.o = o;
    }

    /**
     *
     * @return opcion - int
     */
    public int getOpcion() {
        return opcion;
    }

    /**
     *
     * @param opcion
     */
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
}
