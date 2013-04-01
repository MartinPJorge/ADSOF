/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myException.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 * Esta opcion de MenuConsola recibe por teclado el nombre de un fichero que
 * contenga información sobre un Proyecto, lo lee y lo carga en memoria.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpCargarProyecto extends MenuItem {

    /**
     * Constructor por defecto de la clase OpCargarProyecto.
     */
    public OpCargarProyecto() {
        super("Cargar Proyecto", true, "Carga un proyecto PERT a partir de un "
                + "fichero cuyo nombre se solicita por teclado.");
    }

    /**
     * Solicita por teclado el nombre de un fichero que contenga información
     * sobre un Proyecto, lo lee y lo carga en memoria.
     *
     * @param o - Object (unused)
     * @return p - Proyecto cargado
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        Scanner scan = new Scanner(System.in);
        Proyecto p = null;

        System.out.println("\nCargar Proyecto:");
        System.out.println("Introduzca el nombre del fichero a leer: ");
        String nombre = scan.nextLine();

        // Creamos un proyecto de fichero
        try {
            p = new Proyecto(nombre);
            System.out.println("El proyecto indicado ha sido cargado correctamente.");
        } catch (IOException ex) {
            System.out.println("Error, el fichero especificado no existe.");
            p = null;
        } finally {
            return p;
        }
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for (MenuItem item : menuConsola.getItems()) {
            if (item.getNombre().equals("Mostrar Tabla") == false) {
                item.setActiva(true);
            }
        }
    }
}
