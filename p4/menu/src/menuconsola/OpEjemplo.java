/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 *
 * @author Jorge
 */
public class OpEjemplo extends MenuItem{

    public OpEjemplo() {
        super("Opcion Ejemplo", true, "Es una mera opcion de ejemplo.");
    }
    
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        System.out.println("Se ha ejecutado la opcion de ejemplo.");
        
        return o;
    }
    
    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
