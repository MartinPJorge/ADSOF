/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

/**
 * Clase de una excepcion propia, de la que heredaran todas las demas
 * Excepciones de nuestra aplicacion.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class MyException extends Exception {

    public MyException(String message) {
        System.out.println("Error: "+message);
    }

    
}
