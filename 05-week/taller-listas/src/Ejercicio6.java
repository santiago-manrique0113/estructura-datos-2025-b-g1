import java.util.Scanner;
public class Ejercicio6 {

    // Clase nodo: paciente
    static class Paciente {
        String nombre;
        Paciente siguiente;

        Paciente(String n) {
            nombre = n;
            siguiente = null;
        }
    }

    // Implementación de la cola de pacientes
    static class ColaPacientes {
        private Paciente cabeza, cola;

        // Insertar al final (O(1))
        public void ingresarPaciente(String nombre) {
            Paciente nuevo = new Paciente(nombre);
            if (cabeza == null) {
                cabeza = nuevo;
                cola = nuevo;
            } else {
                cola.siguiente = nuevo;
                cola = nuevo;
            }
            System.out.println("Paciente ingresado: " + nombre);
        }

        // Eliminar del inicio (O(1))
        public void atenderPaciente() {
            if (cabeza == null) {
                System.out.println("No hay pacientes en espera.");
                return;
            }
            System.out.println("Atendiendo a: " + cabeza.nombre);
            cabeza = cabeza.siguiente;
            if (cabeza == null) cola = null;
        }

        // Mostrar todos (O(n))
        public void mostrarCola() {
            if (cabeza == null) {
                System.out.println("No hay pacientes en espera.");
                return;
            }
            System.out.print("Lista de espera: ");
            Paciente temp = cabeza;
            while (temp != null) {
                System.out.print(temp.nombre + " -> ");
                temp = temp.siguiente;
            }
            System.out.println("null");
        }
    }

    // Programa principal con menú
    public static void main(String[] args) {
        ColaPacientes cola = new ColaPacientes();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Consultorio Médico ---");
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    cola.ingresarPaciente(nombre);
                    break;
                case 2:
                    cola.atenderPaciente();
                    break;
                case 3:
                    cola.mostrarCola();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
