/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;



/**
 *
 * @author Jorge
 */
public class EjemploEj1 {
    public static void main(String[] args) {
        Object o = new Object();

        MenuConsola menu = new MenuConsola("APLICACIÓN EJEMPLO");
        menu.addOpcion(new OpSubMenu());

        
        o = (Object) menu.ejecutar(o);
        
        System.out.println("Fin del menu.");
    }
}
