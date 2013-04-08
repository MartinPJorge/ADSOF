/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 * Esta clase, que extiende la clase Elfo, está asociada a la subraza de Orcos
 * Uruk-hai, participante en la Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class OrcoUrukhai extends Orco {

    /**
     * Constructor de la clase Orco Uruk-hai.
     *
     * @param ptosVida
     * @param ataque
     * @param defensa
     * @param heridas
     */
    public OrcoUrukhai(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }
}
