/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.
 */
package guia_colecciones_eje01;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Guia_Colecciones_Eje01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<String> razas = new ArrayList<>();

        int cantidad;
        cantidad = 0;
        String opcion;
        String raz;

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
    }
}
