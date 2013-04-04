/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 *
 * @author e265832
 */
public abstract class CriaturaOscura extends Criatura {
    public CriaturaOscura(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }
    
    @Override
    public boolean isCriaturaLibre() {
        return false;
    }
}
