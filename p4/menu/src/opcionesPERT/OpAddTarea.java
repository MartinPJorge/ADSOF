/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import Proyector.Tarea;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;
import menuconsola.OpIncorrectaException;

/**
 *
 * @author e265923
 */
public class OpAddTarea extends MenuItem {
    
    public OpAddTarea() {
        super("Añadir Tarea", false, 
                "Añade una nueva Tarea a un proyecto PERT creado anteriormente. Los datos"
                + " se pedirán por teclado.");
    }
    
    private boolean existe(Proyecto p, String nombreTarea) {
        for(Tarea nav : p.getTareas().values()) {
            if(nav.getNombre().equals(nombreTarea)){
                return true;
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Nueva Tarea:");
        System.out.print("Introduzca el nombre de la tarea:");
        String nombre = scan.nextLine();
        
        
        if(this.existe(p, nombre)) {
            throw new TareaExistenteException();
        }
        
        System.out.print("Introduzca la duración optimista:");
        int dO = scan.nextInt();
        System.out.print("Introduzca la duración más probable:");
        int dM = scan.nextInt();
        System.out.print("Introduzca la duración pesimista:");
        int dP = scan.nextInt();
        Tarea t = new Tarea(dO, dM, dP, nombre);
        p.addTarea(t);
        

        
        return p;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for(MenuItem item : menuConsola.getItems()) {
            if(item.getNombre().equals("Añadir Enlace")) {
                item.setActiva(true);
                break;
            }
        }
    }
}
