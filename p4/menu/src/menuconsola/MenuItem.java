/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

/**
 *
 * @author e265923
 */
public abstract class MenuItem implements Ejecutable, Comparable<MenuItem> {

    private String nombre;
    private boolean activa;
    private String ayuda;

    public MenuItem(String nombre, Boolean activa, String ayuda) {
        this.nombre = nombre;
        this.activa = activa;
        this.ayuda = ayuda;
    }

    
    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }


    public String getNombre() {
        return nombre;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void showAyuda() {
        System.out.println(this.getAyuda());
    }
    
    public void mostrar() {
        System.out.println();
    }

    @Override
    public int compareTo(MenuItem item) {
        return this.nombre.compareTo(item.getNombre());
    }
    
    public abstract void activarSiguientes(MenuConsola menuConsola);
}
