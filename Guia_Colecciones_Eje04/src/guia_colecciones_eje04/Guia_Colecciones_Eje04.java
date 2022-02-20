package guia_colecciones_eje04;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Guia_Colecciones_Eje04 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        int horas, minutos;
        String nombreTitulo, nombreDirector, opcion;
        LocalTime duracion;

        do {
            System.out.println("Ingrese el titulo de la pelicula: ");
            nombreTitulo = leer.next();
            System.out.println("Ingrese el director de la pelicula: ");
            nombreDirector = leer.next();
            
            do {
                System.out.println("Ingrese la hora de duracion de la pelicula (0 a 23 horas): ");
                horas = leer.nextInt();
            } while (horas <= 0 || horas > 23);
            do {
                System.out.println("Ingrese la hora de duracion de la pelicula (00 a 59 minutos): ");
                minutos = leer.nextInt();
            } while (minutos <= 00 && minutos > 59);
            
            duracion = LocalTime.of(horas, minutos);
            Pelicula peli = new Pelicula(nombreTitulo,nombreDirector,duracion);
            peliculas.add(peli);
            
            do{
                System.out.println("Desea crear otra pelicula? S/N: ");
                opcion = leer.next().toUpperCase();
            }while(!opcion.equals("N") && !opcion.equals("S"));
        }while(!opcion.equals("N"));
        
        System.out.println("LAS PELICULAS SON: ");
        for (Pelicula pelis : peliculas) {
            System.out.println(pelis);
        }
       
        System.out.println("PELICULAS CON DURACION MAYOR A 1 HORA: ");
        LocalTime unaHora = LocalTime.of(1, 00);
        for (Pelicula pelis : peliculas) {
            if (pelis.getDuracion().isAfter(unaHora)) {
                System.out.println(pelis);
            }
        }
        
        System.out.println("PELÍCULAS DE MAYOR A MENOR DURACION: ");
        Collections.sort(peliculas, new CompareMayorDuracion());
        for (Pelicula pelis : peliculas) {
            System.out.println(pelis);
        }
        
        System.out.println("PELÍCULAS DE MENOR A MAYOR DURACION: ");
        Collections.sort(peliculas, new CompareMenorDuracion());
        for (Pelicula pelis : peliculas) {
            System.out.println(pelis);
        }
        
        System.out.println("PELICULAS POR TITULO ALFABÉTICAMENTE: ");
        Collections.sort(peliculas, new CompareTituloAlfabeticamente());
        for (Pelicula pelis : peliculas) {
            System.out.println(pelis);
        }
        
        System.out.println("PELICULAS POR DIRECTOR ALFABÉTICAMENTE: ");
        Collections.sort(peliculas, new CompareDirectorAlfabeticamente());
        for (Pelicula pelis : peliculas) {
            System.out.println(pelis);
        }
    }
}