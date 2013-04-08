/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package criaturas;

/**
 * Esta interfaz será implementada por las clases de Factoria asociadas a cada
 * una de las razas. Permite crear instancias de la clase y de las subclases que
 * implementen esta interfaz.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public interface CriaturaFactoria {

    /**
     * Crea una instancia de la clase (o de las subclases) asociadas a la
     * Factoría y devuelve la nueva Criatura.
     *
     * @return Criatura creada.
     */
    public Criatura crearCriatura();
}
