/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercitos;

import batalla5ejercitos.Batalla;
import criaturas.Criatura;
import criaturas.CriaturaFactoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class Tropa {
    private List<Criatura> criaturas;
    
    public Tropa(CriaturaFactoria factoria, int numGuerreros) {
        criaturas = new ArrayList<Criatura>();
        
        for(int i=0; i < numGuerreros; i++) {
            criaturas.add(factoria.crearCriatura());
        }
    }

    /**
     * 
     * @return las criaturas de una tropa
     */
    public List<Criatura> getCriaturas() {
        return criaturas;
    }
    
    
    
    /**
     * Determina si todos los miembros de la tropa est&aacute;n muertos.
     * @return 
     */
    public boolean estaAniquilada() {
        for(Criatura c : this.criaturas) {
            if(c.estaMuerto() == false) {return false;}
        }
        
        return true;
    }
    
    /**
     * Hace que cada guerrero de la tropa ataque a un guerrero de la tropa enemiga, 
     * elegida de forma aleatoria.
     * @param oponente 
     */
    public void atacar(Tropa oponente) {
        int indexEnemigo;
        
        for(Criatura c : this.criaturas) {
            indexEnemigo = Batalla.numAleatorio(0, oponente.getCriaturas().size());
            c.atacar(oponente.getCriaturas().get(indexEnemigo));
        }
    }
    
    /**
     * Aplica las heridas que han recibido todas las criaturas de la tropa en el 
     * &uacute;ltimo asalto.
     */
    public void aplicarHeridas() {
        for(Criatura c : this.criaturas) {
            c.aplicarHeridas(c.getHeridas());
        }
    }
}
