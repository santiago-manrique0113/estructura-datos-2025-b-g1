import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular(); // lista circular
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" Lista Circular ");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar valor");
            System.out.println("3. Mostrar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    int valor = leer.nextInt();
                    lista.insertar(valor);
                    break;
                case 2:
                    System.out.print("Ingrese valor a eliminar: ");
                    int eliminar = leer.nextInt();
                    lista.eliminar(eliminar);
                    break;
                case 3:
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
