/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla5ejercitos;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author e265832
 */
public class Batalla {
    private static Random r;
    
    public Batalla() {
        this.r = new Random(Calendar.getInstance().getTimeInMillis());
    }
    
    /**
     * Devuelve un n&uacute;mero aleatorio entre los valores 'a' y 'b' (ambos 
     * incluidos).
     * @param a - base
     * @param b - tope
     * @return el n&uacute;mero aleatorio
     */
    public static int numAleatorio(int a, int b) {
        return r.nextInt(b -a + 1) + a;
    }
}
