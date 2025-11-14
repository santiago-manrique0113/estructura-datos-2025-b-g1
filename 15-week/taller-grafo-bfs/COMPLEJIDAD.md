# Complejidad del Algoritmo BFS

El algoritmo Breadth-First Search (BFS) permite recorrer un grafo por niveles utilizando una cola.  
Su eficiencia depende del número de nodos y conexiones del grafo.

---

## Complejidad en tiempo

Durante la ejecución del BFS:

1. Cada vértice (V) se procesa una sola vez.
2. Cada arista (E) se revisa una vez cuando se exploran los vecinos.

Por lo tanto, la complejidad en tiempo es:

O(V + E)

---

## Complejidad en espacio

BFS utiliza:

- Una cola para manejar los nodos → O(V)
- Un conjunto de visitados → O(V)
- La lista de adyacencia del grafo → O(V + E)

La complejidad en espacio total es:

O(V + E)

---

## Conclusión

BFS es un algoritmo muy eficiente ya que recorre cada nodo y cada arista únicamente una vez.  
Es útil para encontrar caminos mínimos en grafos no ponderados y para recorrer niveles de forma ordenada.
