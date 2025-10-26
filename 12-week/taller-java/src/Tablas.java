import java.util.HashMap;
import java.util.Scanner;

public class Tablas {

    // HashMap para guardar ID (Integer) y Nombre (String).
    private HashMap<Integer, String> listaUsuarios = new HashMap<>();

    // 1. Agrega o actualiza un usuario.
    public void agregarUsuario(int id, String nombre) {
        listaUsuarios.put(id, nombre);
        System.out.println("Usuario registrado / actualizado.");
    }

    // 2. Busca un usuario por su ID.
    public void buscarUsuario(int id) {
        if (listaUsuarios.containsKey(id)) {
            System.out.println("ENCONTRADO: El ID " + id + " pertenece a " + listaUsuarios.get(id));
        } else {
            System.out.println("ERROR: No se encontró un usuario con el ID " + id);
        }
    }

    // 3. Muestra todos los usuarios.
    public void mostrarUsuarios() {
        System.out.println("\n LISTA DE USUARIOS");
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (HashMap.Entry<Integer, String> entrada : listaUsuarios.entrySet()) {
            System.out.println("ID: " + entrada.getKey() + " -> Nombre: " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablas registro = new Tablas ();
        String comando;

        System.out.println("REGISTRO DE USUARIOS POR ID");
        System.out.println("Comandos: [Agregar], [Buscar], [Mostrar], [Salir]");

        while (true) {
            System.out.print("\nQué quieres hacer? (Agregar/Buscar/Mostrar/Salir): ");
            comando = scanner.nextLine().toLowerCase();

            if (comando.equals("agregar")) {
                try {
                    System.out.print("Introduce el ID (número): ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Introduce el Nombre: ");
                    String nombre = scanner.nextLine();
                    registro.agregarUsuario(id, nombre);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: El ID debe ser un número.");
                }
            } else if (comando.equals("buscar")) {
                try {
                    System.out.print("Introduce el ID a buscar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    registro.buscarUsuario(id);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: El ID debe ser un número.");
                }
            } else if (comando.equals("mostrar")) {
                registro.mostrarUsuarios();
            } else if (comando.equals("salir")) {
                System.out.println("Adiós.");
                break;
            } else {
                System.out.println("Comando no reconocido.");
            }
        }
    }
}