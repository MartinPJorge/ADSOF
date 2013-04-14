/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import es.uam.eps.adsof.batalla5ejercitos.factorias.*;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iván
 */
public class ControlEjercito implements ActionListener{
    private EjercitoVista ejV;
    private HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas;
    final private CriaturaFactoria[] facts;
            
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

    public HashMap<CriaturaFactoria, ArrayList<Integer>> getDescTropas() {
        return descTropas;
    }

    public void setDescTropas(HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas) {
        this.descTropas = descTropas;
    }

    public EjercitoVista getEjV() {
        return ejV;
    }

    public void setEjV(EjercitoVista ejV) {
        this.ejV = ejV;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ejV.getUnidades().intValue()<=0){
            JOptionPane.showMessageDialog( null, "Debe especificar un número válido de unidades para la nueva Tropa."
                    + "(unidades>0)", "Error al añadir Tropa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String factName = "es.uam.eps.adsof.batalla5ejercitos.factorias." + ejV.getTropas().getSelectedItem() + "Factoria";
        Class f;
        CriaturaFactoria cf;
        try {
            f = Class.forName(factName);
            cf = (CriaturaFactoria) f.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControlEjercito.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        int index = ejV.getTropas().getSelectedIndex();
        if(facts[index].getClass().equals(cf.getClass())){
            cf = facts[index];
        }else{
            System.out.println("Error de Factorias.");
            return;
        }
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
    
    public void resetearEjercito(){
        this.setDescTropas(new HashMap<CriaturaFactoria, ArrayList<Integer>>());
        
        DefaultTableModel tabMod = (DefaultTableModel) this.getEjV().getTabla().getModel();
        
        tabMod.getDataVector().removeAllElements();
        tabMod.fireTableDataChanged();

        Object[] obs = {"---", 0};
        tabMod.addRow(obs);    

    }
}
