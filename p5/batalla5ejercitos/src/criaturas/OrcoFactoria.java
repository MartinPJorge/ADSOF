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
public class OrcoFactoria implements CriaturaFactoria {

    /**
     * Crea un orco con los atributos:<br/>
     * <ul>
     * <li><u>Ptos. de vida</u>: 2</li>
     * <li><u>Ataque</u>: [2,4]</li>
     * <li><u>Defensa</u>: [1,2]</li>
     * </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente 
     * entre los valores especificados.
     * @return 
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 4);
        int defensa = Batalla.numAleatorio(1, 2);
        
        return new Orco(2, ataque, defensa, 0);
    }
    
}
