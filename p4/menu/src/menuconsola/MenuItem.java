/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 * La clase MenuItem almacena la informacion sobre cada una de las opciones de
 * Menu. Todas las opciones de Menu heredan de MenuItem.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public abstract class MenuItem implements Ejecutable, Comparable<MenuItem> {

    private String nombre;
    private boolean activa;
    private String ayuda;
    private boolean undoRedoable;

    /**
     * Constructor de la clase MenuItem
     *
     * @param nombre
     * @param activa
     * @param ayuda
     */
    public MenuItem(String nombre, boolean activa, String ayuda) {
        this.nombre = nombre;
        this.activa = activa;
        this.ayuda = ayuda;
        this.undoRedoable = false;
    }

    /**
     *
     * @return activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     *
     * @param activa
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     *
     * @return ayuda
     */
    public String getAyuda() {
        return ayuda;
    }

    /**
     *
     * @param ayuda
     */
    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Nos permite determinar si esta opción de Menú se puede rehacer y
     * deshacer.
     *
     * @return boolean
     */
    public boolean isUndoRedoable() {
        return undoRedoable;
    }

    /**
     *
     * @param undoRedoable
     */
    public void setUndoRedoable(boolean undoRedoable) {
        this.undoRedoable = undoRedoable;
    }

    /**
     * Imprime la ayuda por pantalla
     */
    public void showAyuda() {
        System.out.println(this.getAyuda());
    }

    /**
     * Comparador que nos permite ordenar los MenuItem por orden alfabético.
     *
     * @param item - MenuItem
     * @return int - Usado para comparar Strings lexicográficamente
     */
    @Override
    public int compareTo(MenuItem item) {
        return this.nombre.compareTo(item.getNombre());
    }

    /**
     * Método abstracto que permite activar las opciones posteriores después de
     * haber realizado la opción actual. Cada clase que implemente este método,
     * tendrá que saber qué opcion/es tiene que activar.
     *
     * @param menuConsola
     */
    public abstract void activarSiguientes(MenuConsola menuConsola);
}
