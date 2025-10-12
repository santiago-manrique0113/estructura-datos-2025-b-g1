import java.util.ArrayList;
import java.util.Scanner;

public class TallerEstructuraDatos {

    // Clase interna para representar un producto con nombre, cantidad y categoría
    static class Producto {
        String nombre;
        int cantidad;
        String categoria;

        Producto(String nombre, int cantidad, String categoria) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.categoria = categoria;
        }

        public String toString() {
            return nombre + " | Cantidad: " + cantidad + " | Categoría: " + categoria ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArrayList para almacenar los productos ingresados
        ArrayList<Producto> productos = new ArrayList<>();

        // Vector con categorías fijas del área de tecnología
        String[] categorias = {"Computadores", "Celulares", "Periféricos", "Audio", "Accesorios"};

        int opcion; // Variable para guardar la opción del menú

        // Ciclo principal del menú
        do {
            System.out.println("\n- MENÚ DE TECHMARKET -");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar categorías");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que la entrada sea un número
            while (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto de línea

            switch (opcion) {

                case 1:
                    // Agregar producto
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine().trim();

                    // Validar nombre no vacío
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    // Ingresar cantidad
                    System.out.print("Ingrese la cantidad: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Debe ingresar un número entero para la cantidad.");
                        sc.next();
                    }
                    int cantidad = sc.nextInt();
                    sc.nextLine(); // limpiar salto

                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor que cero.");
                        break;
                    }

                    // Elegir categoría
                    System.out.println("Seleccione la categoría del producto:");
                    for (int i = 0; i < categorias.length; i++) {
                        System.out.println((i + 1) + ". " + categorias[i]);
                    }
                    System.out.print("Ingrese el número de la categoría: ");

                    // Validar número de categoría
                    while (!sc.hasNextInt()) {
                        System.out.println("Debe ingresar un número entre 1 y " + categorias.length + ".");
                        sc.next();
                    }
                    int numCat = sc.nextInt();
                    sc.nextLine();

                    if (numCat < 1 || numCat > categorias.length) {
                        System.out.println("Categoría no válida.");
                        break;
                    }

                    String categoriaSeleccionada = categorias[numCat - 1];

                    // Agregar producto a la lista
                    productos.add(new Producto(nombre, cantidad, categoriaSeleccionada));
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    // Listar productos
                    System.out.println("\nLista de productos registrados:");
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto p : productos) {
                            System.out.println("- " + p);
                        }
                    }
                    break;

                case 3:
                    // Eliminar producto
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String eliminar = sc.nextLine().trim();

                    if (eliminar.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    boolean encontrado = false;

                    for (int i = 0; i < productos.size(); i++) {
                        if (productos.get(i).nombre.equalsIgnoreCase(eliminar)) {
                            productos.remove(i);
                            System.out.println("Producto eliminado con éxito.");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El producto no existe en la lista");
                    }
                    break;

                case 4:
                    // Mostrar categorías
                    System.out.println("\nCategorías disponibles:");
                    for (String cat : categorias) {
                        System.out.println("- " + cat);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}
