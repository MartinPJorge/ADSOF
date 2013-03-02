/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pert;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * En esta clase se almacena la informaci&oacute;n relativa a los pesos del 
 * proyecto, y adem&aacute;s contiene todas las tareas.
 * 
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 */
public final class Proyecto {
  
    private double pesoOp;
    private double pesoProb;
    private double pesoPes;
    private HashMap<String,Tarea> tareas;
    private Tarea inicio;
    private Tarea fin;
    
    /**
     * Para instanciar el proyecto, este ha de recibir el nombre del fichero 
     * .pert para poder crear todas las tareas.
     * @param fichero - nombre del fichero
     * @throws IOException 
     */
    public Proyecto(String fichero) throws IOException {
        
        tareas = new HashMap<String,Tarea>();
       
        // Creamos las tareas de inicio y fin.
        inicio = new Tarea(0, 0, 0, "Inicio");
        inicio.setCO(0.0);
        inicio.setFO(0.0);
        fin = new Tarea(0, 0, 0, "Fin");
        tareas.put(inicio.getNombre(), inicio);
        tareas.put(fin.getNombre(), fin);
        
        this.readPERT(fichero);
    }
        
    /**
     * A&ntilde;ade la tarea 't' al proyecto.
     * @param t - tarea
     */
    public void addTarea(Tarea t) {
        tareas.put(t.getNombre(), t);
    }
    
    /**
     * Le especifica a 'tarea' su duraci&oacute;n estimada siguiendo la f&oacute;rmula:</br>
     * (pesoOptimista * dO + pesoMasProbable *dM + pesoPesimista * dP) / (pesoOptimista + pesoMasProbable + pesoPesimista)
     * @param tarea - tarea
     */
    public void duracionTarea(Tarea tarea) {
        int dO = tarea.getdO();
        int dM = tarea.getdM();
        int dP = tarea.getdP();
        double duracEstimada;
        
        if(tarea.getNombre().equals("Inicio")) {tarea.setduracEstimada(0.0);}
        
        duracEstimada = (this.pesoOp*dO + this.pesoProb*dM + this.pesoPes*dP) / 
                (this.pesoOp + this.pesoProb + this.pesoPes);
        
        tarea.setduracEstimada(duracEstimada);
    }
    
    
    /**
     * Lee el fichero .pert pasado por argumento, y genera autom&aacute;ticamente 
     * todas las tareas descritas y las conexiones existentes entre ellas.
     * @param fichero - nombre del fichero
     * @throws IOException 
     */
    public void readPERT(String fichero) throws IOException {
        BufferedReader buffer = new BufferedReader(
                                    new InputStreamReader(
                                                    new FileInputStream(fichero)));
        
        String linea;
        while((linea = buffer.readLine()) != null) {
            if(linea.isEmpty()){
                continue;
            }
            StringTokenizer tokens = new StringTokenizer(linea);
            if(tokens.hasMoreTokens() == false) {continue;} // Para lineas con solo un caracter
            String nextToken = tokens.nextToken();
            
            
            
            if(nextToken.equals("#")) {
                continue;
            }
            
            else if(nextToken.equals("P")) {
               
                this.pesoOp = Double.parseDouble(tokens.nextToken());
                this.pesoProb = Double.parseDouble(tokens.nextToken());
                this.pesoPes = Double.parseDouble(tokens.nextToken());

            }

            else if(nextToken.equals("T")) {
                String nombre = tokens.nextToken();
                int dO = Integer.parseInt(tokens.nextToken());
                int dM = Integer.parseInt(tokens.nextToken());
                int dP = Integer.parseInt(tokens.nextToken());
                
                Tarea tLeida = new Tarea(dO, dM, dP, nombre);
                this.addTarea(tLeida);
            }
            
            else if(nextToken.equals("C")) {
                String tOrigen = tokens.nextToken();
                Tarea origen = this.tareas.get(tOrigen);
                String tarNombre;
                
                while(tokens.hasMoreTokens()){
                    tarNombre = tokens.nextToken();
                    Tarea tar = this.tareas.get(tarNombre);
                    origen.addSiguiente(tar);
                    tar.addAnterior(origen);
                }
            }
            
            else{continue;}
            
        }
    }
    
    
    /**
     * Realiza el c&aacute;lculo del final optimista (fO) y del comienzo optimista 
     * (cO) de la 'tarea'.</br>
     * <u>Nota</u>:</br>
     * Para llamar al m&eacute;todo no es necesario haber especificado antes a 
     * cada tarea cu&aacute;l es su duraci&oacute;n estimada.
     * @param tarea - tarea
     * @return final optimista (fO) de 'tarea'
     */
    public double calculoOptimista(Tarea tarea) {
        double max = 0.0;
        
        if(tarea.getNombre().equals("Inicio")){
            return 0.0;
        }
        
        // Buscamos el mayor CO
        ArrayList<Tarea> anteriores = tarea.getAnteriores();
        for(Tarea ant:anteriores){
            if(ant.getduracEstimada() == -1) {
                this.duracionTarea(ant);
            }
            
            if(max < this.calculoOptimista(ant)){
                max = this.calculoOptimista(ant);
            }
        }
        
        if(tarea.getDuracEstimada() == -1) {
            this.duracionTarea(tarea);
        }
        tarea.setCO(max);
        tarea.setFO(max + tarea.getDuracEstimada());
        return tarea.getFO();
    }
    
    /**
     * Realiza el c&aacute;lculo del final pesimista (fP) y del comienzo  
     * pesimista (cP) de la 'tarea'.</br>
     * <u>Nota</u>:</br>
     * Es necesario haber obtenido previamente los valores optimistas de las tareas 
     * consecuentes a 'tarea'.
     * @param tarea - tarea
     * @return comienzo pesimista (cP) de 'tarea'.
     */
    public double calculoPesimista(Tarea tarea) {
        
        if(tarea.getNombre().equals("Fin")) {
            tarea.setFP(tarea.getFO());
            tarea.setCP(tarea.getFP());
            return tarea.getFO();
        }
        
        ArrayList<Tarea> siguientes = tarea.getSiguientes();
        double min = Double.POSITIVE_INFINITY;
        
        for(Tarea sig:siguientes) {
            if(min > this.calculoPesimista(sig)) {
                min = this.calculoPesimista(sig);
            }
        }
        
        tarea.setFP(min);
        tarea.setCP(min - tarea.getDuracEstimada());
        return tarea.getCP();
    }
    
    /**
     * 
     * @return tabla hash de las tareas
     */
    public HashMap<String,Tarea> getTareas() {
        return this.tareas;
    }
}
