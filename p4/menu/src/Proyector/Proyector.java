/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyector;

import java.io.IOException;
import java.util.HashMap;


/**
 *
 * En esta clase tendremos solamente el main para las clases Proyecto y Tarea.
 * 
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 */
public class Proyector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        if(args.length != 1) {
            System.out.println("Error en el número de argumentos.\nEl programa "
                    + "debe de recibir el 'fichero.pert' a evaluar.");
            return;
        }
        
        
        Proyecto p = new Proyecto(args[0]);
        HashMap<String,Tarea> tareas = p.getTareas();
        
        
        /*
         * Realizamos el calculo optimista de la tarea 'Fin', 
         * y el calculo pesimista de la tarea 'Inicio' para obtener
         * todos los campos referentes a las tareas del proyecto.
         */
        Tarea t = tareas.get("Fin");
        p.calculoOptimista(t);
        t = tareas.get("Inicio");
        p.calculoPesimista(t);
        
        
        // Imprimimos los datos
        p.printProyecto();        
        p.caminoCritico();
    }
}
