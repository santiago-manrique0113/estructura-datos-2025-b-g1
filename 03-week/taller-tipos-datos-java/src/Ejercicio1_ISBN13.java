public class Ejercicio1_ISBN13 {

    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) return false;

        int suma = 0; // Se van a ir sumando los cálculos

        // Recorremos cada numero del ISBN
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i); // Tomamos el carácter en la posición i

            // Si el carácter NO es un número, el ISBN no sirve
            if (!Character.isDigit(c)) return false;

            int d = c - '0'; // Convertimos el carácter a número (ej: '5' → 5)

            // Los números en posiciones pares se multiplican por 1
            // Los números en posiciones impares se multiplican por 3
            if (i % 2 == 0) { 
                suma += d * 1; 
            } else { 
                suma += d * 3; 
            }
        }

        // Un ISBN es válido si la suma total es múltiplo de 10
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        // Probamos con un ISBN de ejemplo
        String prueba = "9780306406157";

        // Mostramos si es válido o no
        System.out.println("ISBN válido? " + isValidISBN13(prueba));
    }
}
