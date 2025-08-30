import java.util.Scanner;

public class Ejercicio2_RLE {

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);

        // Pedir texto al usuario
        System.out.print("Ingrese el texto a comprimir: ");
        String texto = Leer.nextLine();

        // COMPRESIÓN
        StringBuilder resultado = new StringBuilder();
        if (!texto.isEmpty()) {
            int contador = 1;
            for (int i = 1; i < texto.length(); i++) {
                char actual = texto.charAt(i);
                char anterior = texto.charAt(i - 1);

                if (actual == anterior) {
                    contador++;
                } else {
                    resultado.append(anterior).append(contador);
                    contador = 1;
                }
            }
            resultado.append(texto.charAt(texto.length() - 1)).append(contador);
        }

        String comprimido = resultado.toString();
        System.out.println("Texto comprimido: " + comprimido);
        // DESCOMPRESIÓN
        StringBuilder descomprimido = new StringBuilder();
        String numero = "";

        for (int i = 0; i < comprimido.length(); i++) {
            char c = comprimido.charAt(i);

            if (Character.isLetter(c)) {
                if (!numero.isEmpty()) {
                    int repeticiones = Integer.parseInt(numero);
                    char anterior = comprimido.charAt(i - numero.length() - 1);
                    for (int j = 1; j < repeticiones; j++) {
                        descomprimido.append(anterior);
                    }
                    numero = "";
                }
                descomprimido.append(c);
            } else if (Character.isDigit(c)) {
                numero += c;
            }
        }

        if (!numero.isEmpty()) {
            int repeticiones = Integer.parseInt(numero);
            char anterior = comprimido.charAt(comprimido.length() - numero.length() - 1);
            for (int j = 1; j < repeticiones; j++) {
                descomprimido.append(anterior);
            }
        }

        System.out.println("Texto descomprimido: " + descomprimido.toString());
        // RATIO DE COMPRESIÓN
        double ratio = texto.isEmpty() ? 0 : (double) comprimido.length() / texto.length();
        System.out.println("Ratio de compresión: " + ratio);

    }
}
