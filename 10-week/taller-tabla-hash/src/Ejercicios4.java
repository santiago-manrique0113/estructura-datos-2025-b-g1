import java.util.Scanner;

public class Ejercicios4 {
    public static void main(String[] args) {
        HashTable<String, String> tabla = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("Prueba de tamaño y operaciones ===");

        do {
            System.out.println("\n1. Agregar clave y valor");
            System.out.println("2. Eliminar por clave");
            System.out.println("3. Mostrar cantidad");
            System.out.println("4. Ver si está vacía");
            System.out.println("5. Mostrar todo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Clave: ");
                    String clave = sc.nextLine();
                    System.out.print("Valor: ");
                    String valor = sc.nextLine();
                    tabla.put(clave, valor);
                    break;
                case 2:
                    System.out.print("Clave a eliminar: ");
                    clave = sc.nextLine();
                    tabla.remove(clave);
                    System.out.println("Eliminado (si existía).");
                    break;
                case 3:
                    System.out.println("Tamaño actual: " + tabla.size());
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + tabla.isEmpty());
                    break;
                case 5:
                    tabla.mostrarTodo();
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
