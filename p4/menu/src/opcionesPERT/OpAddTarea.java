/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import myException.TareaExistenteException;
import myException.OpcionNoActivaException;
import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.Scanner;
import myException.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 * Esta opcion de MenuConsola recibe como argumento un Proyecto y solicita la
 * informacion necesaria para crear una nueva Tarea y añadirla al Proyecto.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpAddTarea extends MenuItem {

    /**
     * Constructor por defecto de la clase OpAddTarea. Esta opción de menú será
     * posible rehacerla y deshacerla.
     */
    public OpAddTarea() {
        super("Añadir Tarea", false,
                "Añade una nueva Tarea a un proyecto PERT creado anteriormente. Los datos"
                + " se pedirán por teclado.");
        this.setUndoRedoable(true);
    }

    /**
     * Determina si el nombre de una Tarea ya existe en el Proyecto, para evitar
     * que se cree una tarea con nombre idéntico a otra en el mismo Proyecto.
     *
     * @param p
     * @param nombreTarea
     * @return boolean
     */
    private boolean existe(Proyecto p, String nombreTarea) {
        for (Tarea nav : p.getTareas().values()) {
            if (nav.getNombre().equals(nombreTarea)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Solicita la informacion necesaria para crear una nueva Tarea y añadirla
     * al Proyecto.
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
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNueva Tarea:");
        System.out.print("Introduzca el nombre de la tarea:");
        String nombre = scan.nextLine();


        if (this.existe(p, nombre)) {
            throw new TareaExistenteException();
        }

        System.out.print("Introduzca la duración optimista:");
        int dO = scan.nextInt();
        System.out.print("Introduzca la duración más probable:");
        int dM = scan.nextInt();
        System.out.print("Introduzca la duración pesimista:");
        int dP = scan.nextInt();
        Tarea t = new Tarea(dO, dM, dP, nombre);
        p.addTarea(t);

        System.out.println("La tarea " + t.getNombre() + " ha sido creada y añadida al "
                + "proyecto actual correctamente.");

        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for (MenuItem item : menuConsola.getItems()) {
            if (item.getNombre().equals("Añadir Enlace")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
