/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import historial.Historial;
import myException.OpIncorrectaException;
import myException.EjecucionExcepcion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myException.OpcionInexistenteException;

/**
 * Esta clase crea un Menu de Consola que almacena varias Opciones y se encarga
 * de gestionar y modificar un Proyecto PERT segun las opciones seleccionadas
 * por el usuario. Ademas, lleva un historial del Proyecto, permitiendo deshacer
 * y rehacer distintas acciones.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class MenuConsola implements Ejecutable {

    private String nombre;
    private List<MenuItem> items;
    private List<MenuItem> specialItems;
    private boolean fin;
    private Historial hist;

    /**
     * Constructor de la clase MenuConsola
     *
     * @param nombre
     */
    public MenuConsola(String nombre) {
        this.fin = false;
        this.nombre = nombre;
        this.items = new ArrayList<MenuItem>();

        this.specialItems = new ArrayList<MenuItem>();
        this.specialItems.add(new OpAyuda());
        this.specialItems.add(new OpDeshacer());
        this.specialItems.add(new OpRehacer());
        this.specialItems.add(new OpSalir());

        this.hist = new Historial();
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
     *
     * @return items
     */
    public List<MenuItem> getItems() {
        return items;
    }

    /**
     *
     * @param items
     */
    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    /**
     *
     * @return items
     */
    public List<MenuItem> getSpecialItems() {
        return specialItems;
    }

    /**
     *
     * @param specialItems
     */
    public void setSpecialItems(List<MenuItem> specialItems) {
        this.specialItems = specialItems;
    }

    /**
     * Determina si ya ha terminado el programa.
     *
     * @return fin
     */
    public boolean isFin() {
        return fin;
    }

    /**
     *
     * @param fin
     */
    public void setFin(boolean fin) {
        this.fin = fin;
    }

    /**
     *
     * @return hist - Historial
     */
    public Historial getHist() {
        return hist;
    }

    /**
     *
     * @param hist
     */
    public void setHist(Historial hist) {
        this.hist = hist;
    }

    /**
     * Muestra por pantalla las opciones de menu (tanto normales/items, como las
     * especiales/specialItems), teniendo en cuenta si están activas o no.
     */
    public void showOpciones() {
        int i = 1;

        for (MenuItem it : this.items) {
            if (it.isActiva()) {
                System.out.println(i + ".- " + it.getNombre());
            } else {
                System.out.println("[" + it.getNombre() + "]");
            }
            i++;
        }

        for (int j = 0; j < this.nombre.length(); ++j) {
            System.out.print("-");
        }
        System.out.print("\n");

        for (MenuItem it : this.specialItems) {
            if (it.isActiva()) {
                System.out.println(it.getNombre().toLowerCase().charAt(0) + ".- " + it.getNombre());
            } else {
                System.out.println("[" + it.getNombre() + "]");
            }
        }
    }

    /**
     * Ordena las opciones de menu (tanto items como specialItems). Hemos
     * decidido dividir los MenuItems en dos Listas distintas dependiendo de su
     * importancia: los items serán las opciones de menú relacionadas con los
     * Proyectos PERT, mientras que los specialItems serán las opciones de menú
     * generales (Ayuda, Deshacer, Rehacer y Salir).
     */
    public void sortOpciones() {
        Collections.sort(this.items);
        Collections.sort(this.specialItems);
    }

    /**
     *
     * @param opcion
     */
    public void addOpcion(MenuItem opcion) {
        items.add(opcion);
        this.sortOpciones();
    }

    /**
     * Muestra una pequeña cabecera a modo de título de la aplicación.
     */
    private void mostrarCabecera() {
        System.out.println("\n");
        for (int i = 0; i < this.nombre.length() + 6; ++i) {
            System.out.print("*");
        }
        System.out.println("\n** " + this.nombre + " **");
        for (int i = 0; i < this.nombre.length() + 6; ++i) {
            System.out.print("*");
        }
        System.out.println("\n");
    }

    /**
     * Este es uno de los métodos más importantes y complejos - Se encarga de
     * recibir la acción seleccionada por el usuario y procesarla, ejecutando el
     * MenuItem correspondiente. Además, también lleva a cabo diversas
     * operaciones tales como rellenar el historial a medida que se van
     * realizando acciones o activar/desactivar las opciones de menú
     * correspondientes porque hayamos rehecho/deshecho alguna acción.
     *
     * @param linea - String (opción elegida por el usuario)
     * @param o - Object(Proyecto)
     * @return retorno - Object(Proyecto)
     */
    private Object procesarOpcion(String linea, Object o) {
        Integer opcion;
        Object retorno = o;
        Object ret = null;
        MenuItem item = null;

        try {
            opcion = Integer.parseInt(linea);

            // Si la opcion no esta
            if ((opcion > this.items.size()) || opcion < 1) {
                throw new OpcionInexistenteException();
            }
            item = this.items.get(opcion - 1);

            retorno = item.ejecutar(o);
            
            // Si ha habido un error no controlado
            if(retorno == null) {retorno = o;}
            else {
                item.activarSiguientes(this);
            }
            
            if (item.isUndoRedoable()) {
                this.getHist().save(opcion, retorno);

            } else if (item.getNombre().equals("Cargar Proyecto") || item.getNombre().equals("Crear proyecto")) {
                //Reseteamos el historial y guardamos el Proyecto recien creado/cargado
                this.getHist().getVersiones().clear();
                this.getHist().setCurrentOption(-1);
                this.getHist().save(opcion, retorno);

                //Desactivamos todas las opciones de Menu que no estan disponibles desde el principio
                for (MenuItem opcionMenu : this.getItems()) {
                    String name = opcionMenu.getNombre();
                    if (name.equals("Cargar Proyecto") == false
                            && name.equals("Crear proyecto") == false) {
                        opcionMenu.setActiva(false);
                    }
                }
                //Activamos la/s opcion/es correspondientes a la accion realizada
                item.activarSiguientes(this);

            }

            // La opcion es especial
        } catch (NumberFormatException ex) {

            char op = linea.toLowerCase().charAt(0);
            int opcionAnterior = -1;

            try {

                if (op == 'a') {    //Ejecutamos 'Ayuda'
                    Object trash; // No vamos a usar el retorno
                    trash = this.specialItems.get(0).ejecutar(this);

                } else if (op == 'd') {   //Ejecutamos 'Deshacer'
                    opcionAnterior = this.getHist().opcionVersionActual();
                    ret = this.specialItems.get(1).ejecutar(this.getHist());
                    if (ret != null) {
                        retorno = ret;
                        if (this.getHist().esUnica(opcionAnterior)) {
                            desactivarOpcion(opcionAnterior - 1);
                        }
                        desactivarOpcion(5);    //Desactivamos mostrar Tabla por defecto al deshacer.
                    }

                } else if (op == 'r') {   //Ejecutamos 'Rehacer'
                    ret = this.specialItems.get(2).ejecutar(this.getHist());
                    if (ret != null) {
                        retorno = ret;
                        opcionAnterior = this.getHist().opcionVersionActual();
                        this.getItems().get(opcionAnterior - 1).activarSiguientes(this);
                    }

                } else if (op == 's') {   //Ejecutamos 'Salir'
                    retorno = this.specialItems.get(3).ejecutar(o);
                    this.fin = true;

                } else {
                    throw new OpcionInexistenteException();
                }
            } catch (OpIncorrectaException ex1) {
                System.out.println(ex1);
            } catch (EjecucionExcepcion ex1) {
                System.out.println(ex1);
            } finally {
                return retorno;
            }

        } catch (OpIncorrectaException ex) {
            System.out.println(ex);
        } catch (EjecucionExcepcion ex) {
            System.out.println(ex);
        } 
        finally {
            return retorno;
        }
    }

    /**
     * Muestra el menú y solicita al usuario que seleccione las acciones que
     * quiera realizar hasta que éste elija salir de la aplización.
     *
     * @param o - Object
     * @return o - Object(unused)
     */
    @Override
    public Object ejecutar(Object o) {
        String linea = null;

        Scanner scan = new Scanner(System.in);

        // Ejecutamos hasta que se salga.
        while (this.fin == false) {

            this.mostrarCabecera();
            this.sortOpciones();
            this.showOpciones();

            linea = scan.nextLine();

            o = this.procesarOpcion(linea, o);
        }

        return o;
    }

    /**
     * Recibe un entero con la opción de menú ejecutada y, dependiendo de cuál
     * sea, desactiva los MenuItem correspondientes. Se llama este método al
     * deshacer alguna acción. Por defecto, siempre que se deshaga una acción,
     * desactivaremos la opción de menú "Mostrar Tabla".
     *
     * @param opc - int
     */
    public void desactivarOpcion(int opc) {
        if (items.get(opc).getNombre().equals("Añadir Tarea")) {
            for (MenuItem it : items) {
                if (it.getNombre().equals("Añadir Enlace")) {
                    it.setActiva(false);
                    return;
                }
            }
        } else if (items.get(opc).getNombre().equals("Añadir Enlace")) {
            for (MenuItem it : items) {
                if (it.getNombre().equals("Calcular Tiempos") || it.getNombre().equals("Mostrar Tabla")) {
                    it.setActiva(false);
                }
            }
        } else if (items.get(opc).getNombre().equals("Mostrar Tabla")) {
            items.get(opc).setActiva(false);
        }

    }
}
