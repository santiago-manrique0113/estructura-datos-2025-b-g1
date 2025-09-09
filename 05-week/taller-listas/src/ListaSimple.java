// Clase ListaSimple
public class ListaSimple {
    Nodo cabeza; // primer nodo de la lista

    // Insertar al inicio
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Insertar en una posición específica
    public void insertarEnPosicion(int valor, int pos) {
        Nodo nuevo = new Nodo(valor);

        // Si la posición es 0, lo insertamos al inicio
        if (pos == 0) {
            insertarInicio(valor);
            return;
        }

        Nodo temp = cabeza;
        int contador = 0;

        // Recorremos hasta la posición anterior
        while (temp != null && contador < pos - 1) {
            temp = temp.siguiente;
            contador++;
        }

        if (temp == null) {
            System.out.println("Posición inválida");
        } else {
            nuevo.siguiente = temp.siguiente;
            temp.siguiente = nuevo;
        }
    }

    // Eliminar en una posición específica
    public void eliminarEnPosicion(int pos) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        // Si eliminamos la cabeza
        if (pos == 0) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo temp = cabeza;
        int contador = 0;

        // Recorremos hasta llegar al nodo anterior
        while (temp != null && contador < pos - 1) {
            temp = temp.siguiente;
            contador++;
        }

        // Si no existe la posición
        if (temp == null || temp.siguiente == null) {
            System.out.println("Posición inválida");
        } else {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    // Mostrar la lista
    public void mostrar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}
