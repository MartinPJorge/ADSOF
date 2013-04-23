/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uam.eps.adsof.batalla5ejercitos.ejercitos;

import es.uam.eps.adsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.eps.adsof.batalla5ejercitos.criaturas.CriaturaOscura;
import es.uam.eps.adsof.batalla5ejercitos.factorias.CriaturaFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.HuargoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.OrcoFactoria;
import es.uam.eps.adsof.batalla5ejercitos.factorias.OrcoUrukhaiFactoria;
import es.uam.eps.adsof.batalla5ejercitos.myException.EmptyArmyExc;
import es.uam.eps.adsof.batalla5ejercitos.myException.IncompatibleTypesExc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Esta clase representa el bando del Ejército Oscuro en la Batalla de los 5
 * Ejércitos. Estará formado exclusivamente por criaturas que sean instancias de 
 * CriaturaOscura.
 *
 * @author Iv&aacute;n M&aacute;rquez Pardo
 * @author Jorge Mart&iacute;n P&eacute;rez
 * @version 1.0
 */
public class EjercitoOscuro extends Ejercito {

    /**
     * Constuctor de la clase Ejercito.
     *
     * @param tropasDescr
     * @throws IncompatibleTypesExc
     * @throws EmptyArmyExc
     */
    public EjercitoOscuro(HashMap<CriaturaFactoria, ArrayList<Integer>> tropasDescr) throws IncompatibleTypesExc, EmptyArmyExc {
        super(tropasDescr);
    }

    /**
     * Comprueba si entre las especies creadas por cada una de las
     * factor&iacute;as se encuentra alguna que no coincida con el bando del
     * resto.
     *
     * @param factorias
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
            if (!(c instanceof CriaturaOscura)) {
                throw new IncompatibleTypesExc();
            }
        }
    }

    /**
     * Solicita al usuario que introduzca por teclado los datos necesarios para
     * generar un HashMap con información sobre un Ejército Oscuro, que a
     * continuación creará y devolverá en el retorno.
     *
     * @return Ejercito creado.
     */
    public static EjercitoOscuro crearEjercitoOscuro() {
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

                System.out.println("Introduzca el número de unidades de la raza " + criatOsc[opcion] + ":");
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
        EjercitoOscuro e;
        try {
            e = new EjercitoOscuro(descTropas);
        } catch (IncompatibleTypesExc | EmptyArmyExc ex) {
            System.out.println("Vuelva a intentar crear el Ejército Oscuro correctamente.\n");
            return crearEjercitoOscuro();
        }
        System.out.println("El Ejército Oscuro ha sido creado correctamente.\n");
        return e;
    }
}
