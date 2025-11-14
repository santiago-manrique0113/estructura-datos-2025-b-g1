import java.util.*;

public class Ejercicioo4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();

        System.out.println("Comparación BFS y DFS");

        // El usuario agrega conexiones
        System.out.print("¿Cuántas aristas quiere ingresar?: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Arista " + (i+1) + " (nodo1 nodo2): ");
            String a = sc.next();
            String b = sc.next();
            g.addEdge(a, b);
        }

        // Nodo inicial
        System.out.print("Nodo inicial: ");
        String inicio = sc.next();

        // BFS
        System.out.println("\nRecorrido BFS:");
        System.out.println(g.bfs(inicio));

        // DFS
        System.out.println("\nRecorrido DFS:");
        DFS dfs = new DFS(g.getAdj());
        dfs.dfs(inicio);

        System.out.println();
    }
}
