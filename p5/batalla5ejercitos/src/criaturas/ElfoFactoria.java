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
 * @author e265832
 */
public class ElfoFactoria implements CriaturaFactoria {
    
    /**
     * Crea un elfo con los atributos:<br/>
     * <ul>
     * <li><u>Ptos. de vida</u>: 2</li>
     * <li><u>Ataque</u>: [2,3]</li>
     * <li><u>Defensa</u>: [2,3]</li>
     * </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente 
     * entre los valores especificados.
     * @return 
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 3);
        int defensa = Batalla.numAleatorio(2, 3);
        
        return new Elfo(2, ataque, defensa, 0);
    }
}
