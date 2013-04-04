/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author e265832
 */
public class Elfo extends CriaturaLibre implements PrimerNacido{

    public Elfo(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }

    /**
     * 
     * @return true - cura la herida
     *         false - no la cura
     */
    @Override
    public boolean curarHerida() {
        Random r = new Random(Calendar.getInstance().getTimeInMillis());
        double aleat = r.nextDouble();
        
        return aleat <= 0.3;
    }
}
