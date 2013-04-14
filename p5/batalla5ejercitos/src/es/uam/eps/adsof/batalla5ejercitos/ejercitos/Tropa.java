/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.ejercitos;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.factorias.CriaturaFactoria;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa cada una de las tropas de cada raza que conforman los
 * ejércitos de la Batalla de los 5 Ejércitos. Cada Tropa está formada por
 * varias criaturas de una misma raza.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Tropa {

    private List<Criatura> criaturas;

    /**
     * Constructor de la clase Tropa.
     *
     * @param factoria
     * @param numGuerreros
     */
    public Tropa(CriaturaFactoria factoria, int numGuerreros) {
        criaturas = new ArrayList<Criatura>();
        for (int i = 0; i < numGuerreros; i++) {
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
     *
     * @return boolean
     */
    public boolean estaAniquilada() {
        for (Criatura c : this.criaturas) {
            if (c.estaMuerto() == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * Hace que cada guerrero de la tropa ataque a un guerrero de la tropa
     * enemiga, elegida de forma aleatoria.
     *
     * @param oponente
     */
    public void atacar(Tropa oponente) {
        int indexEnemigo;
        
        List<Criatura> vivasOp = oponente.getVivas();

        for (Criatura c : this.getVivas()) {
            indexEnemigo = Batalla.numAleatorio(0, vivasOp.size()-1);
            c.atacar(vivasOp.get(indexEnemigo));
        }
    }

    /**
     * Aplica las heridas que han recibido todas las criaturas de la tropa en el
     * &uacute;ltimo asalto.
     */
    public void aplicarHeridas() {
        for (Criatura c : this.criaturas) {
            c.aplicarHeridas(c.getHeridas());
        }
    }

    /**
     * toString de la clase Tropa.
     *
     * @return String
     */
    @Override
    public String toString() {
        int vivas=0;
        for(Criatura c : this.criaturas){
            if(c.estaMuerto()==false)
                vivas+=1;
        }
        return "Tipo de criaturas:" + criaturas.get(0).getClass().getSimpleName()
                + "\n\tUnidades:" + vivas + "\n";
    }
    
    
    public List<Criatura> getVivas(){
        List<Criatura> vivas = new ArrayList<Criatura>();
        for (Criatura c : this.criaturas) {
            if(c.estaMuerto()==false){
                vivas.add(c);
            }
        }
        return vivas;
    }
}
