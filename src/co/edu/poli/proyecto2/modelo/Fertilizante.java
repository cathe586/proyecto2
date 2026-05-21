package co.edu.poli.proyecto2.modelo;

public class Fertilizante extends Producto {

    private String composicion;

    public Fertilizante(String serial,
                         String tipo,
                         String fechaFabricacion,
                         String fechaVencimiento,
                         int cantidad,
                         double precio,
                         String composicion) {

        super(serial,
              tipo,
              fechaFabricacion,
              fechaVencimiento,
              cantidad,
              precio);

        this.composicion = composicion;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Fertilizante{" +
                "composicion='" + composicion + '\'' +
                '}';
    }
}