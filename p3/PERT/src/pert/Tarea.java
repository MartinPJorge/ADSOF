/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pert;

import java.util.ArrayList;

/**
 *
 * @author e265832
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
    private ArrayList<Tarea> anteriores;
    private ArrayList<Tarea> siguientes; 
    
    
    /**
     * Crea una tarea con el nombre y las duraciones pasados por argumento.
     * @param dO
     * @param dM
     * @param dP
     * @param nombre 
     */
    public Tarea(int dO, int dM, int dP, String nombre) {
        this.dO = dO;
        this.dM = dM;
        this.dP = dP;
        this.cO = -1;
        this.fO = -1;
        this.duracEstimada = -1;
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
     * @return duraci&oacute;n estimada.
     */
    public double getduracEstimada() {
        return this.duracEstimada;
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
    
    /**
     * Iguala la duraci&oacute;n estimada a 'duracEstimada'.
     * @param duracEstimada - duraci&oacute;n estimada
     */
    public void setduracEstimada(double duracEstimada) {
        this.duracEstimada = duracEstimada;
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
}
