# Taller de Listas Enlazadas

Este proyecto contiene la implementación de diferentes tipos de listas enlazadas en Java.  
Cada ejercicio muestra cómo funcionan y permite probar las operaciones más importantes.

---

## Ejercicio 1 — Lista simple básica
- **Qué hace:** Permite insertar elementos al final de una lista y mostrarlos.
- **Operaciones:**
    - Insertar al final
    - Mostrar lista
- **Complejidad:**
    - Insertar al final → O(n) porque hay que recorrer hasta el último nodo.
    - Mostrar → O(n) porque hay que recorrer toda la lista.

---

## Ejercicio 2 — Inserción en cualquier posición
- **Qué hace:** Permite insertar elementos en una posición indicada por el usuario.
- **Operaciones:**
    - Insertar en una posición específica
    - Mostrar lista
- **Complejidad:**
    - Insertar en posición → O(n) porque hay que recorrer hasta llegar.
    - Mostrar → O(n).

---

## Ejercicio 3 — Eliminación en posición
- **Qué hace:** Permite eliminar un elemento en la posición indicada.
- **Operaciones:**
    - Insertar al final
    - Eliminar en posición
    - Mostrar lista
- **Complejidad:**
    - Eliminar en posición → O(n) porque hay que recorrer hasta llegar.
    - Insertar al final → O(n).
    - Mostrar → O(n).

---

## Ejercicio 4 — Lista doblemente enlazada
- **Qué hace:** Implementa una lista donde cada nodo conoce a su anterior y a su siguiente.
- **Operaciones:**
    - Insertar al final
    - Eliminar al inicio
    - Eliminar al final
    - Mostrar lista
- **Complejidad:**
    - Insertar al final → O(1) si se guarda el puntero al último nodo.
    - Eliminar al inicio → O(1).
    - Eliminar al final → O(1) si hay puntero al último, si no O(n).
    - Mostrar → O(n).

---

## Ejercicio 5 — Lista circular
- **Qué hace:** Implementa una lista donde el último nodo apunta de nuevo al primero.
- **Operaciones:**
    - Insertar
    - Eliminar por valor
    - Mostrar lista
- **Complejidad:**
    - Insertar → O(n) porque se recorre hasta el final.
    - Eliminar valor → O(n) porque hay que buscarlo.
    - Mostrar → O(n).

---

## Ejercicio 6 — Lista de espera en consultorio
- **Qué hace:** Simula la cola de pacientes en un consultorio médico.
- **Operaciones:**
    - Ingresar paciente (se añade al final de la cola)
    - Atender paciente (se elimina al inicio)
    - Mostrar la cola de pacientes
- **Complejidad:**
    - Ingresar paciente → O(1) porque se añade al final directo.
    - Atender paciente → O(1) porque se elimina al inicio.
    - Mostrar cola → O(n).

---

