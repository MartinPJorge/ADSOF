/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.HashMap;
import java.util.Scanner;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 *
 * @author Jorge
 */
public class OpAddEnlace extends MenuItem {
    
    public OpAddEnlace() {
        super("Añadir Enlace", false, "Añade un nuevo enlace entre 2 tareas.");
    }
    
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        
        if(this.isActiva() == false) {
            throw new OpcionNoActivaException();
        }
        
        Proyecto p = (Proyecto) o;
        HashMap<String, Tarea> tareas = p.getTareas();
        Tarea tarea1 = null;
        Tarea tarea2 = null;
        boolean encontrado = false;
        
        // Buscamos la primera tarea
        System.out.println("Introduce la tarea anterior:");
        Scanner scan = new Scanner(System.in);
        String t1 = scan.nextLine();
        
        if(tareas.containsKey(t1)) {tarea1 = tareas.get(t1);}
        else {throw new TareaNoEncontradaException();}

        
        // Buscamos la seguda tarea
        System.out.println("Introduce la tarea posterior:");
        String t2 = scan.nextLine();
        
        if(tareas.containsKey(t2)) {tarea2 = tareas.get(t2);}
        else {throw new TareaNoEncontradaException();}


        // Enlazamos las tareas
        tarea1.getSiguientes().add(tarea2);
        tarea2.getAnteriores().add(tarea1);
        
        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for(MenuItem item : menuConsola.getItems()) {
            if(item.getNombre().equals("Calcular Tiempos")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
