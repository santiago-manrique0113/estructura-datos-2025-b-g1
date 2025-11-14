import java.util.Scanner;

public class Ejercicioo2 {
    public static void main(String[] args) {

        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.println("Mapa de Ciudades");

        System.out.print("¿Cuántas conexiones quiere ingresar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Conexión " + (i+1) + " (ciudad1 ciudad2): ");
            String c1 = sc.next();
            String c2 = sc.next();
            g.addEdge(c1, c2);
        }

        System.out.print("Ciudad inicial: ");
        String inicio = sc.next();

        System.out.println("Recorrido BFS:");
        System.out.println(g.bfs(inicio));
    }
}
