import java.util.*;

public class DFS {
    private HashSet<String> visitados = new HashSet<>();
    private HashMap<String, ArrayList<String>> adj;

    public DFS(HashMap<String, ArrayList<String>> adj) {
        this.adj = adj;
    }

    public void dfs(String nodo) {
        if (visitados.contains(nodo)) return;

        visitados.add(nodo);
        System.out.print(nodo + " ");

        for (String vecino : adj.get(nodo)) {
            dfs(vecino);
        }
    }
}
