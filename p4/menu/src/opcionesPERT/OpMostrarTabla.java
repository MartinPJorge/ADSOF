/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import myException.OpcionNoActivaException;
import Proyector.Proyecto;
import Proyector.Tarea;
import java.util.Collection;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;
import myException.OpIncorrectaException;

/**
 * Esta opcion de MenuConsola recibe como argumento un Proyecto y muestra por
 * pantalla toda la informacion relativa al mismo.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpMostrarTabla extends MenuItem {

    /**
     * Constructor por defecto de la clase OpMostrarTabla.
     */
    public OpMostrarTabla() {
        super("Mostrar Tabla", false, "Muestra una tabla con las tareas del "
                + "proyecto.");
    }

    /**
     * Determina cómo se deberá imprimir el Proyecto para una mejor visualización.
     * @param p - Proyecto
     * @return boolean
     */
    private boolean dosTabuladores(Proyecto p) {
        for (Tarea t : p.getTareas().values()) {
            if (t.getNombre().length() >= 7) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recibe como argumento un Proyecto y muestra por
     * pantalla toda la informacion relativa al mismo.
     * @param o - Object(Proyecto) 
     * @return p - Proyecto.
     * @throws OpIncorrectaException
     */
    @Override
    public Object ejecutar(Object o) throws OpIncorrectaException {

        if (this.isActiva() == false) {
            throw new OpcionNoActivaException();
        }

        Proyecto p = (Proyecto) o;
        Collection<Tarea> tareas = p.getTareas().values();
        
        System.out.println("Tabla Resumen del Proyecto:");
        System.out.print("Nombre");
        if (this.dosTabuladores(p)) {
            System.out.print("\t\tdE\tcO\tcP\tfO\tfP\tholg.\n");
        } else {
            System.out.print("\tdE\tcO\tcP\tfO\tfP\tholg.\n");
        }


        for (Tarea nav : tareas) {
            System.out.print(nav);
        }
                 
        System.out.println("\n-------------");
        System.out.printf("Duracion estimada del proyecto : %d\n", (int)Math.ceil(p.getTareas().get("Fin").getFO()));
        System.out.println("-------------");
        
        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
