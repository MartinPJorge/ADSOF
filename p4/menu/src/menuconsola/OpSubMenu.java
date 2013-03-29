/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 *
 * @author Jorge
 */
public class OpSubMenu extends MenuItem{
    private boolean fin;
    
    public OpSubMenu() {
        super("Submenu", true, "Lanza un submenu.");
        this.fin = false;
    }
    
    @Override
    public Object ejecutar(Object o) throws EjecucionExcepcion {
        MenuConsola submenu = new MenuConsola("Submenu");
        
        submenu.addOpcion(new OpEjemplo());
        
        submenu.ejecutar(o);
        
        return o;
    }
    
    @Override
    public void activarSiguientes(MenuConsola menuConsola) {
        return;
    }

}
