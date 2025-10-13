
---

##  **COMPLEJIDAD.md**

```markdown
# Complejidad de operaciones — Tabla Hash

| Operación      | Promedio | Peor caso | Descripción |
|----------------|-----------|-----------|--------------|
| **put()**      | O(1)     | O(n)      | Inserta o actualiza una clave. En promedio es constante, pero si todas las claves caen en el mismo índice, recorre la lista. |
| **get()**      | O(1)     | O(n)      | Busca una clave y devuelve su valor. En colisiones extremas, debe recorrer la lista. |
| **remove()**   | O(1)     | O(n)      | Elimina una clave. Puede recorrer la lista si hay colisiones. |
| **containsKey()** | O(1)  | O(n)      | Verifica si una clave existe (usa internamente `get()`). |
| **size()**     | O(1)     | O(1)      | Solo devuelve el contador de elementos. |
| **isEmpty()**  | O(1)     | O(1)      | Compara el tamaño con cero. |

---

##  Análisis general

- En condiciones normales (buena dispersión), las operaciones son muy rápidas (constantes).
- En el peor de los casos, si todas las claves caen en la misma posición, el rendimiento se degrada a O(n), ya que debe recorrer toda la lista de colisiones.
- La eficiencia depende directamente de la **función hash** y de la **distribución de las claves**.

---

**Conclusión:**  
La tabla hash logra un equilibrio entre velocidad y simplicidad, ofreciendo un acceso promedio **O(1)** para inserción, búsqueda y eliminación.
