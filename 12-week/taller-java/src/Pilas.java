import java.util.Stack;
import java.util.Scanner; // Necesitamos esto para leer lo que escribe el usuario

public class Pilas {

    // 1. Las dos pilas: una para deshacer y otra para rehacer.
    private Stack<String> pilaUndo = new Stack<>();
    private Stack<String> pilaRedo = new Stack<>();
    private String textoActual = ""; // El texto que el usuario está viendo ahora.

    // Guarda el texto nuevo.
    public void escribir(String nuevoTexto) {
        // Guardo la versión anterior en la pila de deshacer.
        pilaUndo.push(textoActual);
        textoActual = nuevoTexto;
        pilaRedo.clear(); // Si escribo algo nuevo, ya no puedo rehacer lo anterior.
        System.out.println("Texto guardado");
    }

    // Vuelve al estado anterior.
    public void deshacer() {
        if (pilaUndo.isEmpty()) {
            System.out.println("No hay más cambios para DESHACER");
            return;
        }
        // Guardo la versión actual en Rehacer y vuelvo a la versión anterior.
        pilaRedo.push(textoActual);
        textoActual = pilaUndo.pop();
        System.out.println("Deshecho, ingresa nuevo texto: \"" + textoActual + "\"");
    }

    // Vuelve al estado que acababa de deshacer.
    public void rehacer() {
        if (pilaRedo.isEmpty()) {
            System.out.println("No hay más cambios para REHACER");
            return;
        }
        // Guardo la versión actual en Deshacer y avanzo.
        pilaUndo.push(textoActual);
        textoActual = pilaRedo.pop();
        System.out.println("Rehecho, ingrese nuevo texto: \"" + textoActual + "\"");
    }

    // Función principal para interactuar con el usuario.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilas editor = new Pilas();
        String comando;

        System.out.println("Editor de texto");
        System.out.println("Comandos: [Escribir], [Undo], [Redo], [Salir]");

        while (true) {
            System.out.println("\n Estado Actual: \"" + editor.textoActual + "\"");
            System.out.print("Qué quieres hacer? (Escribir/Undo/Redo/Salir): ");
            comando = scanner.nextLine().toLowerCase();

            if (comando.equals("escribir")) {
                System.out.print("Introduce el texto COMPLETO a guardar: ");
                String nuevoTexto = scanner.nextLine();
                editor.escribir(nuevoTexto);
            } else if (comando.equals("undo")) {
                editor.deshacer();
            } else if (comando.equals("redo")) {
                editor.rehacer();
            } else if (comando.equals("salir")) {
                System.out.println("Adiós.");
                break;
            } else {
                System.out.println("Comando no reconocido. Intenta de nuevo.");
            }
        }
    }
}