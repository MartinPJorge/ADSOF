/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pert;

import java.io.IOException;
import java.util.HashMap;


/**
 *
 * @author e265832
 */
public class PERT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Proyecto p = new Proyecto("prueba1.pert");
        
        HashMap<String,Tarea> tareas = p.getTareas();
        Tarea[] arrTareas = tareas.values().toArray(new Tarea[0]);
        Tarea t1 = tareas.get("Fin");
        Tarea t2 = tareas.get("Inicio");
        Tarea t = tareas.get("Entrega");
        
        
        p.calculoOptimista(t1);
        p.calculoPesimista(t2);
        
        
        for(Tarea nav : arrTareas) {
            System.out.printf(nav.getNombre() + "\t" + Math.ceil(nav.getCO()) + "\t" + Math.ceil(nav.getCP()) + 
                    "\t" + Math.ceil(nav.getFO()) + "\t" + Math.ceil(nav.getFP()) + "\n");
        }
        
/*
        System.out.println(t.getCO());
        System.out.println(t.getCP());
        System.out.println(t.getFO());
        System.out.println(t.getFP());*/
    }
}
