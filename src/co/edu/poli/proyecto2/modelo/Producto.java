import java.io.Serializable;
package co.edu.poli.proyecto2.modelo;

public abstract class Producto implements Serializable {
    private String serial;
    private String tipo;
    private String fechafabricacion;
    private String fechavencimiento;
    private int cantidad;
    private double precio;

    public Producto(String serial, String tipo, String fechafabricacion,
                    String fechavencimiento, int cantidad, double precio) {
        this.serial = serial;
        this.tipo = tipo;
        this.fechafabricacion = fechafabricacion;
        this.fechavencimiento = fechavencimiento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String calculartiempovencimiento(String fechaactual, String fechavencimiento) {
        
        return "";
    }

    
    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getFechafabricacion() { return fechafabricacion; }
    public void setFechafabricacion(String fechafabricacion) { this.fechafabricacion = fechafabricacion; }
    public String getFechavencimiento() { return fechavencimiento; }
    public void setFechavencimiento(String fechavencimiento) { this.fechavencimiento = fechavencimiento; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
    
