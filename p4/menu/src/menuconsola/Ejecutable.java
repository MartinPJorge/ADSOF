/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import myException.EjecucionExcepcion;

/**
 * Esta interfaz la implementara la clase MenuItem y todas las que hereden de
 * ella.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public interface Ejecutable {

    Object ejecutar(Object o) throws EjecucionExcepcion;
}
