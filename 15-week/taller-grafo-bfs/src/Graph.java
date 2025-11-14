import java.util.*;

public class Graph {

    // Guarda cada nodo y su lista de vecinos
    private HashMap<String, ArrayList<String>> adj = new HashMap<>();

    // Agregar un nodo
    public void addVertex(String v) {
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<>());
        }
    }

    // Agregar arista (conexión) entre dos nodos
    public void addEdge(String a, String b) {
        addVertex(a);
        addVertex(b);
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    // Recorrido BFS
    public ArrayList<String> bfs(String start) {

        ArrayList<String> orden = new ArrayList<>();

        if (!adj.containsKey(start)) {
            return orden;  // Si no existe, devolver vacío
        }

        Queue<String> cola = new LinkedList<>();
        HashSet<String> visitados = new HashSet<>();

        cola.add(start);
        visitados.add(start);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            orden.add(actual);

            for (String vecino : adj.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        return orden;
    }

    // Para poder imprimir la lista de adyacencia en ejemplos
    public HashMap<String, ArrayList<String>> getAdj() {
        return adj;
    }
}
