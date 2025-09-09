import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple(); // usamos lista simple
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" Lista Simple ");
            System.out.println("1. Insertar en posición");
            System.out.println("2. Mostrar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Pedimos el número y la posición
                    System.out.print("Ingrese un número: ");
                    int valor = leer.nextInt();
                    System.out.print("Ingrese posición: ");
                    int pos = leer.nextInt();
                    lista.insertarEnPosicion(valor, pos);
                    break;
                case 2:
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
