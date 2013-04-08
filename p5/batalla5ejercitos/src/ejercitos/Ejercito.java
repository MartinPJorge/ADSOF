/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercitos;

import factorias.CriaturaFactoria;
import factorias.OrcoFactoria;
import factorias.HombreFactoria;
import factorias.EnanoFactoria;
import factorias.HuargoFactoria;
import factorias.ElfoFactoria;
import batalla5ejercitos.Batalla;
import criaturas.*;
import factorias.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import myException.EmptyArmyExc;
import myException.IncompatibleTypesExc;

/**
 * Esta clase representa cada uno de los dos ejércitos de la Batalla de los 5
 * Ejércitos. Un ejército está conformado por varias tropas.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class Ejercito {

    private ArrayList<Tropa> tropas;

    /**
     * Constuctor de la clase Ejercito.
     *
     * @param tropasDescr
     * @throws IncompatibleTypesExc
     * @throws EmptyArmyExc
     */
    public Ejercito(HashMap<CriaturaFactoria, ArrayList<Integer>> tropasDescr) throws IncompatibleTypesExc, EmptyArmyExc {
        if (tropasDescr.isEmpty()) {
            throw new EmptyArmyExc();
        }

        tropas = new ArrayList<Tropa>();
        Set<CriaturaFactoria> factorias = tropasDescr.keySet();
        CriaturaFactoria[] cFacts = (CriaturaFactoria[]) factorias.toArray(new CriaturaFactoria[factorias.size()]);
        if (tropasNoCompatibles(cFacts)) {
            throw new IncompatibleTypesExc();
        }

        //Recorremos las factorias
        for (CriaturaFactoria f : factorias) {
            ArrayList<Integer> unidades = tropasDescr.get(f);

            //Creamos una tropa de la factoria con 'u' unidades.
            for (int u : unidades) {
                tropas.add(new Tropa(f, u));
            }
        }
    }

    /**
     * Comprueba si entre las especies creadas por cada una de las
     * factor&iacute;as se encuentra alguna que no coincida con el bando del
     * resto.
     *
     * @param factorias
     * @return boolean
     */
    private boolean tropasNoCompatibles(CriaturaFactoria[] factorias) {
        ArrayList<Criatura> criaturas = new ArrayList<Criatura>();
        boolean esLibre;

        //Creamos un array con criaturas
        for (CriaturaFactoria f : factorias) {
            criaturas.add(f.crearCriatura());
        }

        //Buscamos criaturas de distintos bandos.
        esLibre = criaturas.get(0).isCriaturaLibre();
        for (Criatura c : criaturas) {
            if (c.isCriaturaLibre() != esLibre) {
                return true;
            }
        }

        return false;
    }

    /**
     * Solicita al usuario que introduzca por teclado los datos necesarios para
     * generar un HashMap con información sobre un Ejército de los Pueblos
     * Libres, que a continuación creará y devolverá en el retorno.
     *
     * @return Ejercito creado.
     */
    public static Ejercito crearEjercitoLibre() {
        HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas = new HashMap<CriaturaFactoria, ArrayList<Integer>>();
        String[] criatLib = {"Hombre", "Elfo", "ElfoNoldor", "Enano"};
        CriaturaFactoria[] facts = {new HombreFactoria(), new ElfoFactoria(), new ElfoNoldorFactoria(), new EnanoFactoria()};
        int i, opcion = 0, unidades = 0;
        String factName;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Ejército de los Pueblos Libres:");
            System.out.println("Añada Tropas al Ejército de los Pueblos Libres:");
            for (i = 0; i < criatLib.length; ++i) {
                System.out.println(i + ".-" + criatLib[i]);
            }
            System.out.println(i + ".-Terminar y crear.");
            opcion = s.nextInt();
            if (opcion == criatLib.length) {
                break;
            } else if (opcion < 0 || opcion > criatLib.length) {
                System.out.println("Opcion incorrecta.\n");
            } else {
                factName = "factorias." + criatLib[opcion] + "Factoria";
                Class f;
                try {
                    f = Class.forName(factName);
                } catch (ClassNotFoundException ex) {
                    return null;
                }
                System.out.println("Introduzca el número de unidades de la raza " + criatLib[opcion] + ":");
                unidades = s.nextInt();
                if (unidades <= 0) {
                    System.out.println("Número de unidades inválido. No se creará ninguna tropa.\n");
                } else {
                    try {
                        CriaturaFactoria cf = (CriaturaFactoria) f.newInstance();
                        for (int j = 0; j < facts.length; ++j) {
                            if (cf.getClass().equals(facts[j].getClass())) {
                                cf = facts[j];
                                break;
                            }
                        }
                        ArrayList<Integer> units = descTropas.get(cf);
                        if (units == null) {
                            units = new ArrayList<Integer>();
                        }
                        units.add(unidades);

                        descTropas.put(cf, units);
                        System.out.println("Tropa añadida correctamente al Ejército.\n");
                    } catch (InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(Ejercito.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        Ejercito e;
        try {
            e = new Ejercito(descTropas);
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            System.out.println("Vuelva a intentar crear el Ejército Libre correctamente.\n");
            return crearEjercitoLibre();
        }
        System.out.println("El Ejército de los Pueblos Libres ha sido creado correctamente.\n");
        return e;

    }

    /**
     * Solicita al usuario que introduzca por teclado los datos necesarios para
     * generar un HashMap con información sobre un Ejército Oscuro, que a
     * continuación creará y devolverá en el retorno.
     *
     * @return Ejercito creado.
     */
    public static Ejercito crearEjercitoOscuro() {
        HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas = new HashMap<CriaturaFactoria, ArrayList<Integer>>();
        String[] criatOsc = {"Orco", "OrcoUrukhai", "Huargo"};
        CriaturaFactoria[] facts = {new OrcoFactoria(), new OrcoUrukhaiFactoria(), new HuargoFactoria()};
        int i, opcion = 0, unidades = 0;
        String factName;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Ejército Oscuro:");
            System.out.println("Añada Tropas al Ejército Oscuro:");
            for (i = 0; i < criatOsc.length; ++i) {
                System.out.println(i + ".-" + criatOsc[i]);
            }
            System.out.println(i + ".-Terminar y crear.");
            opcion = s.nextInt();
            if (opcion == criatOsc.length) {
                break;
            } else if (opcion < 0 || opcion > criatOsc.length) {
                System.out.println("Opcion incorrecta.\n");
            } else {
                factName = "factorias." + criatOsc[opcion] + "Factoria";
                Class f;
                try {
                    f = Class.forName(factName);
                } catch (ClassNotFoundException ex) {
                    return null;
                }
                System.out.println("Introduzca el número de unidades de la raza " + criatOsc[opcion] + ":");
                unidades = s.nextInt();
                if (unidades <= 0) {
                    System.out.println("Número de unidades inválido. No se creará ninguna tropa.\n");
                } else {
                    try {
                        CriaturaFactoria cf = (CriaturaFactoria) f.newInstance();
                        for (int j = 0; j < facts.length; ++j) {
                            if (cf.getClass().equals(facts[j].getClass())) {
                                cf = facts[j];
                                break;
                            }
                        }
                        ArrayList<Integer> units = descTropas.get(cf);
                        if (units == null) {
                            units = new ArrayList<Integer>();
                        }
                        units.add(unidades);

                        descTropas.put(cf, units);
                        System.out.println("Tropa añadida correctamente al Ejército.\n");
                    } catch (InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(Ejercito.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        Ejercito e;
        try {
            e = new Ejercito(descTropas);
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            System.out.println("Vuelva a intentar crear el Ejército Oscuro correctamente.\n");
            return crearEjercitoOscuro();
        }
        System.out.println("El Ejército Oscuro ha sido creado correctamente.\n");
        return e;
    }

    /**
     * Método que realiza el ataque del Ejército this al Ejército eEnem
     *
     * @param eEnem
     */
    public void atacar(Ejercito eEnem) {
        int index;
        ArrayList<Tropa> tEnems = new ArrayList<Tropa>();

        //Obtenemos tropas enemigas sin aniquilar
        for (Tropa t : eEnem.tropas) {
            if (t.estaAniquilada() == false) {
                tEnems.add(t);
            }
        }

        //Atacamos al azar con las tropas de nuestro Ejercito que sigan en pie
        for (Tropa t : this.tropas) {
            if (t.estaAniquilada() == false) {
                index = Batalla.numAleatorio(0, tEnems.size() - 1);
                t.atacar(tEnems.get(index));
            }
        }
    }

    /**
     * Aplica las heridas que han recibido todas las tropas en el último asalto.
     */
    public void aplicarHeridas() {
        for (Tropa t : this.tropas) {
            t.aplicarHeridas();
        }
    }

    /**
     * Determina si todas las tropas de un Ejercito están aniquiladas.
     *
     * @return boolean
     */
    public boolean estaAniquilado() {
        for (Tropa t : this.tropas) {
            if (t.estaAniquilada() == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * toString de la clase Ejército
     *
     * @return String
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.tropas.size(); ++i) {
            if (this.tropas.get(i).estaAniquilada() == false) {
                s += "Tropa " + (i + 1) + ":" + this.tropas.get(i).toString();
            }
        }
        return "{\n" + s + "}";
    }
}
