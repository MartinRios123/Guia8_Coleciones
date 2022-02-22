package guia_colecciones_eje06;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {
    
    private HashMap<String, Integer> productos;
    private Scanner leer;

    public ProductoServicio() {
        this.productos = new HashMap<>();
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }
    
    public void cargarProductos(){
        String producto;
        int precio;
        String opcion;
        
        do{    
            System.out.println("Ingrese un producto: ");
            producto = leer.next();
            System.out.println("Ingrese su precio: ");
            precio = leer.nextInt();
            this.productos.put(producto, precio);
            do{
                System.out.println("Desea crear otro producto? S/N");
                opcion = leer.next().toUpperCase();
            }while(!opcion.equals("N") && !opcion.equals("S"));
        }while(!opcion.equals("N"));
    }
    
    public void mostrarProductos(){
        for (Map.Entry<String, Integer> entry : this.productos.entrySet()) {
            System.out.println(entry.getKey()+ "  $" + entry.getValue());
        }
    }
    
    public void modificarPrecio(){
        String modificarProducto;
        
        System.out.println("Ingrese que producto quiere modificar su precio: ");
        modificarProducto = leer.next();
        if (productos.containsKey(modificarProducto)) {
            System.out.println("Ingrese un nuevo precio: ");
            productos.put(modificarProducto, leer.nextInt());
            System.out.println("Precio modificado");
        }else{
            System.out.println("No se encontró el producto para modificar");
        }
    }
    
    public void borrarProducto(){
        String eliminarProducto;
        
        System.out.println("Ingrese que producto que desea eliminar: ");
        eliminarProducto = leer.next();
        if (productos.containsKey(eliminarProducto)) {
            productos.remove(eliminarProducto);
            System.out.println("Producto eliminado");
        }else{
            System.out.println("No se pudo eliminar el producto ya que no se encontró");
        }
    }
}

/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */