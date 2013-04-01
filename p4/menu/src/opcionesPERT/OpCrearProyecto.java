/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import java.util.Scanner;
import myException.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 * Esta opcion de MenuConsola recibe por teclado la informacion necesaria para
 * crear un nuevo Proyecto vacio, lo crea y lo devuelve.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpCrearProyecto extends MenuItem {

    /**
     * Constructor por defecto de la clase OpCrearProyecto.
     */
    public OpCrearProyecto() {
        super("Crear proyecto", true, "Devuelve el proyecto PERT creado.");
    }

    /**
     * Solicita por teclado la informacion necesaria para crear un nuevo
     * Proyecto vacio, lo crea y lo devuelve.
     *
     * @param o - Object(unused)
     * @return p - Proyecto creado
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {

        double pO, pM, pP;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNuevo Proyecto:");
        System.out.print("Peso optimista: ");
        pO = scan.nextDouble();
        System.out.print("Peso probable: ");
        pM = scan.nextDouble();
        System.out.print("Peso pesimista: ");
        pP = scan.nextDouble();

        System.out.println("El nuevo proyecto ha sido creado correctamente.");
        return new Proyecto(pO, pM, pP);
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for (MenuItem item : menuConsola.getItems()) {
            if (item.getNombre().equals("Añadir Tarea")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
