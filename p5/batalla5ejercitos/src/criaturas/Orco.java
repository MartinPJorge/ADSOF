/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import java.util.Calendar;
import java.util.Random;

/**
 * Esta clase, que extiende la clase abstracta CriaturaOscura e implementa la
 * interfaz PrimerNacido, está asociada a la raza Orco, participante en la
 * Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Orco extends CriaturaOscura implements PrimerNacido {

    /**
     * Constructor de la clase Orco.
     *
     * @param ptosVida
     * @param ataque
     * @param defensa
     * @param heridas
     */
    public Orco(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }

    @Override
    public boolean curarHerida() {
        Random r = new Random(Calendar.getInstance().getTimeInMillis());
        double aleat = r.nextDouble();

        return aleat <= 0.2;
    }
    
    /**
     * Incrementa en 'numeroHeridas' las heridas de la criatura.
     *
     * @param numeroHeridas
     */
    @Override
    public void addHeridas(int numeroHeridas) {
        if(!curarHerida()) {
            this.heridas += numeroHeridas;
        }
    }
}