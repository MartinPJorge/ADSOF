/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 * Esta clase, que extiende la clase abstracta CriaturaLibre, está asociada a la
 * raza Hombre, participante en la Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Hombre extends CriaturaLibre {

    /**
     * Constructor de la clase Hombre.
     *
     * @param ptosVida
     * @param ataque
     * @param defensa
     * @param heridas
     */
    public Hombre(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }
}
