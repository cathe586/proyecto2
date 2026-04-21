
package co.edu.poli.proyecto2.modelo;

public class Abono extends Producto {
    private String material;

    public Abono(String serial, String tipo, String fechafabricacion,
                String fechavencimiento, int cantidad, double precio,
                String material) {
        super(serial, tipo, fechafabricacion, fechavencimiento, cantidad, precio);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}