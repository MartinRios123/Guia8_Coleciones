package guia_colecciones_eje06;

import java.util.Locale;
import java.util.Scanner;

public class Guia_Colecciones_Eje06 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ProductoServicio productoServicio = new ProductoServicio();
        
        int opcion;
        
        do{
            System.out.println("--------Menu--------");
            System.out.println("1. Cargar producto");
            System.out.println("2. Modificar precio de algun producto");
            System.out.println("3. Borrar producto");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    productoServicio.cargarProductos();
                    break;
                case 2:
                    productoServicio.modificarPrecio();
                    break;
                case 3: 
                    productoServicio.borrarProducto();
                    break;
                case 4:
                    productoServicio.mostrarProductos();
                    break;
                case 5:
                    System.out.println("Salió.");
                    break;
                default:
                    System.out.println("OPCION ERRONEA.");
            }
        }while(opcion != 5);
    }
    
}
