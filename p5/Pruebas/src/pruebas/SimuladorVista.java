/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.*;
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
    private JPanel ejL;
    private JPanel ejO;
    private JLabel picLabel;
    
    public SimuladorVista(String title) throws HeadlessException {
        super(title);
        
        Container cont = this.getContentPane();
        cont.setLayout(new SpringLayout());
        JPanel arriba = new JPanel(new SpringLayout());

        
        String[] tropasLibres = {"Humano", "Elfo", "ElfoNoldor", "Enano"};
        String[] tropasOscuras = {"Orco", "OrcoUrukhai", "Huargo"};
        ejL = new EjercitoVista("Ejercito Libre", tropasLibres);        
        ejO = new EjercitoVista("Ejercito Oscuro", tropasOscuras);
        
        
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("../Pruebas/src/Batalla_de_los_Cinco_Ejercitos.JPG"));
        } catch (IOException ex) {
            Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: no se encuentra la imagen con el fondo.");
            return;
        }
        picLabel = new JLabel(new ImageIcon( myPicture ));
        
        arriba.add(ejL);
        arriba.add(picLabel);
        arriba.add(ejO);
        SpringUtilities.makeCompactGrid(arriba, 1, 3, 7, 7, 7, 7);
        arriba.setVisible(true);
        
        JPanel abajo = new JPanel(new FlowLayout());
        abajo.add(new JButton("Comenzar simulación"));
        abajo.setVisible(true);
        
        cont.add(arriba);
        cont.add(abajo);
        SpringUtilities.makeCompactGrid(cont, 2, 1, 7, 7, 7, 7);
        this.setSize(1500, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getEjL() {
        return ejL;
    }

    public void setEjL(JPanel ejL) {
        this.ejL = ejL;
    }

    public JPanel getEjO() {
        return ejO;
    }

    public void setEjO(JPanel ejO) {
        this.ejO = ejO;
    }

    public JLabel getPicLabel() {
        return picLabel;
    }

    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }
    
}
