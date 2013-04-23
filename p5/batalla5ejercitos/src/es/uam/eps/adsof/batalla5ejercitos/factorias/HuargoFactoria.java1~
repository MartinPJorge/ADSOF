/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.factorias;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Huargo;

/**
 * Clase Factoría asociada a la clase de Criatura Oscura Huargo.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class HuargoFactoria implements CriaturaFactoria {

    /**
     * Crea un huargo con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 1</li> <li><u>Ataque</u>: [1,3]</li> <li><u>Defensa</u>: [2,4]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados.
     *
     * @return Huargo creado.
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 4);
        int defensa = Batalla.numAleatorio(1, 2);

        return new Huargo(1, ataque, defensa, 0);
    }
}
