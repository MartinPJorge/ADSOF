/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Iván
 */
public class SimuladorVista extends JFrame{
    private EjercitoVista ejL;
    private EjercitoVista ejO;
    private JLabel picLabel;
    private JButton comienzo;
    
    public SimuladorVista(String title) throws HeadlessException {
        super(title);
        
        Container cont = this.getContentPane();
        cont.setLayout(new SpringLayout());
        JPanel arriba = new JPanel(new SpringLayout());

        
        String[] tropasLibres = {"Hombre", "Elfo", "ElfoNoldor", "Enano"};
        String[] tropasOscuras = {"Orco", "OrcoUrukhai", "Huargo"};
        ejL = new EjercitoVista("Ejército Pueblos Libres", tropasLibres);        
        ejO = new EjercitoVista("Ejército Oscuro", tropasOscuras);

        
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("../batalla5ejercitos/Batalla_de_los_Cinco_Ejercitos.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: no se encuentra la imagen con el fondo.");
            return;
        }
        picLabel = new JLabel(new ImageIcon( myPicture ));
        picLabel.setPreferredSize(new Dimension(700, 250));
        picLabel.setMaximumSize(new Dimension(900, 300));
        arriba.add(ejL);
        arriba.add(picLabel);
        arriba.add(ejO);
        SpringUtilities.makeCompactGrid(arriba, 1, 3, 7, 7, 7, 7);
        arriba.setVisible(true);
        
        JPanel abajo = new JPanel(new FlowLayout());
        comienzo = new JButton("Comenzar simulación");
        abajo.add(comienzo);
        abajo.setVisible(true);
        
        cont.add(arriba);
        cont.add(abajo);
        SpringUtilities.makeCompactGrid(cont, 2, 1, 7, 7, 7, 7);
        this.setSize(1500, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.pack();
    }

    public EjercitoVista getEjL() {
        return ejL;
    }

    public void setEjL(EjercitoVista ejL) {
        this.ejL = ejL;
    }

    public EjercitoVista getEjO() {
        return ejO;
    }

    public void setEjO(EjercitoVista ejO) {
        this.ejO = ejO;
    }

    public JLabel getPicLabel() {
        return picLabel;
    }

    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }
    
    public void setControlador(ActionListener c) {
        comienzo.addActionListener(c);
    }
}
