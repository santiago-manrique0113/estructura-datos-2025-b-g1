# Taller Estructura de Datos – TechMarket

---
##  Autor

**Nombre:** Santiago Manrique Gonzalez   
**Materia:** Estructura de Datos  
**Lenguaje:** Java   
**Fecha:** 11 Octubre de 2025

---
##  Descripción del proyecto

Este proyecto en Java implementa un sistema de gestión de productos para una tienda de tecnología llamada **TechMarket**.  
El programa permite al usuario agregar, listar, eliminar y visualizar productos categorizados, utilizando estructuras de datos como **ArrayList** y **Vector**, además de ciclos y validaciones para controlar el flujo del programa.

El sistema fue diseñado para demostrar el uso práctico de **estructuras dinámicas y estáticas** en la programación orientada a objetos, aplicando conceptos fundamentales de la materia **Estructura de Datos**.

---



##  Estructuras de datos utilizadas

### 1. ArrayList
Se utilizó un **ArrayList** para almacenar los productos registrados en el sistema.  
Esta estructura es dinámica, lo que permite agregar o eliminar elementos sin definir un tamaño fijo.  
Gracias a esto, el programa puede manejar una cantidad variable de productos durante la ejecución.

```java
ArrayList<Producto> productos = new ArrayList<>();

``` 
Uso en el programa:

Agregar nuevos productos (productos.add(...))  
Listar los productos registrados (for (Producto p : productos))  
Eliminar productos existentes (productos.removeIf(...))

### 2. Vector (Array)

Se utilizó un vector de tipo String para definir las categorías fijas de productos disponibles en la tienda. Esta estructura tiene tamaño fijo y se emplea para ofrecer al usuario una lista de opciones predefinidas.
```java
String[] categorias = {"Computadores", "Celulares", "Periféricos", "Audio", "Accesorios"};
``` 
Uso en el programa:

Mostrar las categorías disponibles.
Asignar una categoría al producto durante el registro.

### 3. Ciclos o estructuras de repetición

El programa hace uso de estructuras de control repetitivas como do-while y for para mantener el menú activo y recorrer las estructuras de datos.

Ejemplos:
```java
do {
    // Menú principal
} while (opcion != 0);

for (String cat : categorias) {
    System.out.println(cat);
}
```  

Uso en el programa:

El ciclo do-while mantiene activo el menú principal.  
Los ciclos for y for-each recorren el vector y el ArrayList para mostrar información al usuario.

--- 

## Ejemplo en consola 
```java
- MENÚ DE TECHMARKET -
1. Agregar producto
2. Listar productos
3. Eliminar producto
4. Mostrar categorías
0. Salir
   Seleccione una opción: 1
   Ingrese el nombre del producto: Teclado  
   Ingrese la cantidad: 5

Seleccione la categoría del producto:
1. Computadores
2. Celulares
3. Periféricos
4. Audio
5. Accesorios
   Ingrese el número de la categoría: 3  
   Producto agregado correctamente.

--- MENÚ DE TECHMARKET ---
2. Listar productos
   Lista de productos registrados:
- Teclado | Cantidad: 5 | Categoría: Periféricos
```

---
## Validaciones implementadas

1.No permitir campos vacíos.

2.Validar que la cantidad sea un número entero positivo.

3.Verificar existencia del producto antes de eliminarlo.

4.Controlar opciones inválidas del menú.

---
## Estructura del proyecto
```java
TallerEstructuraDatos/

├── src/

│   └── TallerEstructuraDatos.java

├── README.md

└── evidencia_video.txt  (enlace al video explicativo)
```
---
## Link del video 

En este video se muestra la ejecución del programa, explicación del código y resultados obtenidos:
https://drive.google.com/file/d/1F5cX6jUOqKmpBFiY_wf31QyEqolB18Ma/view?usp=sharing

---
## Conclusión


Este proyecto permitió aplicar conceptos fundamentales de las estructuras de datos en Java, como listas dinámicas y vectores, para construir un sistema de gestión de productos funcional y validado. A través del ejercicio, se reforzó la comprensión del uso de ArrayList, arrays y ciclos, junto con el manejo de entradas y validaciones en consola.