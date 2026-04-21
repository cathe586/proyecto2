package co.edu.poli.proyecto2.modelo;

public class Insecticida extends Producto {
    private String plaga;
    private String gradotoxico;

    public Insecticida(String serial, String tipo, String fechafabricacion,
                        String fechavencimiento, int cantidad, double precio,
                        String plaga, String gradotoxico) {
        super(serial, tipo, fechafabricacion, fechavencimiento, cantidad, precio);
        this.plaga = plaga;
        this.gradotoxico = gradotoxico;
    }

    public String getPlaga() { return plaga; }
    public void setPlaga(String plaga) { this.plaga = plaga; }
    public String getGradotoxico() { return gradotoxico; }
    public void setGradotoxico(String gradotoxico) { this.gradotoxico = gradotoxico; }
}