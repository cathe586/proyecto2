
package co.edu.poli.proyecto2.modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable {

    private String serial;
    private String tipo;
    private String fechaFabricacion;
    private String fechaVencimiento;
    private int cantidad;
    private double precio;

    public Producto(String serial,
                     String tipo,
                     String fechaFabricacion,
                     String fechaVencimiento,
                     int cantidad,
                     double precio) {

        this.serial = serial;
        this.tipo = tipo;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String calcularTiempoVencimiento(String fechaActual,
                                            String fechaVencimiento) {

        return "Cálculo pendiente";
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {

        return "Producto{" +
                "serial='" + serial + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaFabricacion='" + fechaFabricacion + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}