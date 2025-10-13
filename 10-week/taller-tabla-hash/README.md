# Taller: Implementación básica de una Tabla Hash genérica `<K, V>`

##  Propósito
Comprender el funcionamiento interno de una **tabla hash**, su estructura, la función de dispersión (hash) y el manejo de colisiones mediante **encadenamiento**.

---

##  Implementación

Se desarrolló una clase genérica:

```java
public class HashTable<K, V>

con las operaciones básicas:

put(K key, V value) → Inserta o actualiza un valor.

get(K key) → Obtiene el valor asociado a una clave.

remove(K key) → Elimina una clave y su valor.

containsKey(K key) → Verifica si la clave existe.

size() → Retorna la cantidad de elementos.

isEmpty() → Verifica si la tabla está vacía.

Cada posición del arreglo puede contener una lista enlazada de entradas (Entry), lo cual permite resolver colisiones.

``` 
---
## Ejercicios desarrollados

1. Diccionario (usuario → rol)
Permite agregar, consultar y eliminar usuarios y sus roles.

2. Contador de palabras
El usuario escribe un texto y el programa cuenta cuántas veces se repite cada palabra.

3. Colisiones controladas
Permite ingresar claves numéricas para observar cómo se manejan las colisiones.

4. Prueba de tamaño
Muestra el uso de size(), isEmpty() y remove() de forma interactiva.

---

## Resultados observados

1. Las operaciones put() y get() funcionan correctamente y devuelven los valores esperados.

2. Cuando dos claves generan el mismo índice hash, ambas se almacenan mediante encadenamiento.

3. remove() elimina correctamente las claves sin afectar otras.

4. size() refleja los cambios de manera precisa.

--- 
## Conclusión

La tabla hash es una estructura muy eficiente para almacenar y buscar datos mediante claves.
Gracias al uso de una función hash y al encadenamiento, se puede mantener un tiempo de acceso promedio constante O(1) para las operaciones principales.