/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import batalla5ejercitos.Batalla;

/**
 * Clase Factoría asociada a la clase de Criatura Oscura Orco.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OrcoFactoria implements CriaturaFactoria {

    /**
     * Crea un orco con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 2</li> <li><u>Ataque</u>: [2,4]</li> <li><u>Defensa</u>: [1,2]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados. Determina aleatoriamente si se creará un
     * Orco o un Orco Urukhai.
     *
     * @return Orco creado.
     */
    @Override
    public Criatura crearCriatura() {

        int r = Batalla.numAleatorio(0, 1);
        if (r == 0) {   //Creamos Orco
            int ataque = Batalla.numAleatorio(2, 4);
            int defensa = Batalla.numAleatorio(1, 2);
            return new Orco(2, ataque, defensa, 0);
        } else {    //Creamos Orco Uruk-hai
            int ataque = Batalla.numAleatorio(3, 5);
            int defensa = Batalla.numAleatorio(2, 3);
            return new OrcoUrukhai(2, ataque, defensa, 0);
        }

    }
}
