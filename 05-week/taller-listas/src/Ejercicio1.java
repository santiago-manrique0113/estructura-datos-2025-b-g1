import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple(); // creamos la lista simple
        Scanner leer = new Scanner(System.in); // para leer datos del usuario
        int opcion;

        do {
            // Menú de opciones
            System.out.println(" Lista Simple ");
            System.out.println("1. Insertar al final");
            System.out.println("2. Mostrar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Pedimos un número y lo insertamos al final
                    System.out.print("Ingrese un número: ");
                    int valor = leer.nextInt();
                    lista.insertarFinal(valor);
                    break;
                case 2:
                    // Mostramos todos los elementos
                    lista.mostrar();
                    break;
                case 0:
                    System.out.println("saliendo");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
