/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 * Esta clase abstracta, extiende la clase abstracta Criatura, y sobre ella se
 * basan todas las demás clases asociadas a las razas de Criaturas Oscuras de la
 * Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public abstract class CriaturaOscura extends Criatura {

    /**
     * Constructor de la clase abstracta Criatura Oscura.
     *
     * @param ptosVida
     * @param ataque
     * @param defensa
     * @param heridas
     */
    public CriaturaOscura(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }

    @Override
    public boolean isCriaturaLibre() {
        return false;
    }
}
