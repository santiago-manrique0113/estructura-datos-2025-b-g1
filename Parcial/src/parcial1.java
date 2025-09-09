
//VIDEO SUSTENTACION
//https://drive.google.com/file/d/19zlomEztmhOAQuIQq267k89Gvt2QvACC/view?usp=drive_link
import java.time.LocalDate;
import java.util.Scanner;

public class parcial1 {


    // ESTRUCTURAS PRINCIPALES
    // Clase que guarda la información de un libro
    static class Libro {
        int codigo;
        String titulo;
        String autor;
        int stock;
        boolean activo = true;

        Libro(int codigo, String titulo, String autor, int stock) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.autor = autor;
            this.stock = stock;
        }
    }

    // Clase que representa un préstamo (libro prestado a un usuario)
    static class NodoPrestamo {
        int codigoLibro;
        String usuario;
        LocalDate fecha;
        boolean devuelto;
        NodoPrestamo siguiente;

        NodoPrestamo(int codigoLibro, String usuario) {
            this.codigoLibro = codigoLibro;
            this.usuario = usuario;
            this.fecha = LocalDate.now();
            this.devuelto = false;
        }
    }

    // Clase que guarda el historial de operaciones (altas, bajas, préstamos, devoluciones)
    static class NodoHistorial {
        String tipoOperacion;
        LocalDate fecha;
        NodoHistorial anterior;
        NodoHistorial siguiente;

        NodoHistorial(String tipoOperacion) {
            this.tipoOperacion = tipoOperacion;
            this.fecha = LocalDate.now();
        }
    }

    // VARIABLES GLOBALES

    static final int MAX_LIBROS = 50;
    static final int SUCURSALES = 3;

    static Libro[] catalogo = new Libro[MAX_LIBROS]; // arreglo de libros
    static int totalLibros = 0; // contador de libros registrados

    static int[][] disponibilidad = new int[MAX_LIBROS][SUCURSALES];

    static NodoPrestamo prestamos = null;
    static NodoHistorial historial = null;
    static NodoHistorial ultimoHistorial = null;

    static Scanner leer = new Scanner(System.in);

    // MÉTODOS DE CATÁLOGO

    // Da de alta un libro (lo agrega al catálogo)
    static void altaLibro() {
        if (totalLibros >= MAX_LIBROS) {
            System.out.println("Catálogo lleno.");
            return;
        }

        int codigo = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Código: ");
            try {
                codigo = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        if (buscarLibroPorCodigo(codigo) != -1) {
            System.out.println("Ya existe ese código.");
            return;
        }

        System.out.print("Título: ");
        String titulo = leer.nextLine();
        System.out.print("Autor: ");
        String autor = leer.nextLine();

        int stock = -1;
        valido = false;
        while (!valido) {
            System.out.print("Stock total: ");
            try {
                stock = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        Libro libroNuevo = new Libro(codigo, titulo, autor, stock);
        catalogo[totalLibros] = libroNuevo;

        int sucursal = -1;
        valido = false;
        while (!valido) {
            System.out.print("Sucursal (0-" + (SUCURSALES - 1) + "): ");
            try {
                sucursal = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        if (sucursal < 0 || sucursal >= SUCURSALES) {
            System.out.println("Sucursal inválida. Se guardará en la sucursal 0 por defecto.");
            sucursal = 0;
        }
        disponibilidad[totalLibros][sucursal] = stock;

        totalLibros++;
        agregarHistorial("ALTA");
        System.out.println("Libro agregado.");
    }

    // Da de baja un libro (lo marca como inactivo)
    static void bajaLibro() {
        int codigo = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Código a eliminar: ");
            try {
                codigo = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        int posicion = buscarLibroPorCodigo(codigo);
        if (posicion == -1) {
            System.out.println("No encontrado.");
            return;
        }
        catalogo[posicion].activo = false;
        agregarHistorial("BAJA");
        System.out.println("Libro dado de baja.");
    }

    // Lista todos los libros activos
    static void listarCatalogo() {
        System.out.println("CATÁLOGO:");
        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i].activo) {
                System.out.print(
                        catalogo[i].codigo + " - " +
                                catalogo[i].titulo + " (" +
                                catalogo[i].stock + ") | Disponibilidad: "
                );
                for (int j = 0; j < SUCURSALES; j++) {
                    System.out.print("Sucursal" + j + "=" + disponibilidad[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    // Busca libro por código
    static int buscarLibroPorCodigo(int codigo) {
        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i].codigo == codigo && catalogo[i].activo) return i;
        }
        return -1;
    }

    // Busca libro por título
    static void buscarPorTitulo() {
        System.out.print("Título: ");
        String tituloBuscado = leer.nextLine();
        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i].activo && compararTitulos(catalogo[i].titulo, tituloBuscado)) {
                System.out.println("Encontrado: " + catalogo[i].codigo + " - " + catalogo[i].titulo);
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    // Compara dos títulos (ignora mayúsculas/minúsculas)
    static boolean compararTitulos(String titulo1, String titulo2) {
        if (titulo1.length() != titulo2.length()) return false;
        for (int i = 0; i < titulo1.length(); i++) {
            char caracter1 = Character.toLowerCase(titulo1.charAt(i));
            char caracter2 = Character.toLowerCase(titulo2.charAt(i));
            if (caracter1 != caracter2) return false;
        }
        return true;
    }

    // MÉTODOS DE PRÉSTAMOS
    // Registra un préstamo de libro
    static void prestarLibro() {
        int codigo = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Código libro: ");
            try {
                codigo = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        int posicion = buscarLibroPorCodigo(codigo);
        if (posicion == -1) {
            System.out.println("No existe.");
            return;
        }
        if (catalogo[posicion].stock <= 0) {
            System.out.println("Sin stock.");
            return;
        }

        int sucursal = -1;
        valido = false;
        while (!valido) {
            System.out.print("Sucursal (0-" + (SUCURSALES - 1) + "): ");
            try {
                sucursal = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        if (sucursal < 0 || sucursal >= SUCURSALES) {
            System.out.println("Sucursal inválida.");
            return;
        }
        if (disponibilidad[posicion][sucursal] <= 0) {
            System.out.println("No hay ejemplares en esa sucursal.");
            return;
        }

        System.out.print("Usuario: ");
        String usuario = leer.nextLine();
        NodoPrestamo nuevoPrestamo = new NodoPrestamo(codigo, usuario);
        nuevoPrestamo.siguiente = prestamos;
        prestamos = nuevoPrestamo;

        catalogo[posicion].stock--;
        disponibilidad[posicion][sucursal]--;
        agregarHistorial("PRESTAMO");
        System.out.println("Préstamo registrado.");
    }

    // Registra la devolución de un libro
    static void devolverLibro() {
        int codigo = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Código libro a devolver: ");
            try {
                codigo = leer.nextInt();
                leer.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                leer.nextLine();
            }
        }

        NodoPrestamo anterior = null;
        NodoPrestamo actual = prestamos;
        while (actual != null) {
            if (actual.codigoLibro == codigo && !actual.devuelto) {
                actual.devuelto = true;
                int posicion = buscarLibroPorCodigo(codigo);
                if (posicion != -1) {
                    catalogo[posicion].stock++;

                    int sucursal = -1;
                    valido = false;
                    while (!valido) {
                        System.out.print("Sucursal de devolución (0-" + (SUCURSALES - 1) + "): ");
                        try {
                            sucursal = leer.nextInt();
                            leer.nextLine();
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Error: debe ingresar un número entero.");
                            leer.nextLine();
                        }
                    }

                    if (sucursal < 0 || sucursal >= SUCURSALES) {
                        System.out.println("Sucursal inválida. Se devolverá en la sucursal 0 por defecto.");
                        sucursal = 0;
                    }
                    disponibilidad[posicion][sucursal]++;
                }
                if (anterior == null) prestamos = actual.siguiente;
                else anterior.siguiente = actual.siguiente;
                agregarHistorial("DEVOLUCION");
                System.out.println("Libro devuelto.");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        System.out.println("Préstamo no encontrado.");
    }

    // Lista todos los préstamos activos
    static void listarPrestamos() {
        System.out.println("PRÉSTAMOS ACTIVOS:");
        NodoPrestamo aux = prestamos;
        while (aux != null) {
            if (!aux.devuelto) {
                System.out.println(aux.codigoLibro + " - " + aux.usuario + " (" + aux.fecha + ")");
            }
            aux = aux.siguiente;
        }
    }


    // MÉTODOS DE HISTORIAL
    // Agrega una operación al historial
    static void agregarHistorial(String tipoOperacion) {
        NodoHistorial nuevoHistorial = new NodoHistorial(tipoOperacion);
        if (historial == null) {
            historial = nuevoHistorial;
            ultimoHistorial = nuevoHistorial;
        } else {
            ultimoHistorial.siguiente = nuevoHistorial;
            nuevoHistorial.anterior = ultimoHistorial;
            ultimoHistorial = nuevoHistorial;
        }
    }

    // Lista historial desde el inicio hacia adelante
    static void listarHistorialAdelante() {
        NodoHistorial aux = historial;
        while (aux != null) {
            System.out.println(aux.tipoOperacion + " - " + aux.fecha);
            aux = aux.siguiente;
        }
    }

    // Lista historial desde el final hacia atrás
    static void listarHistorialAtras() {
        NodoHistorial aux = ultimoHistorial;
        while (aux != null) {
            System.out.println(aux.tipoOperacion + " - " + aux.fecha);
            aux = aux.anterior;
        }
    }

    // MENÚ PRINCIPAL
    // Aquí se muestra el menú principal y se llaman las funciones según la opción
    public static void main(String[] args) {
        int opcion = -1;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Alta libro");
            System.out.println("2. Baja libro");
            System.out.println("3. Listar catálogo");
            System.out.println("4. Buscar por título");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Listar préstamos");
            System.out.println("8. Historial adelante");
            System.out.println("9. Historial atrás");
            System.out.println("0. Salir");

            boolean valido = false;
            while (!valido) {
                System.out.print("Opción: ");
                try {
                    opcion = leer.nextInt();
                    leer.nextLine();
                    valido = true;
                } catch (Exception e) {
                    System.out.println("Error: debe ingresar un número entero.");
                    leer.nextLine();
                }
            }

            switch (opcion) {
                case 1: altaLibro();
                break;
                case 2: bajaLibro();
                break;
                case 3: listarCatalogo();
                break;
                case 4: buscarPorTitulo();
                break;
                case 5: prestarLibro();
                break;
                case 6: devolverLibro();
                break;
                case 7: listarPrestamos();
                break;
                case 8: listarHistorialAdelante();
                break;
                case 9: listarHistorialAtras();
                break;
                case 0: System.out.println("Hasta pronto!");
                break;
                default: System.out.println("La opción es inválida.");
            }
        } while (opcion != 0);
    }
}
