package guia_colecciones_eje05;

public class Guia_Colecciones_Eje05 {

    public static void main(String[] args) {
       PaisesServicio paisesServicio = new PaisesServicio();
       
       paisesServicio.pedirInformacion();
       System.out.println("");
       paisesServicio.eliminaPais();
       
       System.out.println("");
       System.out.println("Paises ordenados alfabéticamente: ");
       paisesServicio.ordenarPais();
    }
    
}
