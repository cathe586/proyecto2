package co.edu.poli.proyecto2.vista;
import java.util.Scanner;
import co.edu.poli.proyecto2.modelo.Abono;
import co.edu.poli.proyecto2.modelo.Fertilizante;
import co.edu.poli.proyecto2.modelo.Insecticida;
import co.edu.poli.proyecto2.modelo.Producto;
import co.edu.poli.proyecto2.servicios.ImplementacionCrud;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ImplementacionCrud crud = new ImplementacionCrud();

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Crear");
            System.out.println("2. Buscar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Guardar");
            System.out.println("7. Cargar");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Tipo (1-Fertilizante, 2-Abono, 3-Insecticida): ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("Serial: ");
                    String serial = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipoD = sc.nextLine();

                    System.out.print("Fecha fabricación: ");
                    String ff = sc.nextLine();

                    System.out.print("Fecha vencimiento: ");
                    String fv = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cant = Integer.parseInt(sc.nextLine());

                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());

                    Producto nuevo = null;

                    if (tipo == 1) {
                        System.out.print("Composición: ");
                        nuevo = new Fertilizante(serial, tipoD, ff, fv, cant, precio, sc.nextLine());
                    } else if (tipo == 2) {
                        System.out.print("Material: ");
                        nuevo = new Abono(serial, tipoD, ff, fv, cant, precio, sc.nextLine());
                    } else if (tipo == 3) {
                        System.out.print("Plaga: ");
                        String plaga = sc.nextLine();
                        System.out.print("Grado tóxico: ");
                        String grado = sc.nextLine();
                        nuevo = new Insecticida(serial, tipoD, ff, fv, cant, precio, plaga, grado);
                    }

                    System.out.println(crud.crear(nuevo));
                    break;

                case 2:
                    System.out.print("Serial: ");
                    Producto p = crud.buscar(Integer.parseInt(sc.nextLine()));
                    System.out.println(p != null ? p : "No encontrado");
                    break;

                case 3:
                    System.out.print("Serial: ");
                    Producto pA = crud.buscar(Integer.parseInt(sc.nextLine()));

                    if (pA != null) {
                        System.out.print("Nuevo precio: ");
                        pA.setPrecio(Double.parseDouble(sc.nextLine()));
                        System.out.println(crud.actualizar(pA));
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 4:
                    System.out.print("Serial: ");
                    System.out.println(crud.eliminar(Integer.parseInt(sc.nextLine())));
                    break;

                case 5:
                    for (Producto prod : crud.getArreglo()) {
                        System.out.println(prod != null ? prod : "[Vacío]");
                    }
                    break;

                case 6:
                    System.out.println(crud.serializar(crud.getArreglo()[0], "./", "datos.dat"));
                    break;

                case 7:
                    Producto rec = crud.deserializar("./", "datos.dat");
                    System.out.println(rec != null ? rec : "Error al cargar");
                    break;

                case 8:
                    System.out.println("Adiós");
                    break;
            }

        } while (opcion != 8);

        sc.close();
    }
}