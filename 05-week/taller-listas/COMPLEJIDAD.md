# Análisis de Complejidad


| Operación          | Lista simple       | Lista doble                  | Lista circular        |
|--------------------|--------------------|------------------------------|-----------------------|
| **Insertar inicio** | O(1)              | O(1)                         | O(1)                  |
| **Insertar fin**    | O(n)              | O(1) si hay puntero a último | O(n)                  |
| **Insertar posición** | O(n)            | O(n)                         | O(n)                  |
| **Eliminar inicio** | O(1)              | O(1)                         | O(1)                  |
| **Eliminar fin**    | O(n)              | O(1) si hay puntero a último | O(n)                  |
| **Eliminar posición** | O(n)            | O(n)                         | O(n)                  |
| **Recorrer lista**  | O(n)              | O(n)                         | O(n)                  |

---

## Explicación

- **O(1):** Nos quiere decir operación es rápida, no importa cuántos elementos tenga la lista.
- **O(n):** Nos quiere decir que hay recorrer la lista, y si tiene muchos elementos, se demora más.

Casos comunes:
- Insertar o eliminar **al inicio** es rápido (O(1)), solo cambiamos el primer nodo.
- Insertar o eliminar **al final** en lista simple o circular es más lento (O(n)) porque hay que recorrer hasta el último nodo.
- En **lista doble**, si tenemos un puntero al último nodo, eliminar o insertar al final puede ser rápido (O(1)).
- Insertar o eliminar en una **posición específica** siempre requiere recorrer (O(n)).
- **Recorrer toda la lista** siempre es O(n) porque hay que visitar todos los nodos.  
