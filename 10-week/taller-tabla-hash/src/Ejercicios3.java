import java.util.Scanner;

public class Ejercicios3 {
    public static void main(String[] args) {
        HashTable<Integer, String> tabla = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("=== Prueba de colisiones ===");

        do {
            System.out.println("\n1. Agregar clave y valor");
            System.out.println("2. Mostrar tabla");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Clave (número entero): ");
                    int clave = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Valor (texto): ");
                    String valor = sc.nextLine();
                    tabla.put(clave, valor);
                    break;
                case 2:
                    tabla.mostrarTodo();
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
