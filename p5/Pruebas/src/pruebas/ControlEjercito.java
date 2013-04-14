/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Iván
 */
public class ControlEjercito implements ActionListener{
    EjercitoVista ejV;
//    Ejercito ej;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ejV.getUnidades().intValue()<=0){
        //Error : JOptionPane.showMessageDialog( null, e.getMessage(), "Error al guardar Circulo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
