/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package historial;

import Proyector.Proyecto;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase almacena las distintas versiones de un objeto con el que estemos
 * trabajando y permite recuperarlas, pudiendo deshacer y rehacer cualquier
 * cambio del objeto. En nuestro caso, los objetos que almacenaremos seran de la
 * clase Proyecto.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Historial {

    private int currentOption;
    private List<Version> versiones;

    /**
     * Constructor por defecto de la clase Historial
     */
    public Historial() {
        this.currentOption = -1;
        this.versiones = new ArrayList<Version>();
    }

    /**
     *
     * @return currentOption
     */
    public int getCurrentOption() {
        return currentOption;
    }

    /**
     *
     * @param currentOption
     */
    public void setCurrentOption(int currentOption) {
        this.currentOption = currentOption;
    }

    /**
     *
     * @return versiones
     */
    public List<Version> getVersiones() {
        return versiones;
    }

    /**
     *
     * @param versiones
     */
    public void setVersiones(List<Version> versiones) {
        this.versiones = versiones;
    }

    /**
     * Guarda una nueva versión del proyecto en el historial. Las versiones se
     * guardan de tal forma que si hemos deshecho varias acciones, al realizar
     * una nueva, se inserta en la posición siguiente en el Historial y borra
     * todas las posteriores que había antes.
     *
     * @param opcion
     * @param o
     */
    public void save(int opcion, Object o) {
        Proyecto p = (Proyecto) o;
        Version v = new Version(opcion, p.clone());
        this.currentOption++;
        this.versiones.add(this.currentOption, v);
        ArrayList<Version> nuevo = (ArrayList) this.versiones.subList(0, this.currentOption + 1);
        this.setVersiones(nuevo);
        this.setVersiones(nuevo);
    }

    /**
     * Deshace la última acción realizada. Devuelve el proyecto anterior a la
     * acción deshecha o null en caso de que no se pueda deshacer ninguna
     * acción.
     *
     * @return Object - (Proyecto)
     */
    public Object redo() {
        if (this.currentOption + 1 == this.getVersiones().size()) {
            System.out.println("No se puede rehacer ninguna acción.");
            return null;
        } else {
            this.currentOption += 1;
            System.out.println("Éxito al rehacer.");
            return this.versiones.get(currentOption).getO();
        }
    }

    /**
     * Rehace la última acción deshecha. Devuelve el proyecto posterior a la
     * acción rehecha o null en caso de que no se pueda rehacer ninguna acción.
     *
     * @return Object - (Proyecto)
     */
    public Object undo() {
        if (this.currentOption == -1 || this.currentOption == 0) {
            System.out.println("No se puede deshacer ninguna acción.");
            return null;
        } else {
            this.currentOption -= 1;
            System.out.println("Éxito al deshacer.");
            return this.versiones.get(currentOption).getO();
        }
    }

    /**
     * Devuelve un entero con la última opción seleccionada por el usuario. Si
     * todavía no se ha realizado ninguna acción, devuelve -1.
     *
     * @return opcionElegida - int
     */
    public int opcionVersionActual() {
        if (this.versiones.isEmpty() || this.getCurrentOption() == -1) {
            return -1;
        }
        return this.versiones.get(currentOption).getOpcion();
    }

    /**
     * Revisa las versiones anteriores a la actual para determinar si la opción
     * que vamos a deshacer es única. Saber que es única o no, nos permite
     * decidir si tenemos que desactivar alguna opción de menú o no. NOTA: por
     * defecto, al deshacer una acción, siempre se desactivará la opción de
     * "Mostrar Tabla".
     *
     * @param opc
     * @return boolean
     */
    public boolean esUnica(int opc) {
        if (this.versiones.isEmpty() || opc == -1) {
            return false;
        } else {
            boolean unica = false;
            int contador = 0;
            for (Version v : this.getVersiones().subList(0, this.getCurrentOption() + 2)) {
                if (v.getOpcion() == opc) {
                    contador++;
                }
            }
            if (contador > 1) {
                unica = false;
            } else {
                unica = true;
            }
            return unica;
        }
    }
}
