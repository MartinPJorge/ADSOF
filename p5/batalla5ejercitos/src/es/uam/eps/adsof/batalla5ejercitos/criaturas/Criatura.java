/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.criaturas;

import es.uam.eps.adsof.batalla5ejercitos.batalla5ejercitos.Batalla;

/**
 * Sobre esta clase abstracta se basan todas las demás clases asociadas a las
 * distintas razas de la Batalla de los 5 Ejércitos.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public abstract class Criatura {

    private int ptosVida;
    private int ataque;
    private int defensa;
    protected int heridas;

    /**
     * Constructor de la clase abstracta Criatura.
     *
     * @param ptosVida
     * @param ataque
     * @param defensa
     * @param heridas
     */
    public Criatura(int ptosVida, int ataque, int defensa, int heridas) {
        this.ptosVida = ptosVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.heridas = heridas;
    }

    /**
     *
     * @return ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     *
     * @param ataque
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     *
     * @return defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     *
     * @param defensa
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     *
     * @return heridas
     */
    public int getHeridas() {
        return heridas;
    }

    /**
     *
     * @param heridas
     */
    public void setHeridas(int heridas) {
        this.heridas = heridas;
    }

    /**
     *
     * @return puntos de vida
     */
    public int getPtosVida() {
        return ptosVida;
    }

    /**
     *
     * @param ptosVida
     */
    public void setPtosVida(int ptosVida) {
        this.ptosVida = ptosVida;
    }

    /**
     * Dice si una criatura est&aacute; muerta o no.
     *
     * @return boolean
     */
    public boolean estaMuerto() {
        return (this.ptosVida == 0);
    }

    /**
     * Causa (o no) una herida en el 'oponente'.
     *
     * @param oponente
     */
    public void atacar(Criatura oponente) {
        int dadoAtaque = Batalla.numAleatorio(1, 6);
        int dadoDefensa = Batalla.numAleatorio(1, 6);

        if (dadoAtaque + this.getAtaque() > dadoDefensa + oponente.getDefensa()) {
            oponente.addHeridas(1);
        }
    }

    /**
     * Incrementa en 'numeroHeridas' las heridas de la criatura.
     *
     * @param numeroHeridas
     */
    public void addHeridas(int numeroHeridas) {
        this.heridas += numeroHeridas;
    }

    /**
     * Aplica las heridas recibidas por la criatura en el &uacute;ltimo asalto.
     *
     * @param numeroHeridas
     */
    public void aplicarHeridas(int numeroHeridas) {
        this.ptosVida -= this.heridas;
        this.heridas = 0;
        if (this.ptosVida <= 0) {
            this.ptosVida = 0;
        }
    }

}
