/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 *
 * @author e265832
 */
public abstract class CriaturaLibre extends Criatura {
    public CriaturaLibre(int ptosVida, int ataque, int defensa, int heridas) {
        super(ptosVida, ataque, defensa, heridas);
    }
    
    @Override
    public boolean isCriaturaLibre() {
        return true;
    }
}
