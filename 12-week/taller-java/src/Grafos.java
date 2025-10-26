import java.util.*;

public class Grafos {
    // Mapa: Ciudad -> Lista de ciudades conectadas
    private Map<String, List<String>> adyacencias = new HashMap<>();

    // Agregar una ciudad (vértice)
    void agregarVertice(String v) {
        adyacencias.putIfAbsent(v, new ArrayList<>());
    }

    // Conectar dos ciudades (arista bidireccional)
    void agregarArista(String v1, String v2) {
        if (!adyacencias.containsKey(v1) || !adyacencias.containsKey(v2)) {
            System.out.println("Error: una o ambas ciudades no existen en el mapa.");
            return;
        }
        adyacencias.get(v1).add(v2);
        adyacencias.get(v2).add(v1);
    }

    // Algoritmo BFS que devuelve la ruta más corta entre dos ciudades
    public List<String> rutaMasCortaBFS(String inicio, String destino) {
        if (!adyacencias.containsKey(inicio) || !adyacencias.containsKey(destino)) {
            System.out.println("Error: alguna de las ciudades no existe.");
            return null;
        }

        Queue<String> cola = new LinkedList<>();
        Map<String, String> predecesor = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        cola.offer(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(destino)) {
                // Reconstruir la ruta
                List<String> ruta = new ArrayList<>();
                for (String ciudad = destino; ciudad != null; ciudad = predecesor.get(ciudad)) {
                    ruta.add(ciudad);
                }
                Collections.reverse(ruta);
                return ruta;
            }

            for (String vecino : adyacencias.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    predecesor.put(vecino, actual);
                    cola.offer(vecino);
                }
            }
        }
        return null; // No se encontró ruta
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafos mapa = new Grafos ();
        String comando;

        System.out.println("--- MODELADO DE MAPA Y RUTAS ---");
        System.out.println("Comandos: [Agregar], [Conectar], [Ruta], [Salir]");

        while (true) {
            System.out.print("\n¿Qué quieres hacer? (Agregar/Conectar/Ruta/Salir): ");
            comando = scanner.nextLine().toLowerCase();

            if (comando.equals("agregar")) {
                System.out.print("Nombre de la ciudad (Vértice): ");
                String ciudad = scanner.nextLine();
                mapa.agregarVertice(ciudad);
                System.out.println("✅ Ciudad '" + ciudad + "' agregada.");

            } else if (comando.equals("conectar")) {
                System.out.print("Ciudad de inicio (V1): ");
                String v1 = scanner.nextLine();
                System.out.print("Ciudad de destino (V2): ");
                String v2 = scanner.nextLine();
                mapa.agregarArista(v1, v2);
                System.out.println("✅ Conexión bidireccional entre '" + v1 + "' y '" + v2 + "' creada.");

            } else if (comando.equals("ruta")) {
                System.out.print("Ruta de inicio: ");
                String inicio = scanner.nextLine();
                System.out.print("Ruta de destino: ");
                String destino = scanner.nextLine();

                List<String> ruta = mapa.rutaMasCortaBFS(inicio, destino);
                if (ruta != null) {
                    System.out.println("Ruta encontrada:");
                    System.out.println(String.join(" -> ", ruta));
                } else {
                    System.out.println("No existe una ruta entre '" + inicio + "' y '" + destino + "'.");
                }

            } else if (comando.equals("salir")) {
                System.out.println("Adiós.");
                break;

            } else {
                System.out.println("⚠️ Comando no reconocido.");
            }
        }

        scanner.close();
    }
}
