/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

import batalla5ejercitos.Batalla;

/**
 * Clase Factoría asociada a la clase de Criatura Libre Elfo.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class ElfoFactoria implements CriaturaFactoria {

    /**
     * Crea un elfo con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 2</li> <li><u>Ataque</u>: [2,3]</li> <li><u>Defensa</u>: [2,3]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados. Determina aleatoriamente si se creará un
     * Elfo o un Elfo Noldor.
     *
     * @return Elfo creado.
     */
    @Override
    public Criatura crearCriatura() {

        int r = Batalla.numAleatorio(0, 1);
        if (r == 0) {   //Creamos Elfo
            int ataque = Batalla.numAleatorio(2, 3);
            int defensa = Batalla.numAleatorio(2, 3);
            return new Elfo(2, ataque, defensa, 0);
        } else {    //Creamos Elfo Noldor
            int ataque = Batalla.numAleatorio(3, 4);
            int defensa = Batalla.numAleatorio(3, 4);
            return new ElfoNoldor(2, ataque, defensa, 0);
        }
    }
}
