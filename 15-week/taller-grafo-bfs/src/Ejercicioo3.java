import java.util.Scanner;

public class Ejercicioo3 {
    public static void main(String[] args) {

        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.println("Grafo No Conexo");

        System.out.print("¿Cuántas aristas quiere ingresar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Arista " + (i+1) + " (nodo1 nodo2): ");
            String a = sc.next();
            String b = sc.next();
            g.addEdge(a, b);
        }

        System.out.print("Nodo desde donde iniciar BFS: ");
        String inicio = sc.next();

        System.out.println("BFS:");
        System.out.println(g.bfs(inicio));
    }
}
