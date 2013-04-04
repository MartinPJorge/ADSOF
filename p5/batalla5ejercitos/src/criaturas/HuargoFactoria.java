/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import batalla5ejercitos.Batalla;

/**
 *
 * @author Jorge
 */
public class HuargoFactoria implements CriaturaFactoria {
    /**
     * Crea un huargo con los atributos:<br/>
     * <ul>
     * <li><u>Ptos. de vida</u>: 1</li>
     * <li><u>Ataque</u>: [1,3]</li>
     * <li><u>Defensa</u>: [2,4]</li>
     * </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente 
     * entre los valores especificados.
     * @return 
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 4);
        int defensa = Batalla.numAleatorio(1, 2);
        
        return new Huargo(1, ataque, defensa, 0);
    }
}
