
package co.edu.poli.proyecto2.servicios;
import co.edu.poli.proyecto2.modelo.Producto;

public interface OperacionArchivo {
    String serializar(Producto producto, String path, String name);
    Producto deserializar(String path, String name);
    Producto[] getArreglo();
}