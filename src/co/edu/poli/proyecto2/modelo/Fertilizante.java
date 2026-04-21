
package co.edu.poli.proyecto2.modelo;

public class Fertilizante extends Producto {
    private String composicion;

    public Fertilizante(String serial, String tipo, String fechafabricacion,
                        String fechavencimiento, int cantidad, double precio,
                        String composicion) {
        super(serial, tipo, fechafabricacion, fechavencimiento, cantidad, precio);
        this.composicion = composicion;
    }

    public String getComposicion() { return composicion; }
    public void setComposicion(String composicion) { this.composicion = composicion; }
}