/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Iván
 */
public class SimuladorVista extends JFrame{
    private EjercitoVista ejL;
    private EjercitoVista ejO;
    private JLabel picLabel;
    private JPanel centro;
    private JButton comienzo;
    private JTextPane result;
    
    /**
     * Inicia la ventana del simulador.
     * @param title
     * @throws HeadlessException
     */
    public SimuladorVista(String title) throws HeadlessException {
        super(title);
        
        Container cont = this.getContentPane();
        cont.setLayout(new SpringLayout());
        JPanel arriba = new JPanel(new BorderLayout());
        this.centro = new JPanel(new SpringLayout());
        
        //Titulos y crear ejercitos
        String[] tropasLibres = {"Hombre", "Elfo", "ElfoNoldor", "Enano"};
        String[] tropasOscuras = {"Orco", "OrcoUrukhai", "Huargo"};
        ejL = new EjercitoVista("Ejército Pueblos Libres", tropasLibres);        
        ejO = new EjercitoVista("Ejército Oscuro", tropasOscuras);

        
        //Obtenemos la imagen de la batalla
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("../batalla5ejercitos/Batalla_de_los_Cinco_Ejercitos.jpg")); 
        } catch (IOException ex) {
            Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: no se encuentra la imagen con el fondo.");
            return;
        }
        picLabel = new JLabel(new ImageIcon( myPicture.getScaledInstance(400, 273, 0) ));
        picLabel.setPreferredSize(new Dimension(400, 250));
        picLabel.setMaximumSize(new Dimension(400, 250));
        centro.add(picLabel);
        
        
        //Metemos el texto en el centro
        this.result = new JTextPane();
        JScrollPane scroll = new JScrollPane(this.result);
        centro.add(scroll);
        SpringUtilities.makeCompactGrid(centro, 2, 1, 7, 7, 7, 7);
        
        //Colocamos las 3 col. ppal.
        arriba.add(ejL, BorderLayout.WEST);
        arriba.add(centro, BorderLayout.CENTER);
        arriba.add(ejO, BorderLayout.EAST);
        arriba.setVisible(true);
        
        //Colocamos el boton de inicio
        JPanel abajo = new JPanel(new FlowLayout());
        comienzo = new JButton("Comenzar simulación");
        abajo.add(comienzo);
        abajo.setVisible(true);
        
        //Metemos todo y ajustamos dimensiones
        cont.add(arriba);
        cont.add(abajo);
        SpringUtilities.makeCompactGrid(cont, 2, 1, 7, 7, 7, 7);
        this.setPreferredSize(new Dimension(890, 520));
        this.setMinimumSize(new Dimension(890, 520));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.pack();
    }
    

    /**
     *
     * @return ej&eacute;rcito libre
     */
    public EjercitoVista getEjL() {
        return ejL;
    }

    /**
     *
     * @param ejL
     */
    public void setEjL(EjercitoVista ejL) {
        this.ejL = ejL;
    }

    /**
     *
     * @return ej&eacute;rcito oscuro
     */
    public EjercitoVista getEjO() {
        return ejO;
    }

    /**
     *
     * @param ejO
     */
    public void setEjO(EjercitoVista ejO) {
        this.ejO = ejO;
    }

    /**
     *
     * @return imagen
     */
    public JLabel getPicLabel() {
        return picLabel;
    }

    /**
     *
     * @param picLabel
     */
    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }
    
    /**
     *
     * @param c
     */
    public void setControlador(ActionListener c) {
        comienzo.addActionListener(c);
    }

    /**
     *
     * @return panel de texto con los resultados
     */
    public JTextPane getResult() {
        return result;
    }
    
    /**
     * Imprime un buffer con un color.
     * @param cadena
     * @param color
     */
    public void imprimirBuff(String cadena, Color color) {
        StyleContext context = new StyleContext();

        Style style = this.result.addStyle("MyColor", null);
        StyleConstants.setFontSize(style, 9);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);
        StyleConstants.setForeground(style, color);
        
        StyledDocument document = this.result.getStyledDocument();
        try {
            this.result.getDocument().insertString(document.getLength(), cadena, this.result.getStyle("MyColor"));
        } catch (BadLocationException ex) {
            Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Imprime un array de buffers alternando el color de cada uno entre gris y azul.
     * @param cadenas
     */
    public void imprimirBuff(List<String> cadenas){
        
        StyleContext context = new StyleContext();

        //Definimos el estilo para el gris
        Style style = this.result.addStyle("Grey", null);
        StyleConstants.setFontSize(style, 9);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);
        StyleConstants.setForeground(style, Color.darkGray);
        
        //Definimos el estilo para el azul
        style = this.result.addStyle("Blue", null);
        StyleConstants.setFontSize(style, 9);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);
        StyleConstants.setForeground(style, Color.BLUE);

        StyledDocument document = this.result.getStyledDocument();

        //Imprimimos todas las cadenas alternando colores
        for(int i = 0; i < cadenas.size(); i++) {
            String texto;
            
            if(i % 2 == 0) {
                try {
                    texto = cadenas.get(i);
                    this.result.getDocument().insertString(document.getLength(), texto, this.result.getStyle("Grey"));
                } catch (BadLocationException ex) {
                    Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
            try {
                    texto = cadenas.get(i);
                    this.result.getDocument().insertString(document.getLength(), texto, this.result.getStyle("Blue"));
                } catch (BadLocationException ex) {
                    Logger.getLogger(SimuladorVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
