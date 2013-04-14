/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos;

import es.uam.eps.adsof.batalla5ejercitos.ejercitos.Ejercito;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoLibre;
import es.uam.eps.adsof.batalla5ejercitos.ejercitos.EjercitoOscuro;
import java.util.Calendar;
import java.util.Random;

/**
 * Esta clase implementa la simulación de la Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Batalla {

    private EjercitoLibre libre;
    private EjercitoOscuro oscuro;
    private boolean finBatalla;
    private static Random r;

    /**
     * Constructor de la clase Batalla.
     */
    public Batalla() {
        Batalla.r = new Random(Calendar.getInstance().getTimeInMillis());
        oscuro = null;
        libre = null;
        finBatalla = false;
    }

    /**
     * Devuelve un n&uacute;mero aleatorio entre los valores 'a' y 'b' (ambos
     * incluidos).
     *
     * @param a - base
     * @param b - tope
     * @return el n&uacute;mero aleatorio
     */
    public static int numAleatorio(int a, int b) {
        return r.nextInt(b - a + 1) + a;
    }

    /**
     * Devuelve un double aleatorio entre 0.0 y 1.0.
     *
     * @return double aleatorio
     */
    public static double numAleatorio() {
        return r.nextDouble();
    }

    /**
     * Método principal del Simulador de Batallas. Se encarga llamar a las
     * funciones que crean Ejércitos, que realizan los ataques y que aplican los
     * daños de combate. Por último, determina quién ha sido el ganador y lo
     * muestra por pantalla
     */
    public void simularBatalla() {
        System.out.println("SIMULADOR DE BATALLA:");
        //Creacion de Ejercitos
        libre = EjercitoLibre.crearEjercitoLibre();
        oscuro = EjercitoOscuro.crearEjercitoOscuro();
        String ganador = "La batalla ha terminado. ¡El ganador ha sido el Ejército ";

        System.out.println("¡La Batalla de los 5 Ejércitos ha comenzado!");
        while (this.finBatalla == false) {
            //Visualizar estados de la Batalla
            System.out.println("\nESTADO DE LOS EJÉRCITOS:");
            System.out.println("Ejército Libre:" + this.libre + "\n");
            System.out.println("Ejército Oscuro:" + this.oscuro + "\n");

            //Realizar asalto
            this.libre.atacar(this.oscuro);
            this.oscuro.atacar(this.libre);

            //Aplicar daños
            this.libre.aplicarHeridas();
            this.oscuro.aplicarHeridas();


            if (this.libre.estaAniquilado() && this.oscuro.estaAniquilado()) {
                ganador = "Ambos bandos han caído. Esta batalla no tendrá ni vencedores"
                        + " ni vencidos.";
                this.finBatalla = true;
            } else if (this.oscuro.estaAniquilado()) {
                ganador += "de los Pueblos Libres!\nEjército de los Pueblos Libres:" + this.libre;
                this.finBatalla = true;
            } else if (this.libre.estaAniquilado()) {
                ganador += "Oscuro!\nEjército Oscuro:" + this.oscuro;
                this.finBatalla = true;
            }
        }
        System.out.println(ganador);
    }
    
    /**
     * Método principal del Simulador de Batallas. Se encarga llamar a las
     * funciones que crean Ejércitos, que realizan los ataques y que aplican los
     * daños de combate. Por último, determina quién ha sido el ganador y lo
     * muestra por pantalla
     */
    public String simularBatalla(EjercitoLibre lib, EjercitoOscuro osc) {
        System.out.println("SIMULADOR DE BATALLA:");
        //Creacion de Ejercitos
        libre = lib;
        oscuro = osc;
        String ganador = "La batalla ha terminado. ¡El ganador ha sido el Ejército ";

        System.out.println("¡La Batalla de los 5 Ejércitos ha comenzado!");
        while (this.finBatalla == false) {
            //Visualizar estados de la Batalla
            System.out.println("\nESTADO DE LOS EJÉRCITOS:");
            System.out.println("Ejército Libre:" + this.libre + "\n");
            System.out.println("Ejército Oscuro:" + this.oscuro + "\n");

            //Realizar asalto
            this.libre.atacar(this.oscuro);
            this.oscuro.atacar(this.libre);

            //Aplicar daños
            this.libre.aplicarHeridas();
            this.oscuro.aplicarHeridas();


            if (this.libre.estaAniquilado() && this.oscuro.estaAniquilado()) {
                ganador = "Ambos bandos han caído. Esta batalla no tendrá ni vencedores"
                        + " ni vencidos.";
                this.finBatalla = true;
            } else if (this.oscuro.estaAniquilado()) {
                ganador += "de los Pueblos Libres!\nEjército de los Pueblos Libres:" + this.libre;
                this.finBatalla = true;
            } else if (this.libre.estaAniquilado()) {
                ganador += "Oscuro!\nEjército Oscuro:" + this.oscuro;
                this.finBatalla = true;
            }
        }
        System.out.println(ganador);
        return ganador;
    }
}
