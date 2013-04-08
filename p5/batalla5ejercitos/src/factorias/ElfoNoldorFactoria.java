/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorias;

import batalla5ejercitos.Batalla;
import criaturas.Criatura;
import criaturas.Elfo;

/**
 * Clase Factoría asociada a la subclase de Criatura Libre Elfo, Elfo Noldor.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class ElfoNoldorFactoria extends ElfoFactoria {

    /**
     * Crea un elfo con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 2</li> <li><u>Ataque</u>: [2,3]</li> <li><u>Defensa</u>: [2,3]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados. El Elfo Noldor creado será más poderoso
     * que un Elfo normal, del que se distinguirá solamente por el valor de sus
     * atributos.
     *
     * @return Elfo creado.
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(3, 4);
        int defensa = Batalla.numAleatorio(3, 4);
        return new Elfo(2, ataque, defensa, 0);
    }
}
