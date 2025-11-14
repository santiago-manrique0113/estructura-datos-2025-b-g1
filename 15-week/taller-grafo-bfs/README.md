# Taller: Construcción de un Grafo y Recorrido BFS

Este proyecto implementa un grafo usando una lista de adyacencia y el algoritmo Breadth-First Search (BFS).  
El objetivo es comprender cómo funcionan los grafos, cómo se representan y cómo recorrerlos utilizando una cola.

---

## Contenido del proyecto
```
taller-grafo-bfs/
├─ src/
│ ├─ Graph.java
│ ├─ BFSExample.java
│ ├─ Ejercicio1.java … Ejercicio4.java
├─ README.md
├─ COMPLEJIDAD.md
└─ evidencias/
```
---

## 1. Implementación del Grafo

El grafo se implementó usando:

- `HashMap<String, ArrayList<String>>` para representar la lista de adyacencia.
- `addVertex(String v)` para agregar vértices.
- `addEdge(String v1, String v2)` para agregar aristas en un grafo no dirigido.
- `bfs(String start)` para realizar el recorrido BFS desde un nodo inicial utilizando una cola.

---

##  2. Implementación del BFS

El algoritmo BFS:

- Usa una cola `Queue` para almacenar los nodos por visitar.
- Usa un conjunto `HashSet` para evitar volver a visitar nodos ya recorridos.
- Visita los vecinos de cada nodo en orden de descubrimiento.
- Devuelve una lista con el orden final del recorrido.

---

## 3. Ejercicios incluidos

### ✔ Ejercicio 1: Red social simple
El usuario ingresa personas y amistades, luego ejecuta BFS desde un usuario inicial.

### ✔ Ejercicio 2: Mapa de ciudades
El usuario ingresa ciudades y sus conexiones, luego recorre desde una ciudad de origen.

### ✔ Ejercicio 3: Grafo no conexo
Permite observar cómo BFS solo recorre la componente conexa donde inicia.

### ✔ Ejercicio 4: Comparación BFS vs DFS
Se incluye una implementación sencilla de DFS y se comparan ambos recorridos.

---

## 4. Ejecución

Para compilar:


Para ejecutar un archivo, por ejemplo BFSExample:


---

## 5. Evidencias

El programa imprime:

- La lista de adyacencia.
- El recorrido BFS.
- En Ejercicio 4, también el recorrido DFS.

Estas salidas sirven como evidencia del funcionamiento del grafo y los recorridos.

---

## 6. Checklist del taller

- [x] Código modular
- [x] Implementación correcta de BFS
- [x] Manejo de visitados para evitar repeticiones
- [x] 4 ejercicios separados
- [x] README incluido
- [x] COMPLEJIDAD.md incluido
- [x] Evidencias de ejecución  
