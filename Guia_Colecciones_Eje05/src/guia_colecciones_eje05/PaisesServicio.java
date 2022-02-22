package guia_colecciones_eje05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class PaisesServicio {
    
    private HashSet<Paises> paises;
    private Scanner leer;

    public PaisesServicio() {
        this.paises = new HashSet<>();
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }
    
    public void pedirInformacion(){
        String nombre;
        String opcion;
        
        do{    
            System.out.println("Ingrese un pais: ");
            nombre = leer.next();
            crearPais(nombre);
            do{
                System.out.println("Desea crear otro pais? S/N");
                opcion = leer.next().toUpperCase();
            }while(!opcion.equals("N") && !opcion.equals("S"));
        }while(!opcion.equals("N"));
    }
    
    public void crearPais(String nombre){
        Paises pais = new Paises();
        
        pais.setPais(nombre);
        
        agregarPais(pais);
    }
    
    public void agregarPais(Paises pais){
        this.paises.add(pais);
    }
    
    public void mostrarPais(){
        for (Paises p: paises) {
            System.out.println(p);
        }
    }
    
    public void ordenarPais(){
        ArrayList<Paises> paisesLista = new ArrayList(this.paises);
        
        Collections.sort(paisesLista);
        
        for (Paises p : paisesLista) {
            System.out.println(p);
        }
    }
    
    public void eliminaPais(){
        String eliminarPais;
        boolean bandera = false;
        
        System.out.println("Ingrese un pais a eliminar: ");
        eliminarPais = leer.next();
        Iterator<Paises> iterator = paises.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getPais().equalsIgnoreCase(eliminarPais)){
                iterator.remove();
                bandera = true;
            }
        }
        if(bandera == true){
            System.out.println("El país fue eliminado.");
        }else{
            System.out.println("El pais no fue encontrado para eliminarlo.");
        }
    }
    
    
}
