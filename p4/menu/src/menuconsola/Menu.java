/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import opcionesPERT.OpAddEnlace;
import opcionesPERT.OpAddTarea;
import opcionesPERT.OpCalculaTiempos;
import opcionesPERT.OpCargarDeFichero;
import opcionesPERT.OpCrearProyecto;
import opcionesPERT.OpMostrarTabla;

/**
 *
 * @author e265923
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
        menu.addOpcion(new OpCargarDeFichero());
        menu.addOpcion(new OpCrearProyecto());
        menu.addOpcion(new OpMostrarTabla());
        
        o = (Object) menu.ejecutar(o);
        
        System.out.println("Fin del menu.");
    }
}
