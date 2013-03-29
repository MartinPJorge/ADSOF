/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menuconsola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import opcionesPERT.OpcionInexistenteException;

/**
 *
 * @author e265923
 */
public class MenuConsola implements Ejecutable {
    private String nombre;
    private List<MenuItem> items;
    private List<MenuItem> specialItems;
    private boolean fin;
    //private List<>
    
    public MenuConsola(String nombre) {
        this.fin = false;
        this.nombre = nombre;
        this.items = new ArrayList<MenuItem>();
        this.specialItems = new ArrayList<MenuItem>();
        this.specialItems.add(new OpAyuda("Ayuda.", true, 
                "Muestra ayuda sobre una opción."));
        this.specialItems.add(new OpSalir("Salir.", true, 
                "Solicita esta opción para terminar correctamente"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public List<MenuItem> getSpecialItems() {
        return specialItems;
    }

    public void setSpecialItems(List<MenuItem> specialItems) {
        this.specialItems = specialItems;
    }
    
    


    public void showOpciones() {
        int i=1;
        
        for(MenuItem it: this.items){
            if(it.isActiva()) {
                System.out.println(i+".- "+it.getNombre());
            }
            else {
                System.out.println("["+it.getNombre()+"]");
            }
            i++;
        }
        
        for(int j=0; j<this.nombre.length(); ++j){
            System.out.print("-");
        }
        System.out.print("\n");
        
        for(MenuItem it: this.specialItems){
            if(it.isActiva()) {
                System.out.println(it.getNombre().toLowerCase().charAt(0) +".- "+it.getNombre());
            }
            else {
                System.out.println("["+it.getNombre()+"]");
            }
        }

    }

    public void sortOpciones() {
        Collections.sort(this.items);
        Collections.sort(this.specialItems);
    }
    
    public void addOpcion(MenuItem opcion) {
        items.add(opcion);
        this.sortOpciones();
    }

    
    private void mostrarCabecera() {
        for(int i = 0; i < this.nombre.length()+6; ++i){
            System.out.print("*");
        }
        System.out.println("\n** "+this.nombre+" **");
        for(int i=0; i<this.nombre.length()+6; ++i){
            System.out.print("*");
        }
        System.out.println("\n");
    }
    
    
    
    private Object procesarOpcion(String linea, Object o){
        Integer opcion;
        Object retorno = o;
        MenuItem item = null;
        
        try {
            opcion = Integer.parseInt(linea);
            
            // Si la opcion no esta
            if((opcion  > this.items.size()) || opcion < 1) {
                throw new OpcionInexistenteException();
            }
            item = this.items.get(opcion - 1);

            retorno = item.ejecutar(o);
            this.items.get(opcion - 1).activarSiguientes(this);
                            
            
        // La opcion es especial
        } catch (NumberFormatException ex) {
            
            char op = linea.toLowerCase().charAt(0);
            
            
            try {
                
                /* Ejecutamos 'Ayuda'. */
                if(op == 'a') {
                    Object trash; // No vamos a usar el retorno
                    trash = this.specialItems.get(0).ejecutar(this);
                }
            
                /* Ejecutamos 'Salir' */
                else if(op == 's') {
                    retorno = this.specialItems.get(1).ejecutar(o);
                    this.fin = true;
                }
                else {
                    throw new OpcionInexistenteException();
                }
            }
            catch(OpIncorrectaException ex1) {
                System.out.println(ex1);
            }
            catch(EjecucionExcepcion ex1) {
                 System.out.println(ex1);
            }
            finally {
                return retorno;
            }

        }
        catch(OpIncorrectaException ex) {
             System.out.println(ex);
        }
        catch(EjecucionExcepcion ex) {
             System.out.println(ex);
        }
        finally {
            return retorno;
        }
    }
    
    
    @Override
    public Object ejecutar(Object o){
        String linea = null;
        int opcion;
        Integer fin = 0;
        
        Scanner scan = new Scanner(System.in);
        
        // Ejecutamos hasta que se salga.
        while(this.fin == false) {
            
            this.mostrarCabecera();
            this.sortOpciones();
            this.showOpciones();
            
            linea = scan.nextLine();
            
            o = this.procesarOpcion(linea, o);
        }
        
        
         
        return o;
    }
}
