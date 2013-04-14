/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.factorias;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Orco;

/**
 * Clase Factoría asociada a la subclase de Criatura Oscura Orco, Orco Uruk-hai.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OrcoUrukhaiFactoria extends OrcoFactoria {

    /**
     * Crea un Orco con los atributos:<br/> <ul> <li><u>Ptos. de vida</u>:
     * 2</li> <li><u>Ataque</u>: [3,5]</li> <li><u>Defensa</u>: [2,3]</li> </ul>
     * Donde el ataque y la defensa toman un n&uacute;mero aleatorio permanente
     * entre los valores especificados. El Orco Uruk-hai creado será más
     * poderoso que un Orco normal, del que se distinguirá solamente por el
     * valor de sus atributos.
     *
     * @return Orco creado.
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(3, 5);
        int defensa = Batalla.numAleatorio(2, 3);
        return new Orco(2, ataque, defensa, 0);
    }
}
