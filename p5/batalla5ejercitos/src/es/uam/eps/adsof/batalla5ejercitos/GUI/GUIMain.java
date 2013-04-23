/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.GUI;

/**
 * Main principal que lanza la GUI del simulador de batalla.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class GUIMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimuladorVista sV = new SimuladorVista("Batalla de los 5 Ejércitos");
        ControlEjercito controlEL = new ControlEjercito(sV.getEjL());
        sV.getEjL().setControlador(controlEL);
        ControlEjercito controlEO = new ControlEjercito(sV.getEjO());
        sV.getEjO().setControlador(controlEO);

        ControlSimulador controlSim = new ControlSimulador(sV, controlEL, controlEO);
        sV.setControlador(controlSim);
    }
}
