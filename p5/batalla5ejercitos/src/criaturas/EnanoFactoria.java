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
public class EnanoFactoria implements CriaturaFactoria{

    /**
     * Crea un enano con los atributos:<br/>
     * <ul>
     * <li><u>Ptos. de vida</u>: 1</li>
     * <li><u>Ataque</u>: [1,4]</li>
     * <li><u>Defensa</u>: [1,2]</li>
     * </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente 
     * entre los valores especificados.
     * @return 
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(1, 4);
        int defensa = Batalla.numAleatorio(1, 2);
        
        return new Enano(1, ataque, defensa, 0);
    }
}
