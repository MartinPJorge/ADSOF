/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoLibre;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoOscuro;
import es.uam.eps.adsof.batalla5ejercitos.factorias.CriaturaFactoria;
import es.uam.eps.adsof.batalla5ejercitos.myException.EmptyArmyExc;
import es.uam.eps.adsof.batalla5ejercitos.myException.IncompatibleTypesExc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        String ganador;
        try {
            ganador = bat.simularBatalla(new EjercitoLibre(this.ejL.getDescTropas()), new EjercitoOscuro(this.ejO.getDescTropas()));
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            Logger.getLogger(ControlSimulador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog( null, "Error en la creación de Ejércitos.", 
                    "Error de simulación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog( null, ganador, "La Batalla de los 5 Ejércitos ha terminado", JOptionPane.INFORMATION_MESSAGE);
        
        this.ejL.resetearEjercito();
        this.ejO.resetearEjercito();
        
    }
    
}
