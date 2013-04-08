/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla5ejercitos;

import criaturas.CriaturaFactoria;
import criaturas.ElfoFactoria;
import ejercitos.Tropa;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * PRÁCTICA 5 - ANÁLISIS Y DISEÑO DE SOFTWARE. Esta clase contiene el main que
 * usaremos para simular la Batalla.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Batalla5ejercitos {

    /**
     * main principal de la práctica
     *
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        Batalla b = new Batalla();
        b.simularBatalla();
    }
}
