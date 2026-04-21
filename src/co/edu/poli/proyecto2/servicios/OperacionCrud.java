
package co.edu.poli.proyecto2.servicios;
import co.edu.poli.proyecto2.modelo.Producto;

public interface OperacionCrud {
    String crear(Producto p);
    Producto leer();
    String actualizar(Producto p);
    String eliminar(int serial);
    Producto buscar(int serial);
    Producto[] getArreglo();
}
