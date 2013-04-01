/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import opcionesPERT.OpAddEnlace;
import opcionesPERT.OpAddTarea;
import opcionesPERT.OpCalculaTiempos;
import opcionesPERT.OpCargarProyecto;
import opcionesPERT.OpCrearProyecto;
import opcionesPERT.OpMostrarTabla;

/**
 * Main principal de la aplicacion.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object o = new Object();

        MenuConsola menu = new MenuConsola("APLICACIÓN PERT");
        menu.addOpcion(new OpAddEnlace());
        menu.addOpcion(new OpAddTarea());
        menu.addOpcion(new OpCalculaTiempos());
        menu.addOpcion(new OpCargarProyecto());
        menu.addOpcion(new OpCrearProyecto());
        menu.addOpcion(new OpMostrarTabla());

        o = (Object) menu.ejecutar(o);

        System.out.println("Fin del menu.");
    }
}
