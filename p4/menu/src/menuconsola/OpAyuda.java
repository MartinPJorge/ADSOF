/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import java.awt.List;
import java.util.Scanner;
import opcionesPERT.OpcionInexistenteException;

/**
 *
 * @author e265923
 */
public class OpAyuda extends MenuItem{

    public OpAyuda(String nombre, Boolean activa, String ayuda) {
        super(nombre, activa, ayuda);
    }

    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        MenuConsola menuC = (MenuConsola) o;
        Scanner scan = new Scanner(System.in);
        System.out.println("Elige la opcion: ");
        String opcion = scan.nextLine();
        
        try {
            Integer num = Integer.parseInt(opcion);
            
            // Si la opcion no esta
            if((num > menuC.getItems().size()) || num < 1) {
                throw new OpcionInexistenteException();
            }
            
            menuC.getItems().get(num - 1).showAyuda();
        }
        catch(NumberFormatException ex) {
            char op = opcion.toLowerCase().charAt(0);
            
            if(op == 'a') {
                menuC.getSpecialItems().get(0).showAyuda();
            }
            else if(op == 's') {
                menuC.getSpecialItems().get(1).showAyuda();
            }
            else {
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
