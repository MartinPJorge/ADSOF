/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.ejercitos;

import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.CriaturaLibre;
import es.uam.eps.adsof.batalla5ejercitos.factorias.CriaturaFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.ElfoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.ElfoNoldorFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.EnanoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.HombreFactoria;
import es.uam.eps.adsof.batalla5ejercitos.myException.EmptyArmyExc;
import es.uam.eps.adsof.batalla5ejercitos.myException.IncompatibleTypesExc;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e265923
 */
public class EjercitoLibre extends Ejercito {

    /**
     * Constuctor de la clase Ejercito.
     *
     * @param tropasDescr
     * @throws IncompatibleTypesExc
     * @throws EmptyArmyExc
     */
    public EjercitoLibre(HashMap<CriaturaFactoria, ArrayList<Integer>> tropasDescr) throws IncompatibleTypesExc, EmptyArmyExc {
        super(tropasDescr);
    }

    /**
     * Comprueba si entre las especies creadas por cada una de las
     * factor&iacute;as se encuentra alguna que no coincida con el bando del
     * resto.
     *
     * @param factorias
     * @return boolean
     */
    @Override
    public void tropasNoCompatibles(CriaturaFactoria[] factorias) throws IncompatibleTypesExc {
        ArrayList<Criatura> criaturas = new ArrayList<Criatura>();

        //Creamos un array con criaturas
        for (CriaturaFactoria f : factorias) {
            criaturas.add(f.crearCriatura());
        }

        //Buscamos criaturas de distintos bandos.
        for (Criatura c : criaturas) {
            if (!(c instanceof CriaturaLibre)) {
                throw new IncompatibleTypesExc();
            }
        }

    }

    /**
     * Solicita al usuario que introduzca por teclado los datos necesarios para
     * generar un HashMap con información sobre un Ejército de los Pueblos
     * Libres, que a continuación creará y devolverá en el retorno.
     *
     * @return Ejercito creado.
     */
    public static EjercitoLibre crearEjercitoLibre() {
        HashMap<CriaturaFactoria, ArrayList<Integer>> descTropas = new HashMap<CriaturaFactoria, ArrayList<Integer>>();
        String[] criatLib = {"Hombre", "Elfo", "ElfoNoldor", "Enano"};
        CriaturaFactoria[] facts = {new HombreFactoria(), new ElfoFactoria(), new ElfoNoldorFactoria(), new EnanoFactoria()};
        int i, opcion = 0, unidades = 0;

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

                System.out.println("Introduzca el número de unidades de la raza " + criatLib[opcion] + ":");
                unidades = s.nextInt();
                if (unidades <= 0) {
                    System.out.println("Número de unidades inválido. No se creará ninguna tropa.\n");
                } else {

                    CriaturaFactoria cf = facts[opcion];

                    ArrayList<Integer> units = descTropas.get(cf);
                    if (units == null) {
                        units = new ArrayList<Integer>();
                    }
                    units.add(unidades);

                    descTropas.put(cf, units);
                    System.out.println("Tropa añadida correctamente al Ejército.\n");

                }
            }
        }
        EjercitoLibre e;
        try {
            e = new EjercitoLibre(descTropas);
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            System.out.println("Vuelva a intentar crear el Ejército Libre correctamente.\n");
            return crearEjercitoLibre();
        }
        System.out.println("El Ejército de los Pueblos Libres ha sido creado correctamente.\n");
        return e;

    }
}
