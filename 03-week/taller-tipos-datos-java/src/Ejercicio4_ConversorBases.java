import java.math.BigInteger;

public class Ejercicio4_ConversorBases {

    public static void main(String[] args) {
        // Número en formato de texto (string)
        String numero = "FFFFFFFFFFFFFFFF"; // ejemplo en hexadecimal
        int baseOrigen = 16; // base del número (2=binario, 10=decimal, 16=hexadecimal)

        // 1. Normalizar
        numero = numero.toUpperCase();

        // Bandera para saber si usamos BigInteger
        boolean usoBigInteger = false;

        try {
            // 2. Intentamos parsear con long (base 10 si cabe)
            long valor = Long.parseLong(numero, baseOrigen);

            // 3. Convertimos a otras bases
            String binario = Long.toString(valor, 2);
            String decimal = Long.toString(valor, 10);
            String hex = Long.toString(valor, 16).toUpperCase();

            System.out.println("Número original: " + numero + " (base " + baseOrigen + ")");
            System.out.println("Binario: " + binario);
            System.out.println("Decimal: " + decimal);
            System.out.println("Hexadecimal: " + hex);

        } catch (NumberFormatException e) {
            // Si no cabe en un long → usamos BigInteger
            usoBigInteger = true;

            BigInteger big = new BigInteger(numero, baseOrigen);

            String binario = big.toString(2);
            String decimal = big.toString(10);
            String hex = big.toString(16).toUpperCase();

            System.out.println("Número original: " + numero + " (base " + baseOrigen + ")");
            System.out.println("Binario: " + binario);
            System.out.println("Decimal: " + decimal);
            System.out.println("Hexadecimal: " + hex);
        }

        // 4. Reportamos si hubo overflow
        if (usoBigInteger) {
            System.out.println("El número era muy grande, se utilizo BigInteger.");
        } else {
            System.out.println("El número entró en un long sin ningun problema.");
        }
    }
}
