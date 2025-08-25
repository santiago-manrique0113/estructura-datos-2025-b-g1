public class Ejercicio2_RLE {

    public static String comprimir(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        StringBuilder resultado = new StringBuilder(); // Para construir el texto comprimido
        int contador = 1; // Contador de repeticiones

        // Recorremos el texto desde el segundo caracter
        for (int i = 1; i < texto.length(); i++) {
            char actual = texto.charAt(i);       // Caracter actual
            char anterior = texto.charAt(i - 1); // Caracter anterior

            if (actual == anterior) {
                // Si se repite,se aumenta el contador
                contador++;
            } else {
                // Si cambia el caracter, agregamos al resultado
                resultado.append(anterior).append(contador);
                contador = 1; // Se reinicia el contador
            }
        }

        // Al final agregamos el último caracter con su contador
        resultado.append(texto.charAt(texto.length() - 1)).append(contador);

        return resultado.toString();
    }

    // Método para calcular el ratio de compresión
    public static double calcularRatio(String original, String comprimido) {
        if (original.isEmpty()) return 0; // Evitar división por cero
        return (double) comprimido.length() / original.length();
    }

    public static void main(String[] args) {
        // Texto de ejemplo
        String texto = "aaabbccccd";
        System.out.println("Texto original: " + texto);

        // Comprimir
        String comprimido = comprimir(texto);
        System.out.println("Texto comprimido: " + comprimido);

        // Calcular ratio
        double ratio = calcularRatio(texto, comprimido);
        System.out.println("Ratio de compresión: " + ratio);
    }
}
