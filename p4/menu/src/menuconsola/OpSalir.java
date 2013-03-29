/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 *
 * @author e265923
 */
public class OpSalir extends MenuItem{

    public OpSalir(String nombre, Boolean activa, String ayuda) {
        super(nombre, activa, ayuda);
    }

    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        return o;
    }

    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }
}
