import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble(); // lista doblemente enlazada
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" Lista Doble ");
            System.out.println("1. Insertar al final");
            System.out.println("2. Eliminar al inicio");
            System.out.println("3. Eliminar al final");
            System.out.println("4. Mostrar lista");
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
                    lista.eliminarInicio();
                    break;
                case 3:
                    lista.eliminarFinal();
                    break;
                case 4:
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
