/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoLibre;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoOscuro;
import es.uam.eps.adsof.batalla5ejercitos.myException.EmptyArmyExc;
import es.uam.eps.adsof.batalla5ejercitos.myException.IncompatibleTypesExc;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class ControlSimulador implements ActionListener{
    private SimuladorVista simV;
    private ControlEjercito ejL;
    private ControlEjercito ejO;
    private Batalla bat;
    
    public ControlSimulador(SimuladorVista simV, ControlEjercito ejL, ControlEjercito ejO) {
        this.simV = simV;
        this.ejL = ejL;
        this.ejO = ejO;
    }

    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(this.ejL.getDescTropas().isEmpty() || this.ejO.getDescTropas().isEmpty()){
            JOptionPane.showMessageDialog( null, "Existe al menos un Ejército sin Tropas.\nElija un tipo de Tropa, "
                    + "introduzca sus unidades (unidades>0) y pulse el botón 'Agregar' para añadir una Tropa.", 
                    "Error al comenzar simulación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        this.bat = new Batalla();
        List<String> res;
        EjercitoLibre libre;
        EjercitoOscuro oscuro;
        
        try {
            //Creamos ejercitos y borramos la ventana
            libre = new EjercitoLibre(this.ejL.getDescTropas());
            oscuro = new EjercitoOscuro(this.ejO.getDescTropas());
            this.simV.getResult().setText("");
            
            int ronda = 1;
            while(bat.isFinBatalla()==false){
                simV.imprimirBuff("------RONDA "+ronda+"------\n", Color.BLACK);
                res = bat.lanzarRonda(libre, oscuro);
                
                if(res.size() == 2) {
                    simV.imprimirBuff(res);
                }
                //Fin de batalla
                else if(res.size() == 3) {
                    simV.imprimirBuff(res.subList(0, 1));
                    Color verdeOscuro = new Color(16, 102, 18);
                    simV.imprimirBuff(res.get(2), verdeOscuro);
                }
                
                ronda++;
            }
            
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            Logger.getLogger(ControlSimulador.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Reseteamos el ejercito
        this.ejL.resetearEjercito();
        this.ejO.resetearEjercito();
    }
    
}
