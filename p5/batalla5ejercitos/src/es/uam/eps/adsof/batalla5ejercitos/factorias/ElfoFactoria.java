/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.factorias;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Elfo;

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
     * entre los valores especificados.
     *
     * @return Elfo creado.
     */
    @Override
    public Criatura crearCriatura() {
        int ataque = Batalla.numAleatorio(2, 3);
        int defensa = Batalla.numAleatorio(2, 3);
        return new Elfo(2, ataque, defensa, 0);
    }
}