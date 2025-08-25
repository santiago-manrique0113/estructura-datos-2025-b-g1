public class Ejercicio3_Temperaturas {

    public static void main(String[] args) {
        // Texto con las temperaturas separadas por comas
        String datos = "23.4,21.8,22.1,24.0,20.5";

        // 1. Dividimos el texto usando split(",")
        String[] partes = datos.split(",");

        // Creamos un arreglo de double para guardar los números
        double[] temperaturas = new double[partes.length];

        // 2. Convertimos cada parte del texto en número 
        for (int i = 0; i < partes.length; i++) {
            temperaturas[i] = Double.parseDouble(partes[i].trim());
        }

        // Variables para los cálculos
        double suma = 0;
        double min = temperaturas[0]; 
        double max = temperaturas[0]; 

        // 3. Recorremos para calcular suma, mínimo y máximo
        for (double t : temperaturas) {
            suma += t;
            if (t < min) min = t;
            if (t > max) max = t;
        }

        // 4. Promedio
        double promedio = suma / temperaturas.length;

        // 5. Varianza = promedio 
        double sumaVarianza = 0;
        for (double t : temperaturas) {
            sumaVarianza += Math.pow(t - promedio, 2);
        }
        double varianza = sumaVarianza / temperaturas.length;

        // 6. Desviación estándar 
        double desviacion = Math.sqrt(varianza);

        // Mostramos los resultados
        System.out.println("Temperaturas: " + datos);
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
