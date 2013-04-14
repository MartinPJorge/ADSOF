/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

import java.io.IOException;

/**
 *
 * @author Iván
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws IOException {
        JFrame jf = new JFrame("Batalla de los 5 ejércitos.");
        String[] tropasLibres = {"Humano", "Elfo", "ElfoNoldor", "Enano"};
        String[] tropasOscuras = {"Orco", "OrcoUrukhai", "Huargo"};
        jf.setSize(150, 150);
        jf.setVisible(true);
        jf.setLayout(new BorderLayout(20, 20));
        JPanel ejL = new EjercitoVista("Ejercito Libre", tropasLibres);
        JPanel ejO = new EjercitoVista("Ejercito Oscuro", tropasOscuras);
        jf.getContentPane().add(ejL, BorderLayout.WEST);
        jf.getContentPane().add(ejO, BorderLayout.EAST);
        jf.getContentPane().add(new JButton("Comenzar simulación"), BorderLayout.SOUTH);
        BufferedImage myPicture = ImageIO.read(new File("../Pruebas/src/Batalla_de_los_Cinco_Ejercitos.JPG"));
        JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
        jf.getContentPane().add( picLabel );
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
     public static void main(String[] args) {
        SimuladorVista sV = new SimuladorVista("Batalla de los 5 Ejércitos");
        ControlEjercito controlEL= new ControlEjercito(sV.getEjL());
        sV.getEjL().setControlador(controlEL);
        ControlEjercito controlEO = new ControlEjercito(sV.getEjO());
        sV.getEjO().setControlador(controlEO);
        
        ControlSimulador controlSim = new ControlSimulador(sV, controlEL, controlEO);
        sV.setControlador(controlSim);
    }
}
