/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.Collection;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;
import menuconsola.OpIncorrectaException;

/**
 *
 * @author Jorge
 */
public class OpMostrarTabla extends MenuItem{
    
    public OpMostrarTabla() {
        super("Mostrar Tabla", false, "Muestra una tabla con las tareas del "
                + "proyecto.");
    }
    
    private boolean dosTabuladores(Proyecto p) {
        for(Tarea t : p.getTareas().values()) {
            if(t.getNombre().length() >= 7)
                return true;
        }
        
        return false;
    }
    
    @Override
    public Object ejecutar(Object o) throws OpIncorrectaException {
        
        if(this.isActiva() == false) {
            throw new OpcionNoActivaException();
        }
        
        Proyecto p = (Proyecto) o;
        Collection<Tarea> tareas = p.getTareas().values();
        
        System.out.print("Nombre");
        if(this.dosTabuladores(p)) {
            System.out.print("\t\tdE\tcO\tcP\tfO\tfP\tholg.\n");
        }
        else {
            System.out.print("\tdE\tcO\tcP\tfO\tfP\tholg.\n");
        }
        
        
        for(Tarea nav : tareas) {
            System.out.print(nav);
        }
        return p;
    }
    
    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
