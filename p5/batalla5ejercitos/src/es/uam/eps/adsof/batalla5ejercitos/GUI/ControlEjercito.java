/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import es.uam.eps.adsof.batalla5ejercitos.factorias.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase controladora de un EjercitoVista.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class ControlEjercito implements ActionListener{
    private EjercitoVista ejV;
    private HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas;
    final private CriaturaFactoria[] facts;
            
    /**
     * Inicia un controlador de ej&eacute;rcito
     * @param ejV
     */
    public ControlEjercito(EjercitoVista ejV) {
        this.ejV = ejV;

        if(this.ejV.getName().equals("Ejército Pueblos Libres")){
            this.facts = new CriaturaFactoria[]{new HombreFactoria(), new ElfoFactoria(), new ElfoNoldorFactoria(), new EnanoFactoria()};
        }else if(this.ejV.getName().equals("Ejército Oscuro")){
            this.facts = new CriaturaFactoria[]{new OrcoFactoria(), new OrcoUrukhaiFactoria(), new HuargoFactoria()};
        }else{
            System.out.println("Critical error. Unrecognised army type.");
            this.descTropas = null;
            this.facts = null;
            this.descTropas = null;
            return;
        }
            
        this.descTropas = new HashMap<CriaturaFactoria, ArrayList<Integer>>();
    }

    /**
     *
     * @return HashMap asociado
     */
    public HashMap<CriaturaFactoria, ArrayList<Integer>> getDescTropas() {
        return descTropas;
    }

    /**
     *
     * @param descTropas
     */
    public void setDescTropas(HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas) {
        this.descTropas = descTropas;
    }

    /**
     *
     * @return EjercitoVista asociado
     */
    public EjercitoVista getEjV() {
        return ejV;
    }

    /**
     *
     * @param ejV
     */
    public void setEjV(EjercitoVista ejV) {
        this.ejV = ejV;
    }
    
    
    /**
     * Acc&iacute;on a realizar al recivir un evento de una componente residente 
     * en la vista ejV.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ejV.getUnidades().intValue()<=0){
            JOptionPane.showMessageDialog( null, "Debe especificar un número válido de unidades para la nueva Tropa."
                    + "(unidades>0)", "Error al añadir Tropa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int index = ejV.getTropas().getSelectedIndex();
        
        CriaturaFactoria cf = facts[index];
        
        ArrayList<Integer> units = descTropas.get(cf);
        if (units == null) {
            units = new ArrayList<Integer>();
        }
        units.add(ejV.getUnidades().intValue());
        
        this.descTropas.put(cf, units);
        
        JTable t = this.ejV.getTabla();
        if(t.getValueAt(0, 1)==0){
            t.setValueAt(ejV.getTropas().getSelectedItem(), 0, 0);
            t.setValueAt(ejV.getUnidades().intValue(), 0, 1);
        }else{
            DefaultTableModel tabMod = (DefaultTableModel) t.getModel();
            Object[] newRow = {ejV.getTropas().getSelectedItem(),ejV.getUnidades().intValue()};
            tabMod.addRow(newRow);
        }
        this.ejV.getScroll().setViewportView(t);

    }
    
    /**
     * Borra los elementos de las tablas de tropas que han quedado de la anterior 
     * simulaci&oacute;n.
     */
    public void resetearEjercito(){
        this.setDescTropas(new HashMap<CriaturaFactoria, ArrayList<Integer>>());
        
        DefaultTableModel tabMod = (DefaultTableModel) this.getEjV().getTabla().getModel();
        
        tabMod.getDataVector().removeAllElements();
        tabMod.fireTableDataChanged();

        Object[] obs = {"---", 0};
        tabMod.addRow(obs);    
    }
}
