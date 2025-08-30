import java.util.Scanner;

public class Ejercicio5_Tiempos {
    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);

        // Se pide cuántos tiempos va a ingresar el usuario
        System.out.print("¿Cuántos tiempos vas a ingresar? ");
        int n = Leer.nextInt();
        Leer.nextLine(); // Limpiar el buffer

        // Se crea un arreglo para guardar los tiempos ingresados
        String[] tiempos = new String[n];

        // Pedimos los tiempos en formato HH:MM:SS
        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el tiempo " + (i + 1) + " (formato HH:MM:SS): ");
            tiempos[i] = Leer.nextLine();
        }

        // Guardamos los tiempos convertidos a segundos
        int[] tiemposSegundos = new int[tiempos.length];

        // Convertimos cada string (HH:MM:SS) a segundos
        for (int i = 0; i < tiempos.length; i++) {
            String[] partes = tiempos[i].split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);

            int totalSegundos = horas * 3600 + minutos * 60 + segundos;
            tiemposSegundos[i] = totalSegundos;
        }

        // Calculamos el total sumando todos los tiempos
        int total = 0;
        for (int t : tiemposSegundos) {
            total += t;
        }

        // Calculamos el promedio
        double promedio = (double) total / tiemposSegundos.length;

        // Buscamos el tramo más largo
        int maximo = tiemposSegundos[0];
        int indiceMax = 0;
        for (int i = 1; i < tiemposSegundos.length; i++) {
            if (tiemposSegundos[i] > maximo) {
                maximo = tiemposSegundos[i];
                indiceMax = i;
            }
        }

        // Convertimos el total de segundos a formato HH:MM:SS
        int horasTotales = total / 3600;
        int minutosTotales = (total % 3600) / 60;
        int segundosTotales = total % 60;
        String totalFormato = String.format("%02d:%02d:%02d", horasTotales, minutosTotales, segundosTotales);

        // Resultados
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Tiempo total: " + totalFormato);
        System.out.println("Promedio (en segundos): " + promedio);
        System.out.println("Tramo más largo: " + tiempos[indiceMax]);

        // Calcular los porcentajes de cada tramo
        System.out.println("\nPorcentajes de cada tramo:");
        for (int i = 0; i < tiemposSegundos.length; i++) {
            double porcentaje = (double) tiemposSegundos[i] / total * 100;
            System.out.println(tiempos[i] + " -> " + String.format("%.2f", porcentaje) + "%");
        }
    }
}
