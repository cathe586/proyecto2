package co.edu.poli.proyecto2.modelo;

public class Insecticida extends Producto {

    private String plaga;
    private String gradoToxico;

    public Insecticida(String serial,
                       String tipo,
                       String fechaFabricacion,
                       String fechaVencimiento,
                       int cantidad,
                       double precio,
                       String plaga,
                       String gradoToxico) {

        super(serial,
              tipo,
              fechaFabricacion,
              fechaVencimiento,
              cantidad,
              precio);

        this.plaga = plaga;
        this.gradoToxico = gradoToxico;
    }

    public String getPlaga() {
        return plaga;
    }

    public void setPlaga(String plaga) {
        this.plaga = plaga;
    }

    public String getGradoToxico() {
        return gradoToxico;
    }

    public void setGradoToxico(String gradoToxico) {
        this.gradoToxico = gradoToxico;
    }

    @Override
    public String toString() {

        return super.toString() +
                " Insecticida{" +
                "plaga='" + plaga + '\'' +
                ", gradoToxico='" + gradoToxico + '\'' +
                '}';
    }
}