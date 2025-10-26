## 8. COMPLEJIDAD ALGORÍTMICA

La **complejidad algorítmica** mide el tiempo que tarda un algoritmo cuando aumentan los datos de entrada.  
Se expresa con la notación **Big O**, que representa cómo crece el tiempo o la memoria necesaria para ejecutar una operación.

### Notaciones más comunes
- **O(1):** tiempo constante (muy rápido, no depende de la cantidad de datos).
- **O(n):** tiempo lineal (a más datos, más tiempo).
- **O(log n):** tiempo logarítmico (crece lentamente, muy eficiente).

### Complejidad de las estructuras del taller

| Estructura | Operación principal | Complejidad | Explicación |
|-------------|---------------------|--------------|--------------|
| **Pila (Stack)** | Apilar / Desapilar | **O(1)** | Solo trabaja con el último elemento. |
| **Cola (Queue)** | Encolar / Desencolar | **O(1)** | Solo agrega o quita en los extremos. |
| **HashMap (Tabla Hash)** | Insertar / Buscar | **O(1)** promedio | Accede directamente usando una clave. |
| **Árbol Binario** | Recorridos (inorden, preorden, postorden) | **O(n)** | Visita todos los nodos una sola vez. |
| **Árbol AVL** | Insertar / Buscar / Eliminar | **O(log n)** | Mantiene el árbol balanceado automáticamente. |
| **BST (Árbol de Búsqueda)** | Insertar / Buscar / Eliminar | **O(log n)** promedio | Divide el árbol en mitades en cada búsqueda. |
| **Grafo (BFS)** | Buscar ruta | **O(V + E)** | Recorre los vértices (V) y las conexiones (E). |

### Conclusión
Las estructuras de datos permiten que los programas sean más rápidos y organizados.  
Algunas, como las **pilas** o las **tablas hash**, tienen operaciones muy rápidas (**O(1)**).  
Otras, como los **árboles** y los **grafos**, requieren recorrer más elementos, por eso su complejidad es mayor.  
Conocer la complejidad ayuda a elegir la mejor estructura para cada tipo de problema.
.