/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 * Main de ejemplo con un MenuConsola con un pequeño submenu. Lo hemos usado
 * para comprobar que realmente se pueden crear Submenus complejos en caso de
 * que fuera necesario.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
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
