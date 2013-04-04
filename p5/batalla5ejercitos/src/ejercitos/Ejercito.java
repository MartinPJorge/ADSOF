/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercitos;

import criaturas.Criatura;
import criaturas.CriaturaFactoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Jorge
 */
public class Ejercito {
    private ArrayList<Tropa> tropas;
    
    public Ejercito(HashMap<CriaturaFactoria,ArrayList<Integer>> tropasDescr) {
        tropas = new ArrayList<Tropa>();
        Set<CriaturaFactoria> factorias = tropasDescr.keySet();
        
        if(tropasNoCompatibles((CriaturaFactoria[])factorias.toArray())) {return;}
        
        //Recorremos las factorias
        for(CriaturaFactoria f : factorias) {
            ArrayList<Integer> unidades = tropasDescr.get(f);
            
            //Creamos una tropa de la factoria con 'u' unidades.
            for(int u : unidades) {
                tropas.add(new Tropa(f, u));
            }
        }
    }
    
    
    /**
     * Comprueba si entre las especies creadas por cada una de las factor&iacute;as 
     * se encuentra alguna que no coincida con el bando del resto.
     * @param factorias
     * @return 
     */
    private boolean tropasNoCompatibles(CriaturaFactoria[] factorias) {
        ArrayList<Criatura> criaturas = new ArrayList<Criatura>();
        boolean esLibre;
        
        //Creamos un array con criaturas
        for(CriaturaFactoria f : factorias) {
            criaturas.add(f.crearCriatura());
        }
        
        //Buscamos criaturas de distintos bandos.
        esLibre = criaturas.get(0).isCriaturaLibre();
        for(Criatura c : criaturas) {
            if(c.isCriaturaLibre() != esLibre) {return true;}
        }
        
        return false;
    }
}
