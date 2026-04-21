package co.edu.poli.proyecto2.servicios;

import co.edu.poli.proyecto2.modelo.Producto;

public class ImplementacionCrud implements OperacionCrud, OperacionArchivo {

    private Producto[] arreglo = new Producto[2];

    @Override
    public String crear(Producto p) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = p;
                return "Producto creado correctamente.";
            }
        }
        return "Arreglo lleno.";
    }

    @Override
    public Producto leer() {
        for (Producto p : arreglo) {
            if (p != null) return p;
        }
        return null;
    }

    @Override
    public String actualizar(Producto p) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getSerial().equals(p.getSerial())) {
                arreglo[i] = p;
                return "Producto actualizado.";
            }
        }
        return "Producto no encontrado.";
    }

    @Override
    public String eliminar(int serial) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getSerial().equals(String.valueOf(serial))) {
                arreglo[i] = null;
                return "Producto eliminado.";
            }
        }
        return "Producto no encontrado.";
    }

    @Override
    public Producto buscar(int serial) {
        for (Producto p : arreglo) {
            if (p != null && p.getSerial().equals(String.valueOf(serial))) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String serializar(Producto producto, String path, String name) {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream(path + "/" + name))) {
            oos.writeObject(producto);
            return "Serialización exitosa.";
        } catch (Exception e) {
            return "Error al serializar: " + e.getMessage();
        }
    }

    @Override
    public Producto deserializar(String path, String name) {
        try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                new java.io.FileInputStream(path + "/" + name))) {
            return (Producto) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    
    public Producto[] getArreglo() {
        return arreglo;
    }
}