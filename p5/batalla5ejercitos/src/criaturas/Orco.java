/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import batalla5ejercitos.Batalla;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Jorge
 */
public class Orco extends CriaturaOscura implements PrimerNacido {

    public Orco(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }
    
    @Override
    public boolean curarHerida() {
        Random r = new Random(Calendar.getInstance().getTimeInMillis());
        double aleat = r.nextDouble();
        
        return aleat <= 0.2;
    }
    
}
