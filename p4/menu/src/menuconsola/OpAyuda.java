/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import myException.EjecucionExcepcion;
import myException.OpIncorrectaException;
import java.util.Scanner;
import myException.OpcionInexistenteException;

/**
 * Esta opcion de MenuConsola recibe despliega la ayuda correspondiente a la
 * opcion de MenuConsola selecionada.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OpAyuda extends MenuItem {

    /**
     * Constructor por defecto de la clase OpAyuda
     */
    public OpAyuda() {
        super("Ayuda.", true, "Muestra ayuda sobre una opción.");
    }

    /**
     * Permite visualizar por pantalla la ayuda sobre un MenuItem leído por
     * teclado.
     *
     * @param o (MenuConsola)
     * @return MenuConsola
     * @throws EjecucionExcepcion
     */
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        MenuConsola menuC = (MenuConsola) o;
        Scanner scan = new Scanner(System.in);
        System.out.println("Elige una opcion de menu para ver la ayuda relacionada: ");
        String opcion = scan.nextLine();

        try {
            Integer num = Integer.parseInt(opcion);

            // Si la opcion no esta
            if ((num > menuC.getItems().size()) || num < 1) {
                throw new OpcionInexistenteException();
            }

            menuC.getItems().get(num - 1).showAyuda();
        } catch (NumberFormatException ex) {
            char op = opcion.toLowerCase().charAt(0);

            if (op == 'a') {
                menuC.getSpecialItems().get(0).showAyuda();
            } else if (op == 'd') {
                menuC.getSpecialItems().get(1).showAyuda();
            } else if (op == 'r') {
                menuC.getSpecialItems().get(2).showAyuda();
            } else if (op == 's') {
                menuC.getSpecialItems().get(3).showAyuda();
            } else {
                throw new OpIncorrectaException();
            }
        }

        return o;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
