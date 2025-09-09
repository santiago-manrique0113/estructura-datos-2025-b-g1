// Nodo doble: tiene referencia al anterior y siguiente
class NodoDoble {
    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int d) {
        dato = d;
        siguiente = null;
        anterior = null;
    }
}

// Lista doblemente enlazada
public class ListaDoble {
    NodoDoble cabeza;

    // Insertar al final
    public void insertarFinal(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoDoble temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
        }
    }

    // Eliminar al inicio
    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        cabeza = cabeza.siguiente;
        if (cabeza != null) {
            cabeza.anterior = null;
        }
    }

    // Eliminar al final
    public void eliminarFinal() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }
        NodoDoble temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.anterior.siguiente = null;
    }

    // Mostrar lista
    public void mostrar() {
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}
