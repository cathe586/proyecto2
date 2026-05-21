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

            mostrarMenu();

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    crearProducto(sc, crud);
                    break;

                case 2:
                    buscarProducto(sc, crud);
                    break;

                case 3:
                    actualizarProducto(sc, crud);
                    break;

                case 4:
                    eliminarProducto(sc, crud);
                    break;

                case 5:
                    listarProductos(crud);
                    break;

                case 6:
                    guardarProducto(crud);
                    break;

                case 7:
                    cargarProducto(crud);
                    break;

                case 8:
                    System.out.println("Adiós");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 8);

        sc.close();
    }

    public static void mostrarMenu() {

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
    }

    public static void crearProducto(Scanner sc, ImplementacionCrud crud) {

        System.out.println("1. Fertilizante");
        System.out.println("2. Abono");
        System.out.println("3. Insecticida");
        System.out.print("Tipo: ");

        int tipo = leerEntero(sc);

        System.out.print("Serial: ");
        String serial = sc.nextLine();

        System.out.print("Tipo producto: ");
        String tipoProducto = sc.nextLine();

        System.out.print("Fecha fabricación: ");
        String fechaFabricacion = sc.nextLine();

        System.out.print("Fecha vencimiento: ");
        String fechaVencimiento = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = leerEntero(sc);

        System.out.print("Precio: ");
        double precio = leerDouble(sc);

        Producto nuevo = null;

        switch (tipo) {

            case 1:

                System.out.print("Composición: ");
                String composicion = sc.nextLine();

                nuevo = new Fertilizante(serial, tipoProducto,
                        fechaFabricacion, fechaVencimiento,
                        cantidad, precio, composicion);

                break;

            case 2:

                System.out.print("Material: ");
                String material = sc.nextLine();

                nuevo = new Abono(serial, tipoProducto,
                        fechaFabricacion, fechaVencimiento,
                        cantidad, precio, material);

                break;

            case 3:

                System.out.print("Plaga: ");
                String plaga = sc.nextLine();

                System.out.print("Grado tóxico: ");
                String grado = sc.nextLine();

                nuevo = new Insecticida(serial, tipoProducto,
                        fechaFabricacion, fechaVencimiento,
                        cantidad, precio, plaga, grado);

                break;

            default:
                System.out.println("Tipo inválido");
                return;
        }

        System.out.println(crud.crear(nuevo));
    }

    public static void buscarProducto(Scanner sc, ImplementacionCrud crud) {

        System.out.print("Serial: ");

        String serial = sc.nextLine();

        Producto producto = crud.buscar(serial);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public static void actualizarProducto(Scanner sc, ImplementacionCrud crud) {

        System.out.print("Serial: ");

        String serial = sc.nextLine();

        Producto producto = crud.buscar(serial);

        if (producto != null) {

            System.out.print("Nuevo precio: ");

            double nuevoPrecio = leerDouble(sc);

            producto.setPrecio(nuevoPrecio);

            System.out.println(crud.actualizar(serial, producto));

        } else {

            System.out.println("Producto no encontrado");
        }
    }

    public static void eliminarProducto(Scanner sc, ImplementacionCrud crud) {

        System.out.print("Serial: ");

        String serial = sc.nextLine();

        System.out.println(crud.eliminar(serial));
    }

    public static void listarProductos(ImplementacionCrud crud) {

        System.out.println("\n===== PRODUCTOS =====");

        for (Producto producto : crud.getArreglo()) {

            if (producto != null) {
                System.out.println(producto);
            }
        }
    }

    public static void guardarProducto(ImplementacionCrud crud) {

        if (crud.getArreglo()[0] != null) {

            System.out.println(crud.serializar(
                    crud.getArreglo()[0],
                    "./",
                    "datos.dat"));

        } else {

            System.out.println("No hay productos");
        }
    }

    public static void cargarProducto(ImplementacionCrud crud) {

        Producto producto = crud.deserializar("./", "datos.dat");

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Error al cargar");
        }
    }

    public static int leerEntero(Scanner sc) {

        while (!sc.hasNextInt()) {

            System.out.println("Error: solo números enteros");
            sc.next();
        }

        int numero = sc.nextInt();
        sc.nextLine();

        return numero;
    }

    public static double leerDouble(Scanner sc) {

        while (!sc.hasNextDouble()) {

            System.out.println("Error: solo números");
            sc.next();
        }

        double numero = sc.nextDouble();
        sc.nextLine();

        return numero;
    }
}