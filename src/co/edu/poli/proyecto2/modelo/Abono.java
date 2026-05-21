package co.edu.poli.proyecto2.modelo;

public class Abono extends Producto {

    private String material;

    public Abono(String serial,
                 String tipo,
                 String fechaFabricacion,
                 String fechaVencimiento,
                 int cantidad,
                 double precio,
                 String material) {

        super(serial,
              tipo,
              fechaFabricacion,
              fechaVencimiento,
              cantidad,
              precio);

        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Abono{" +
                "material='" + material + '\'' +
                '}';
    }
}