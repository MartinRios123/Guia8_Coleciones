/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.
 */
package guia_colecciones_eje02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Guia_Colecciones_Eje02 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<String> razas = new ArrayList<>();

        int cantidad;
        cantidad = 0;
        String opcion;
        String raz;
        String razaEliminar;
        boolean bandera;

        do {
            do {
                System.out.println("Cuantas razas de perro desea ingresar?");
                cantidad = leer.nextInt();
            } while (cantidad <= 0);

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Ingrese una raza de perro: ");
                raz = leer.next();
                razas.add(raz);
            }
            do {
                System.out.println("Desea ingresar más razas: S/N ");
                opcion = leer.next().toUpperCase();
                if (!opcion.equals("S") && !opcion.equals("N")) {
                    System.out.println("ERROR.");
                }
            } while (!opcion.equals("S") && !opcion.equals("N"));
        } while (!opcion.equals("N"));

        
        System.out.println("-------Visualización de las razas que ingresó-------");
        for (String raza : razas) {
            System.out.println(raza);
        }
        
        bandera = false;
        Iterator<String> iterator = razas.iterator();
        System.out.println("Ingrese una raza de perro a eliminar: ");
        razaEliminar = leer.next();
        while(iterator.hasNext()){
            String comparaRaza = iterator.next();
            if (comparaRaza.equals(razaEliminar)) {
                iterator.remove();
                bandera = true;
            }   
        }
        if (bandera == false) {
            System.out.println("No se encontro la raza ingresada");
            System.out.println("");
        }
  
        Collections.sort(razas);
        System.out.println("-------Visualización de las razas ordenadas de forma alfabética-------");
        for (String raza : razas) {
            System.out.println(raza);
        }
    }
}

