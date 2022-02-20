package guia_colecciones_eje04;

import java.util.Comparator;

public class CompareMayorDuracion implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula p1, Pelicula p2) {
        return p2.getDuracion().compareTo(p1.getDuracion());
    }
    
}
