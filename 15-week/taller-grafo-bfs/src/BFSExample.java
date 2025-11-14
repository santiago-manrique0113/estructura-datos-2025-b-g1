public class BFSExample {
    public static void main(String[] args) {
        // Crear grafo
        Graph g = new Graph();

        // Agregar vértices (opcional, addEdge crea vértices si no existen)
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");

        // Conectar vértices (grafo no dirigido)
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");

        // Mostrar la lista de adyacencia (evidencia sencilla)
        System.out.println("Lista de adyacencia:");
        for (String v : g.getAdj().keySet()) {
            System.out.println(v + " -> " + g.getAdj().get(v));
        }

        // Ejecutar BFS desde "A" y mostrar resultado
        System.out.println("\nRecorrido BFS desde A:");
        System.out.println(g.bfs("A"));  // Salida esperada: [A, B, C, D]
    }
}
