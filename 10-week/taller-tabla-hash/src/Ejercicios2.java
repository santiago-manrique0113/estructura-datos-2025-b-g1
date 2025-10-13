import java.util.Scanner;

public class Ejercicios2 {
    public static void main(String[] args) {
        HashTable<String, Integer> contador = new HashTable<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Contador de palabras ===");
        System.out.println("Escribe una línea de texto:");
        String texto = sc.nextLine();

        // Dividir el texto en palabras
        String[] palabras = texto.split(" ");

        // Contar ocurrencias
        for (String p : palabras) {
            p = p.toLowerCase();
            Integer valor = contador.get(p);
            if (valor == null) {
                contador.put(p, 1);
            } else {
                contador.put(p, valor + 1);
            }
        }

        // Mostrar resultados
        System.out.println("\nConteo de palabras:");
        contador.mostrarTodo();

        sc.close();
    }
}
