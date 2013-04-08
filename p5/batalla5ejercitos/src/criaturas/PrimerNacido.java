/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 * Esta interfaz será implementada por las clases asociadas a cada una de las
 * razas que puedan curar sus heridas (los Primeros Nacidos: elfos y orcos).
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public interface PrimerNacido {

    /**
     * Determina, de manera aleatoria, si se curará una herida de combate.
     *
     * @return true - cura la herida false - no la cura
     */
    public boolean curarHerida();
}
