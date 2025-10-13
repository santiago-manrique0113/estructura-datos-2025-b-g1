// Ejercicio1.java
import java.util.Scanner;

public class Ejercicios1 {
    public static void main(String[] args) {
        HashTable<String, String> diccionario = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar usuario");
            System.out.println("2. Consultar rol");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar todos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Usuario: ");
                    String user = sc.nextLine();
                    System.out.print("Rol: ");
                    String rol = sc.nextLine();
                    diccionario.put(user, rol);
                    break;
                case 2:
                    System.out.print("Usuario: ");
                    user = sc.nextLine();
                    System.out.println("Rol: " + diccionario.get(user));
                    break;
                case 3:
                    System.out.print("Usuario: ");
                    user = sc.nextLine();
                    diccionario.remove(user);
                    break;
                case 4:
                    diccionario.mostrarTodo();
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}
