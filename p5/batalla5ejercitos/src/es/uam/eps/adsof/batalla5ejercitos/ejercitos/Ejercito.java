/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.ejercitos;

import es.uam.eps.adsof.batalla5ejercitos.factorias.CriaturaFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.OrcoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.HombreFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.EnanoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.HuargoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.ElfoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.uam.eps.adsof.batalla5ejercitos.myException.EmptyArmyExc;
import es.uam.eps.adsof.batalla5ejercitos.myException.IncompatibleTypesExc;

/**
 * Esta clase representa cada uno de los dos ejércitos de la Batalla de los 5
 * Ejércitos. Un ejército está conformado por varias tropas.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public abstract class Ejercito {

    private ArrayList<Tropa> tropas;

    /**
     * Constuctor de la clase Ejercito.
     *
     * @param tropasDescr
     * @throws IncompatibleTypesExc
     * @throws EmptyArmyExc
     */
    public Ejercito(HashMap<CriaturaFactoria, ArrayList<Integer>> tropasDescr) throws IncompatibleTypesExc, EmptyArmyExc {
        if (tropasDescr.isEmpty()) {
            throw new EmptyArmyExc();
        }

        tropas = new ArrayList<Tropa>();
        Set<CriaturaFactoria> factorias = tropasDescr.keySet();
        CriaturaFactoria[] cFacts = (CriaturaFactoria[]) factorias.toArray(new CriaturaFactoria[factorias.size()]);
        
        tropasNoCompatibles(cFacts);

        
        //Recorremos las factorias
        for (CriaturaFactoria f : factorias) {
            ArrayList<Integer> unidades = tropasDescr.get(f);

            //Creamos una tropa de la factoria con 'u' unidades.
            for (int u : unidades) {
                tropas.add(new Tropa(f, u));
            }
        }
    }

    /**
     * Comprueba si entre las especies creadas por cada una de las
     * factor&iacute;as se encuentra alguna que no coincida con el bando del
     * resto.
     *
     * @param factorias
     * @return boolean
     */
    public abstract void tropasNoCompatibles(CriaturaFactoria[] factorias) throws IncompatibleTypesExc;


    /**
     * Método que realiza el ataque del Ejército this al Ejército eEnem
     *
     * @param eEnem
     */
    public void atacar(Ejercito eEnem) {
        int index;
        List<Tropa> tEnems = eEnem.getVivas();

        //Atacamos al azar con las tropas de nuestro Ejercito que sigan en pie
        for (Tropa t : this.getVivas()) {
            index = Batalla.numAleatorio(0, tEnems.size() - 1);
            t.atacar(tEnems.get(index));
        }
    }

    /**
     * Aplica las heridas que han recibido todas las tropas en el último asalto.
     */
    public void aplicarHeridas() {
        for (Tropa t : this.tropas) {
            t.aplicarHeridas();
        }
    }

    /**
     * Determina si todas las tropas de un Ejercito están aniquiladas.
     *
     * @return boolean
     */
    public boolean estaAniquilado() {
        for (Tropa t : this.tropas) {
            if (t.estaAniquilada() == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * toString de la clase Ejército
     *
     * @return String
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.tropas.size(); ++i) {
            if (this.tropas.get(i).estaAniquilada() == false) {
                s += "   ▸ Tropa " + (i + 1) + ": " + this.tropas.get(i).toString() + "\n";
            }
        }
        return "{\n" + s + "}";
    }
    
    
    /**
     * 
     * @return lista con las tropas vivas
     */
    public List<Tropa> getVivas(){
        List<Tropa> vivas = new ArrayList<Tropa>();
        for (Tropa t: this.tropas) {
            if(t.estaAniquilada()==false){
                vivas.add(t);
            }
        }
        return vivas;
    }
}
