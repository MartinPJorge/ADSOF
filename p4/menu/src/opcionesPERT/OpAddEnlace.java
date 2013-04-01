/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import myException.TareaNoEncontradaException;
import myException.OpcionNoActivaException;
import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.HashMap;
import java.util.Scanner;
import myException.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 * Esta opción de MenuConsola recibe como argumento un Proyecto y solicita el
 * nombre de dos Tareas, las busca en el Proyecto, y si existen, las relaciona.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpAddEnlace extends MenuItem {

    /**
     * Constructor por defecto de la clase OpAddEnlace. Esta opción de menú será
     * posible rehacerla y deshacerla.
     */
    public OpAddEnlace() {
        super("Añadir Enlace", false, "Añade un nuevo enlace entre 2 Tareas del "
                + "Proyecto PERT sobre el que se está trabajando.");
        this.setUndoRedoable(true);
    }

    /**
     * Solicita el nombre de dos Tareas, las busca en el Proyecto, y si existen,
     * las relaciona.
     *
     * @param o - Object(Proyecto)
     * @return p - Proyecto
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {

        if (this.isActiva() == false) {
            throw new OpcionNoActivaException();
        }

        Proyecto p = (Proyecto) o;
        HashMap<String, Tarea> tareas = p.getTareas();
        Tarea tarea1 = null;
        Tarea tarea2 = null;
        System.out.println("\nNuevo Enlace:");
        // Buscamos la primera tarea
        System.out.println("Introduce la tarea anterior:");
        Scanner scan = new Scanner(System.in);
        String t1 = scan.nextLine();

        if (tareas.containsKey(t1)) {
            tarea1 = tareas.get(t1);
        } else {
            throw new TareaNoEncontradaException();
        }


        // Buscamos la seguda tarea
        System.out.println("Introduce la tarea posterior:");
        String t2 = scan.nextLine();

        if (tareas.containsKey(t2)) {
            tarea2 = tareas.get(t2);
        } else {
            throw new TareaNoEncontradaException();
        }


        // Enlazamos las tareas
        tarea1.getSiguientes().add(tarea2);
        tarea2.getAnteriores().add(tarea1);

        System.out.println("Las tareas " + tarea1.getNombre() + " y " + tarea2.getNombre()
                + " han sido enlazadas correctamente.");
        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for (MenuItem item : menuConsola.getItems()) {
            if (item.getNombre().equals("Calcular Tiempos")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
