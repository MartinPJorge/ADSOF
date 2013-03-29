/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 *
 * @author e265923
 */
public class OpCrearProyecto extends MenuItem {
    private final static String[] opcionesQueActiva = {"Añadir Tarea"};

    public OpCrearProyecto() {
        super("Crear proyecto", true, "Devuelve el proyecto PERT creado.");
    }

    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        
        double pO, pM, pP;
        Scanner scan = new Scanner(System.in);
        System.out.print("Peso optimista: ");
        pO = scan.nextDouble();
        System.out.print("Peso probable: ");
        pM = scan.nextDouble();
        System.out.print("Peso pesimista: ");
        pP = scan.nextDouble();
        
        return new Proyecto(pO, pM, pP);
    }
    
    public static String[] getQueActiva() {
        return OpCrearProyecto.opcionesQueActiva;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        List<MenuItem> items = menuConsola.getItems();
        
        for(MenuItem item : menuConsola.getItems()) {
            if(item.getNombre().equals("Añadir Tarea")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
