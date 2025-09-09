import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple(); // lista simple
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" Lista Simple ");
            System.out.println("1. Insertar al final");
            System.out.println("2. Eliminar en posición");
            System.out.println("3. Mostrar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    int valor = leer.nextInt();
                    lista.insertarFinal(valor);
                    break;
                case 2:
                    System.out.print("Ingrese posición a eliminar: ");
                    int pos = leer.nextInt();
                    lista.eliminarEnPosicion(pos);
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
