import java.util.Scanner;

public class Ejercicioo1 {

    public static void main(String[] args) {

        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.println("Red Social Simple");

        //Entrada de datos
        System.out.print("¿Cuántas amistades quiere ingresar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Amistad " + (i+1) + " (formato: persona1 persona2): ");
            String p1 = sc.next();
            String p2 = sc.next();
            g.addEdge(p1, p2);
        }

        System.out.print("Usuario desde donde iniciar BFS: ");
        String inicio = sc.next();

        //Salida
        System.out.println("Recorrido BFS:");
        System.out.println(g.bfs(inicio));
    }
}
