import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase para un elemento simple con Nombre y Prioridad.
 * La PriorityQueue usará el número de prioridad para ordenar.
 */
class Tarea {
    String nombre;
    int prioridad; // ¡El número MÁS BAJO es el MÁS importante!

    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    // Esto es para que se vea bien al imprimir el objeto
    public String toString() {
        return nombre + " (Prioridad: " + prioridad + ")";
    }
}

public class Colas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Creamos la Cola de Prioridad.
        // Le decimos que ordene comparando los números de prioridad para que el más bajo vaya primero.
        PriorityQueue<Tarea> colaPrioridad = new PriorityQueue<>(
                Comparator.comparingInt(t -> t.prioridad)
        );

        String comando;
        System.out.println("SISTEMA DE ATENCIÓN POR PRIORIDADES");
        System.out.println("Comandos: [Agregar], [Atender], [Salir]");

        while (true) {
            System.out.println("\nTareas en espera: " + colaPrioridad.size() + "");
            System.out.print("El elemento a atender es: " + (colaPrioridad.isEmpty() ? "Nadie" : colaPrioridad.peek()) + "\n");

            System.out.print("¿Qué quieres hacer? (Agregar/Atender/Salir): ");
            comando = scanner.nextLine().toLowerCase();

            if (comando.equals("agregar")) {
                System.out.print("Nombre de la tarea: ");
                String nombre = scanner.nextLine();

                System.out.print("Nivel de Prioridad (1 es urgente, 5 es normal): ");
                // Intentamos leer el número
                try {
                    int prioridad = Integer.parseInt(scanner.nextLine());
                    // 2. Agregamos la tarea a la cola con offer().
                    colaPrioridad.offer(new Tarea(nombre, prioridad));
                    System.out.println("Tarea agregada con prioridad " + prioridad);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: La prioridad debe ser un número.");
                }

            } else if (comando.equals("atender")) {
                // 3. Atendemos (quitamos) la tarea de mayor prioridad con poll().
                if (colaPrioridad.isEmpty()) {
                    System.out.println("La cola está vacía, no hay nada que atender.");
                } else {
                    Tarea atendida = colaPrioridad.poll();
                    System.out.println("ATENDIENDO: " + atendida);
                }

            } else if (comando.equals("salir")) {
                System.out.println("Saliendo del sistema de atención.");
                break;
            } else {
                System.out.println("Comando no reconocido. Intenta de nuevo.");
            }
        }
    }
}