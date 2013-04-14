/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import java.text.DecimalFormat;
import javax.swing.*;
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
    private JScrollPane tabla;

//    public EjercitoVista(String nombre, String[] troops){
//        super();
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.setName(nombre);
//        this.makeSelector(troops);
//        agregar = new JButton("Agregar");
//        agregar.setVisible(true);
//        this.add(agregar);
//        this.makeTable();
//    }
    public EjercitoVista(String nombre, String[] troops) {
        super();
        this.setLayout(new SpringLayout());
        this.setName(nombre);
        this.makeSelector(troops);
        agregar = new JButton("Agregar");
        agregar.setVisible(true);
        this.add(agregar);
        this.makeTable();
        SpringUtilities.makeCompactGrid(this, 3, 1, 10, 10, 10, 10);
        this.setVisible(true);
    }

    public final void makeSelector(String[] troops) {
        JPanel panel = new JPanel(new SpringLayout());

        JLabel tipo = new JLabel("Tipo de Tropa:");
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

    public final void makeTable() {
        String[] cols = {"Tipo", "Unidades"};
        Object[][] obs = {{"--", 0}};
        JTable t = new ZebraJTable(new MiModeloTabla(cols, obs, -1));
        TableColumn columna = t.getColumn("Tipo");

        columna.setMaxWidth(200);
        columna = t.getColumn("Unidades");

        columna.setMaxWidth(200);
        tabla = new JScrollPane(t);
        this.add(tabla);

    }

    public JButton getAgregar() {
        return agregar;
    }

    public void setAgregar(JButton agregar) {
        this.agregar = agregar;
    }

    public JPanel getSelector() {
        return selector;
    }

    public void setSelector(JPanel selector) {
        this.selector = selector;
    }

    public JScrollPane getTabla() {
        return tabla;
    }

    public void setTabla(JScrollPane tabla) {
        this.tabla = tabla;
    }

    public JComboBox getTropas() {
        return tropas;
    }

    public void setTropas(JComboBox tropas) {
        this.tropas = tropas;
    }

    public JFormattedTextField getUnid() {
        return unid;
    }

    public void setUnid(JFormattedTextField unid) {
        this.unid = unid;
    }

    // método para asignar un controlador al botón
    public void setControlador(ActionListener c) {
        agregar.addActionListener(c);
//        tropas.addActionListener(c);
    }

    
   
// método que devuelve el nombre de una tarea (contenido del campo JTextField)
    public String getTropa() {
        return tropas.getActionCommand();
    }
    
    public Integer getUnidades(){
        return (Integer)unid.getValue();
    }
}
