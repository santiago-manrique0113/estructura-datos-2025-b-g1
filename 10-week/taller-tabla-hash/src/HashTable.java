// HashTable.java
public class HashTable<K, V> {
    // Clase interna para pares clave-valor
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<K, V>[] tabla;
    private int capacidad = 10; // tamaño fijo
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        tabla = new Entry[capacidad];
    }

    // Función hash sencilla
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacidad);
    }

    // Insertar o actualizar
    public void put(K key, V value) {
        int indice = hash(key);
        Entry<K, V> actual = tabla[indice];

        // Si ya existe la clave, se actualiza
        while (actual != null) {
            if (actual.key.equals(key)) {
                actual.value = value;
                return;
            }
            actual = actual.next;
        }

        // Si no existe, se inserta al inicio de la lista
        Entry<K, V> nuevo = new Entry<>(key, value);
        nuevo.next = tabla[indice];
        tabla[indice] = nuevo;
        size++;
    }

    // Obtener valor por clave
    public V get(K key) {
        int indice = hash(key);
        Entry<K, V> actual = tabla[indice];

        while (actual != null) {
            if (actual.key.equals(key)) {
                return actual.value;
            }
            actual = actual.next;
        }
        return null;
    }

    // Eliminar valor por clave
    public void remove(K key) {
        int indice = hash(key);
        Entry<K, V> actual = tabla[indice];
        Entry<K, V> anterior = null;

        while (actual != null) {
            if (actual.key.equals(key)) {
                if (anterior == null) {
                    tabla[indice] = actual.next;
                } else {
                    anterior.next = actual.next;
                }
                size--;
                return;
            }
            anterior = actual;
            actual = actual.next;
        }
    }

    // Saber si existe una clave
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Cantidad de elementos
    public int size() {
        return size;
    }

    // Saber si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Mostrar contenido (solo para probar)
    public void mostrarTodo() {
        System.out.println("\nContenido de la tabla:");
        for (int i = 0; i < capacidad; i++) {
            Entry<K, V> actual = tabla[i];
            while (actual != null) {
                System.out.println(actual.key + " → " + actual.value);
                actual = actual.next;
            }
        }
    }
}
