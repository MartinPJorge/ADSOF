/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opcionesPERT;

import Proyector.Proyecto;
import Proyector.Tarea;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuconsola.EjecucionExcepcion;
import menuconsola.MenuConsola;
import menuconsola.MenuItem;

/**
 *
 * @author Jorge
 */
public class OpCargarDeFichero extends MenuItem{

    public OpCargarDeFichero() {
        super("Cargar Proyecto", true, "Crea un nuevo proyecto partiendo de uno"
                + " de fichero.");
    }
    
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        Scanner scan = new Scanner(System.in);
        Proyecto p = null;
        
        System.out.println("Pon el nombre del fichero a leer: ");
        String nombre = scan.nextLine();
        
        // Creamos un proyecto de fichero
        try {
            p = new Proyecto(nombre);
        } catch (IOException ex) {
            Logger.getLogger(OpCargarDeFichero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, el fichero especificado no existe.");
        }
        finally{
            return p;
        }
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        for(MenuItem item : menuConsola.getItems()) {
            if(item.getNombre().equals("Mostrar Tabla") == false) {
                item.setActiva(true);
            }
        }
    }
}
