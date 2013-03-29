/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.Collection;
import java.util.HashMap;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 *
 * @author Jorge
 */
public class OpCalculaTiempos extends MenuItem {
    
    public OpCalculaTiempos() {
        super("Calcular Tiempos", false, "Calcula los tiempos optimistas, "
                + "pesimistas y holguras del proyecto.");
    } 
    
    private boolean haySinEnlazar(Proyecto p) {
        HashMap<String, Tarea> hashTareas = p.getTareas();
        Collection<Tarea> tareas = hashTareas.values();
        Tarea t;
        
        // Miramos si hay tareas sin anteriores o siguientes
        t = hashTareas.get("Inicio");
        if(t.getSiguientes().isEmpty()) {return true;}
        t = hashTareas.get("Fin");
        if(t.getAnteriores().isEmpty()) {return true;}
        
        
        for(Tarea nav : tareas) {
            if((nav.getNombre().equals("Inicio") == false) && (nav.getNombre().equals("Fin") == false)) {
                if(nav.getAnteriores().isEmpty() || nav.getSiguientes().isEmpty()) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        
        if(this.isActiva() == false) {
            throw new OpcionNoActivaException();
        }
        
        Proyecto p = (Proyecto) o;
        
        // Si hay tareas sin enlazar
        if(this.haySinEnlazar(p)) {
            throw new SinEnlazarException();
        }
        
        HashMap<String, Tarea> hashTareas = p.getTareas();
        
        // Calculos optimistas y pesimistas
        p.calculoOptimista(hashTareas.get("Fin"));
        p.calculoPesimista(hashTareas.get("Inicio"));
        /* Como las holguras son la resta, no se llama al metodo hasta que
         * no mostremos la tabla.*/
        
        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for(MenuItem item : menuConsola.getItems()) {
            if(item.getNombre().equals("Mostrar Tabla")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
