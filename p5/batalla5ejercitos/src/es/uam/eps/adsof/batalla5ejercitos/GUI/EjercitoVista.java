/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Iván
 */
public class EjercitoVista extends JPanel {

    private JComboBox tropas;
    private JFormattedTextField unid;
    private JPanel selector;
    private JButton agregar;
    private JTable tabla;
    private JScrollPane scroll;


    
    /**
     * Constructor del panel encargado de a&ntilde;adir tropas al ej&eacute;rcito.
     * @param nombre
     * @param troops
     */
    public EjercitoVista(String nombre, String[] troops) {
        super();
        this.setLayout(new SpringLayout());
        this.setName(nombre);
        
        JLabel title = new JLabel(nombre);
        this.add(title);
        title.setVisible(true);
        
        JLabel title2 = new JLabel("Nueva Tropa:");
        this.add(title2);
        title2.setVisible(true);
        
        this.makeSelector(troops);
        agregar = new JButton("Agregar");
        agregar.setVisible(true);
        this.add(agregar);
        this.makeTable();
        
        SpringUtilities.makeCompactGrid(this, 5, 1, 10, 10, 10, 10);
        this.setVisible(true);
        
    }

    /**
     * Inicia los elementos desde los que se introducen los datos.
     * @param troops
     */
    public final void makeSelector(String[] troops) {
        JPanel panel = new JPanel(new SpringLayout());

        JLabel tipo = new JLabel("Tipo:");
        tropas = new JComboBox(troops);
        tipo.setLabelFor(tropas);
        panel.add(tipo);
        panel.add(tropas);

        JLabel unidades = new JLabel("Unidades:");
        unid = new JFormattedTextField(new Integer(0));
        unidades.setLabelFor(unid);
        panel.add(unidades);
        panel.add(unid);

        SpringUtilities.makeCompactGrid(panel, 2, 2, 6, 6, 6, 6);
        panel.setVisible(true);

        selector = panel;
        this.add(selector);
    }

    /**
     * Crea la tabla que muestra las tropas creadas.
     */
    public final void makeTable() {
        String[] cols = {"Tipo", "Unidades"};
        Object[][] obs = {{"---", 0}};
        JTable t = new ZebraJTable(new DefaultTableModel(obs, cols));
        TableColumn columna = t.getColumn("Tipo");
        columna.setMaxWidth(200);
        
        columna = t.getColumn("Unidades");
        columna.setMaxWidth(200);
        
        scroll = new JScrollPane(t);
        tabla = t;
        this.add(scroll);

        this.scroll.setPreferredSize(new Dimension(20, 200));
    }

    /**
     *
     * @return
     */
    public JButton getAgregar() {
        return agregar;
    }

    /**
     *
     * @param agregar
     */
    public void setAgregar(JButton agregar) {
        this.agregar = agregar;
    }

    /**
     *
     * @return
     */
    public JPanel getSelector() {
        return selector;
    }

    /**
     *
     * @param selector
     */
    public void setSelector(JPanel selector) {
        this.selector = selector;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScroll() {
        return scroll;
    }

    /**
     *
     * @param scroll
     */
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    /**
     *
     * @return
     */
    public JTable getTabla() {
        return tabla;
    }

    /**
     *
     * @param tabla
     */
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }


    /**
     *
     * @return
     */
    public JComboBox getTropas() {
        return tropas;
    }

    /**
     *
     * @param tropas
     */
    public void setTropas(JComboBox tropas) {
        this.tropas = tropas;
    }

    /**
     *
     * @return
     */
    public JFormattedTextField getUnid() {
        return unid;
    }

    /**
     *
     * @param unid
     */
    public void setUnid(JFormattedTextField unid) {
        this.unid = unid;
    }

    // método para asignar un controlador al botón
    /**
     *
     * @param c
     */
    public void setControlador(ActionListener c) {
        agregar.addActionListener(c);
    }
    
    /**
     *
     * @return
     */
    public Integer getUnidades(){
        return (Integer)unid.getValue();
    }
}
