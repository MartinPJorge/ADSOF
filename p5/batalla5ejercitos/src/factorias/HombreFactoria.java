/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorias;

import batalla5ejercitos.Batalla;
import criaturas.Criatura;
import criaturas.Hombre;

/**
 * Clase Factoría asociada a la clase de Criatura Libre Hombre.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class HombreFactoria implements CriaturaFactoria {

    /**
     * Crea un hombre con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 1</li> <li><u>Ataque</u>: [2,4]</li> <li><u>Defensa</u>: [1,3]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados.
     *
     * @return Hombre creado.
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 4);
        int defensa = Batalla.numAleatorio(1, 3);

        return new Hombre(1, ataque, defensa, 0);
    }
}
