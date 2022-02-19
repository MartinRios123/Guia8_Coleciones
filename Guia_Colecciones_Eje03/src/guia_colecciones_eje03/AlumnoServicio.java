package guia_colecciones_eje03;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AlumnoServicio {
    
    private ArrayList<Alumno> alumnos;
    private Scanner leer;
    
    public AlumnoServicio() {
        this.alumnos = new ArrayList<>();
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }
    
    public void pedirInformacion(){
        int nota;
        String opcion;
        ArrayList<Integer> notas = null;
        String nombre;
        
        do{
            System.out.println("Ingrese el nombre de un alumno:"); 
            nombre = leer.next().toUpperCase();
            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese su nota [" + (i+1) + "]");
                nota = leer.nextInt();
                notas.add(nota);
            }
            crearAlumno(nombre,notas);
            do{
                System.out.println("Desea crear otro alumno? S/N");
                opcion = leer.next().toUpperCase();
            }while(!opcion.equals("N") && !opcion.equals("S"));
        }while(!opcion.equals("N"));
    }
    
    public void crearAlumno(String nombre, ArrayList<Integer> notas){
        Alumno alumno = new Alumno();
        
        alumno.setNombre(nombre);
        alumno.setNotas(notas);
        
        agregarAlumno(alumno);      
    }
    
    public void agregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }
    
    public void ingresarNombreYCalcular(){
        System.out.println("Ingrese un alumno a buscar: ");
        String nombre = leer.next();
        Alumno alumno = buscarAlumno(nombre);
        if (alumno != null) {
            System.out.println(notaFinal(alumno));
        }else{
            System.out.println("No se encontró el alumno que ingresó.");
        }    
    }
    
    public Alumno buscarAlumno(String nombre){
        Alumno alumnoBuscado = null;
        
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                alumnoBuscado = alumno;
            }
        }
        
        return alumnoBuscado;
    }
    
    public double notaFinal(Alumno alumno){
        int acumulador = 0;
        
        for (Integer notas : alumno.getNotas()) {
            acumulador += notas;
        }
        
        return (double) acumulador / alumno.getNotas().size();
    }
}
