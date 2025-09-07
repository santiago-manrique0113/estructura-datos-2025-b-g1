# Sistema de Biblioteca (parcial1.java)

## Descripción 
El sistema implementa una biblioteca básica en Java que permite:  
- Alta y baja lógica de libros.  
- Listar el catálogo con disponibilidad por sucursal.  
- Buscar libros por título o código.  
- Prestar y devolver libros en distintas sucursales.  
- Registrar un historial de operaciones (altas, bajas, préstamos y devoluciones).  

Se usan estructuras de datos fundamentales vistas en clase: arrays, matrices 2D, listas enlazadas simples y listas doblemente enlazadas.

---

## Razones de elección de cada estructura y complejidad

- **Array unidimensional (`Libro[] catalogo`)**  
  Se utiliza para almacenar el catálogo de libros porque es un conjunto de tamaño fijo y de acceso directo por índice.  
  - Inserción de libro → O(1)  
  - Búsqueda por código (lineal) → O(n)  

- **Matriz 2D (`int[][] disponibilidad`)**  
  Permite llevar el registro de ejemplares en diferentes sucursales (filas = libros, columnas = sucursales).  
  - Actualización de stock → O(1)  
  - Consulta de disponibilidad → O(1)  

- **Lista enlazada simple (`NodoPrestamo`)**  
  Se usa para registrar préstamos activos, ya que permite insertar y eliminar nodos dinámicamente.  
  - Inserción de préstamo (al inicio) → O(1)  
  - Búsqueda/eliminación de préstamo → O(n)  

- **Lista doblemente enlazada (`NodoHistorial`)**  
  Se emplea para mantener un historial de operaciones que puede recorrerse en ambos sentidos.  
  - Inserción en cola → O(1)  
  - Recorrido adelante o atrás → O(n)  

---

