package co.edu.poli.proyecto2.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.proyecto2.modelo.Producto;

public class ImplementacionCrud implements OperacionCrud,
                                           OperacionArchivo {

    private Producto[] arreglo;
    private int contador;

    public ImplementacionCrud() {

        arreglo = new Producto[10];
        contador = 0;
    }

    @Override
    public String crear(Producto p) {

        if (contador < arreglo.length) {

            arreglo[contador] = p;
            contador++;

            return "Producto agregado correctamente";
        }

        return "No hay espacio";
    }

    @Override
    public Producto leer(String serial) {

        for (int i = 0; i < contador; i++) {

            if (arreglo[i] != null &&
                arreglo[i].getSerial().equals(serial)) {

                return arreglo[i];
            }
        }

        return null;
    }

    @Override
    public String actualizar(String serial,
                              Producto p) {

        for (int i = 0; i < contador; i++) {

            if (arreglo[i] != null &&
                arreglo[i].getSerial().equals(serial)) {

                arreglo[i] = p;

                return "Producto actualizado";
            }
        }

        return "Producto no encontrado";
    }

    @Override
    public String eliminar(String serial) {

        for (int i = 0; i < contador; i++) {

            if (arreglo[i] != null &&
                arreglo[i].getSerial().equals(serial)) {

                arreglo[i] = null;

                return "Producto eliminado";
            }
        }

        return "Producto no encontrado";
    }

    @Override
    public Producto buscar(String serial) {

        return leer(serial);
    }

    @Override
    public String serializar(Producto p,
                             String path,
                             String name) {

        try {

            FileOutputStream fos =
                    new FileOutputStream(path + name);

            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(p);

            oos.close();
            fos.close();

            return "Archivo guardado correctamente";

        } catch (Exception e) {

            return "Error al guardar";
        }
    }

    @Override
    public Producto deserializar(String path,
                                 String name) {

        try {

            FileInputStream fis =
                    new FileInputStream(path + name);

            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            Producto producto =
                    (Producto) ois.readObject();

            ois.close();
            fis.close();

            return producto;

        } catch (Exception e) {

            return null;
        }
    }

    public Producto[] getArreglo() {
        return arreglo;
    }
}