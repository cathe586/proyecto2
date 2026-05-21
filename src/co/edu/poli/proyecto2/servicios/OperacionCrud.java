package co.edu.poli.proyecto2.servicios;

import co.edu.poli.proyecto2.modelo.Producto;

public interface OperacionCrud {

    String crear(Producto p);

    Producto leer(String serial);

    String actualizar(String serial, Producto p);

    String eliminar(String serial);

    Producto buscar(String serial);
}