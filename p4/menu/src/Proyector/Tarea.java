/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyector;

import java.util.ArrayList;

/**
 *
 * En esta clase se almacena la informaci&oacute;n sobre una tarea del proyecto (duraciones, 
 * duraci&oacute;n estimada, nombre, tareas anteriores y siguientes,
 * y comienzo y final optimista y pesimista).
 * 
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 */
public class Tarea {
    
    private int dO;
    private int dM;
    private int dP;
    private double cO;
    private double fO;
    private double cP;
    private double fP;
    private double duracEstimada;
    private String nombre;
    private int nivel;
    private ArrayList<Tarea> anteriores;
    private ArrayList<Tarea> siguientes; 
    
    
    /**
     * Crea una tarea con el nombre y las duraciones pasados por argumento.
     * @param dO duracion optimista
     * @param dM duracion mas probable
     * @param dP duracion pesimista
     * @param nombre Nombre de la tarea
     */
    public Tarea(int dO, int dM, int dP, String nombre) {
        this.dO = dO;
        this.dM = dM;
        this.dP = dP;
        this.cO = -1;
        this.fO = -1;
        this.duracEstimada = -1;
        this.nivel = -1;
        this.nombre = nombre;
        
        this.anteriores = new ArrayList<Tarea>();
        this.siguientes = new ArrayList<Tarea>();
    }
    
    /**
     * 
     * @return duraci&oacute;n optimista (dO).
     */
    public int getdO(){
        return this.dO;
    }
    
    /**
     * 
     * @return duraci&oacute;n m&aacute;s probable (dM).
     */
    public int getdM(){
        return this.dM;
    }
    
    /**
     * 
     * @return duraci&oacute;n m&aacute;s probable (dM).
     */
    public int getdP(){
        return this.dP;
    }
    
    /**
     * 
     * @return comienzo optimista (cO).
     */
    public double getCO() {
        return this.cO;
    }
    
    /**
     * 
     * @return final optimista (fO).
     */
    public double getFO() {
        return this.fO;
    }

    /**
     * 
     * @return comienzo pesimista (cP).
     */
    public double getCP() {
        return cP;
    }

    /**
     * 
     * @return final pesimista (fP).
     */
    public double getFP() {
        return fP;
    }
    
    /**
     * 
     * @return nombre de la tarea.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * 
     * @return ArrayList con las tareas anteriores.
     */
    public ArrayList<Tarea> getAnteriores() {
        return this.anteriores;
    } 
    
    /**
     * 
     * @return ArrayList con las tareas consecuentes.
     */
    public ArrayList<Tarea> getSiguientes() {
        return this.siguientes;
    }

    /**
     * 
     * @return el nivel de la tarea dentro del proyecto
     */
    public int getNivel() {
        return nivel;
    }
    
    /**
     * 
     * @return duraci&oacute;n estimada de la tarea.
     */
    public double getDuracEstimada() {
        return duracEstimada;
    }
    
    /**
     * Iguala el comienzo optimista a 'cO'.
     * @param cO - nuevo comienzo optimista
     */
    public void setCO(double cO) {
        this.cO = cO;
    }
    
    /**
     * Iguala el final optimista a 'fO'.
     * @param fO - nuevo final optimista
     */
    public void setFO(double fO) {
        this.fO = fO;
    }

    /**
     * Iguala el comienzo pesimista a 'cP'.
     * @param cP - nuevo comienzo pesimista
     */
    public void setCP(double cP) {
        this.cP = cP;
    }

    /**
     * Iguala el final pesimista a 'fP'.
     * @param fP - nuevo final pesimista
     */
    public void setFP(double fP) {
        this.fP = fP;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
    /**
     * Iguala la duraci&oacute;n estimada a 'duracEstimada'.
     * @param duracEstimada - duraci&oacute;n estimada
     */
    public void setDuracEstimada(double duracEstimada) {
        this.duracEstimada = duracEstimada;
    }

    /**
     * Copia los campos de una Tarea a un String y lo devuelve.
     * @return String con informaci&oacute;n sobre una Tarea
     */
    @Override
    public String toString() {
        if(this.getNombre().length()<=7){
            return this.getNombre() + "\t\t" + (int)Math.ceil(this.getDuracEstimada()) + "\t" + 
                (int)Math.ceil(this.getCO()) + "\t" + (int)Math.ceil(this.getCP()) + "\t" + 
                (int)Math.ceil(this.getFO()) + "\t" + (int)Math.ceil(this.getFP()) + "\t" +
                (int)this.holgura() + "\n";
        }else{
            return this.getNombre() + "\t" + (int)Math.ceil(this.getDuracEstimada()) + "\t" + 
                (int)Math.ceil(this.getCO()) + "\t" + (int)Math.ceil(this.getCP()) + "\t" + 
                (int)Math.ceil(this.getFO()) + "\t" + (int)Math.ceil(this.getFP()) + "\t" +
                (int)this.holgura() + "\n";
        } 
    }
    
    /**
     * Alternativa al toString original con el fin de imprimir la tabla del camino 
     * cr&iacute;tico de manera m&aacute;s legible (alineada) y con mayor facilidad.
     * @return String con informaci&oacute;n sobre una Tarea critica
     */
    public String toString2() {
        if(this.getNombre().length()<=7){
            return this.getNombre()+"\t\t"+(int)Math.ceil(this.getCO())+"\t"+(int)Math.ceil(this.getDuracEstimada());
        }else{
            return this.getNombre()+ "\t"+(int)Math.ceil(this.getCO())+"\t"+(int)Math.ceil(this.getDuracEstimada());
        } 
    }
    
    /**
     * A&ntilde;ade a la tarea 'anterior' al ArrayList de tareas antecedentes.
     * @param anterior - tarea anterior
     */
    public void addAnterior(Tarea anterior) {
        this.anteriores.add(anterior);
    }
    
    /**
     * A&ntilde;ade a la tarea 'siguiente' al ArrayList de tareas consecuentes.
     * @param siguiente - tarea siguiente
     */
    public void addSiguiente(Tarea siguiente) {
        this.siguientes.add(siguiente);
    }

    /**
    * Calcula la holgura de una tarea y la devuelve.
    * @return holgura de la tarea
    */
    public double holgura(){
        return Math.ceil(this.getCP())-Math.ceil(this.getCO());
    }
    
}
