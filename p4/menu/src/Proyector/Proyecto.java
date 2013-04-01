/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyector;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * En esta clase se almacena la informaci&oacute;n relativa a los pesos del 
 * proyecto, y adem&aacute;s contiene todas las tareas.
 * 
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 */
public final class Proyecto implements Cloneable{
  
    private double pesoOp;
    private double pesoProb;
    private double pesoPes;
    private HashMap<String,Tarea> tareas;
    private Tarea inicio;
    private Tarea fin;
    
    /**
     * Constructor de la clase Proyecto.
     */
    public Proyecto() {
        tareas = new HashMap<String,Tarea>();
        
        
        // Creamos las tareas de inicio y fin.
        inicio = new Tarea(0, 0, 0, "Inicio");
        inicio.setCO(0.0);
        inicio.setFO(0.0);
        this.duracionTarea(inicio);

        fin = new Tarea(0, 0, 0, "Fin");
        this.duracionTarea(fin);

        tareas.put(inicio.getNombre(), inicio);
        tareas.put(fin.getNombre(), fin);
    }
    
    /**
     * 
     * @param pO
     * @param pM
     * @param pP
     */
    public Proyecto(double pO, double pM, double pP) {
        this();
        
        this.setPesoOp(pO);
        this.setPesoProb(pM);
        this.setPesoPes(pP);
    }
    
    /**
     * Para instanciar el proyecto, este ha de recibir el nombre del fichero 
     * .pert para poder crear todas las tareas.
     * @param fichero - nombre del fichero
     * @throws IOException 
     */
    public Proyecto(String fichero) throws IOException {
        
        this();
        
        this.readPERT(fichero);
        asignarNivelesTras(this.inicio, 0);
    }

    /**
     * 
     * @return peso optimista del proyecto
     */
    public double getPesoOp() {
        return pesoOp;
    }

    /**
     * 
     * @return peso probable del proyecto
     */
    public double getPesoProb() {
        return pesoProb;
    }

    /**
     * 
     * @return peso pesimista del proyecto
     */
    public double getPesoPes() {
        return pesoPes;
    }

    /**
     * 
     * @return tarea de inicio del proyecto
     */
    public Tarea getInicio() {
        return inicio;
    }

    /**
     * 
     * @return tarea final del proyecto
     */
    public Tarea getFin() {
        return fin;
    }
     
    /**
     * 
     * @return tabla hash de las tareas
     */
    public HashMap<String,Tarea> getTareas() {
        return this.tareas;
    }

    /**
     * Asigna el peso optimista del proyecto.
     * 
     * @param pesoOp 
     */
    public void setPesoOp(double pesoOp) {
        this.pesoOp = pesoOp;
    }

    /**
     * Asigna el peso probable del proyecto.
     * 
     * @param pesoProb 
     */
    public void setPesoProb(double pesoProb) {
        this.pesoProb = pesoProb;
    }

    /**
     * Asigna el peso pesimista del proyecto.
     * 
     * @param pesoPes 
     */
    public void setPesoPes(double pesoPes) {
        this.pesoPes = pesoPes;
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
        
        if(tarea.getNombre().equals("Inicio")) {tarea.setDuracEstimada(0.0); return;}
        if(tarea.getNombre().equals("Fin")) {tarea.setDuracEstimada(0.0); return;}
        
        duracEstimada = (this.getPesoOp()*dO + this.getPesoProb()*dM + this.getPesoPes()*dP) / 
                (this.getPesoOp() + this.getPesoProb() + this.getPesoPes());
        
        tarea.setDuracEstimada(duracEstimada);
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
            
            
            //Se leerá un comentario
            if(nextToken.equals("#")) {
                continue;
            }
            //Se leerán los pesos del proyecto
            else if(nextToken.equals("P")) {
               
                this.setPesoOp(Double.parseDouble(tokens.nextToken()));
                this.setPesoProb(Double.parseDouble(tokens.nextToken()));
                this.setPesoPes(Double.parseDouble(tokens.nextToken()));

            }
            //Se leerá una tarea
            else if(nextToken.equals("T")) {
                String nombre = tokens.nextToken();
                int dO = Integer.parseInt(tokens.nextToken());
                int dM = Integer.parseInt(tokens.nextToken());
                int dP = Integer.parseInt(tokens.nextToken());
                
                Tarea tLeida = new Tarea(dO, dM, dP, nombre);
                this.addTarea(tLeida);
            }
            //Se leerá una conexión entre tareas
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
            //Se leerá una línea sin informacion relevante. La saltamos
            else{continue;}
            
        }
    }
    
    
    /**
     * Realiza el c&aacute;lculo del final optimista (fO) y del comienzo optimista 
     * (cO) de la 'tarea'.</br>
     * <br/><u>Nota</u>:</br>
     * Para llamar al m&eacute;todo no es necesario haber especificado antes a 
     * cada tarea cu&aacute;l es su duraci&oacute;n estimada.
     * @param tarea - tarea
     * @return final optimista (fO) de 'tarea'
     */
    public double calculoOptimista(Tarea tarea) {
        double max = 0.0;
        
        if(tarea.getNombre().equals("Inicio")){
            return this.getInicio().getFO();
        }
        
        // Buscamos el mayor CO
        ArrayList<Tarea> anteriores = tarea.getAnteriores();
        for(Tarea ant:anteriores){
            if(ant.getDuracEstimada() == -1) {
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
        tarea.setFO(max + Math.ceil(tarea.getDuracEstimada()));
        return tarea.getFO();
    }
    
    /**
     * Realiza el c&aacute;lculo del final pesimista (fP) y del comienzo  
     * pesimista (cP) de la 'tarea'.</br>
     * <br/><u>Nota</u>:</br>
     * Es necesario haber obtenido previamente los valores optimistas de las tareas 
     * consecuentes a 'tarea'.
     * @param tarea - Tarea
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
        
        tarea.setFP(Math.ceil(min));
        tarea.setCP(Math.ceil(min) - Math.ceil(tarea.getDuracEstimada()));
        return tarea.getCP();
    }
    
    /**
     * Realiza una llamada al m&eacute;todo sobrecargado caminoCritico pasando
     * la &uacute;ltima tarea del proyecto (tarea "Fin") como argumento.
     */
    public void caminoCritico() {
        System.out.println("\nTabla Critica Ordenada\n-------------");
        System.out.println("Nombre Tarea\tcO\tDuracion Estimada");
        caminoCritico(this.fin);
    }

    /**
     * Realiza el trazado del camino critico del proyecto de manera recursiva.</br>
     * <br/><u>Nota</u>:</br>
     * Para llamar a este m&eacute;todo por primera vez, es necesario pasarle como par&aacute;metro
     * la &uacute;ltima de las Tareas del proyecto (para esto hemos creado el método hom&oacute;nimo, 
     * para pasarle el argumento necesario autom&aacute;ticamente).
     * 
     * @param t - Tarea : la ultima del proyecto.
     * @return boolean indicando si estamos en un camino critico o no.
     */
    public boolean caminoCritico(Tarea t) {
        
        //Empezaremos por la última tarea
        if (t.getNombre().equals("Fin")) {
            if (t.holgura() == 0) {

                for (Tarea ant : t.getAnteriores()) {
                    if (ant.holgura() == 0) {
                        if (caminoCritico(ant) == false) {
                            continue;
                        } else {
                            System.out.println(t.toString2());
                            return true;
                        }
                    }
                }
                System.out.println(t.toString2());
                return true;

            } else {
                System.out.println("Error!");
                return false;
            }
        }

        //Hemos llegado por recursión a la primera tarea
        if (t.getNombre().equals("Inicio")) {
            if (t.holgura()==0) {
                System.out.println(t.toString2());
                return true;
            }else{
                System.out.println("Error!");
                return false;
            }
        }

        //Casos intermedios
        if (t.holgura()==0) {
            for(Tarea ant:t.getAnteriores()){
                if (ant.holgura()==0) {
                    if(caminoCritico(ant)==false){
                        continue;
                    }else{   
                        System.out.println(t.toString2());
                        return true;
                    }
                }
            }
            return false;
        }else{
            return false;
        }

    }
    
        
    /**
    * Imprime todas las tareas que forman parte del proyecto.<br/>
    * Tambi&eacute;n imprime la duraci&oacute;n estimada de todo el proyecto.
    */
    public void printProyecto(){
        
        Tarea[] arrTareas = tareas.values().toArray(new Tarea[0]);
        
        System.out.println("Tabla Resumen\n-------------");
        System.out.printf("Nombre Tarea\tDurac.\tcO\tcP\tfO\tfP\tHolgura\n");
        
        /* Vamos iterando por cada uno de los niveles. */
        for(int i = 0; i <= this.fin.getNivel(); i++) {
            for(Tarea nav : arrTareas) {
                if(nav.getNivel() == i) {
                    System.out.print(nav);
                }
            }
        }
        
        System.out.println("\n-------------");
        System.out.printf("Duracion estimada del proyecto : %d\n", (int)Math.ceil(this.fin.getFO()));
        System.out.println("-------------");
    }
    
    
    /**
     * Se encarga de asignar recursivamente a cada una de las tareas consecuentes 
     * a 't', el nivel en el que se encuentran partiendo de que a 't' se le asigna 
     * 'nivel' en caso de que su nivel previo sea menor.<br/>
     * <br/><u>Nota</u>:<br/>
     * Para obtener los niveles correspondientes a cada una de las tareas de un 
     * proyecto es necesario pasar por argumento la tarea 'Inicio' con nivel = 0.
     * @param t - tarea desde la que se comienza la asignaci&oacute;n
     * @param nivel - nivel asignado a la tarea 't'.
     */
    public void asignarNivelesTras(Tarea t, int nivel) {
        if(t.getNivel() < nivel) {
            t.setNivel(nivel);
        }
             
        ArrayList<Tarea> sig = t.getSiguientes();
        
        for(Tarea nav : sig) {
            asignarNivelesTras(nav, nivel + 1);
        }
    }
    
    /**
     * Crea una copia del Proyecto.
     * @return copia
     */
    @Override
    public Proyecto clone() {
        Proyecto copia = new Proyecto(this.pesoOp, this.pesoProb, this.pesoPes);
        Set<Entry<String, Tarea>> set1 = this.getTareas().entrySet();
        for (Entry<String, Tarea> e : set1) {
            copia.tareas.put((String)e.getKey(), (Tarea)e.getValue().clone());
        }
        return copia;
    }
    
}

