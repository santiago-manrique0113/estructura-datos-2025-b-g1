// Nodo circular: apunta a sí mismo si es el único
class NodoCircular {
    int dato;
    NodoCircular siguiente;

    public NodoCircular(int d) {
        dato = d;
        siguiente = this; // al inicio se apunta a sí mismo
    }
}

// Lista circular
public class ListaCircular {
    NodoCircular cabeza;

    // Insertar un valor
    public void insertar(int valor) {
        NodoCircular nuevo = new NodoCircular(valor);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCircular temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    // Eliminar un valor
    public void eliminar(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.dato == valor && cabeza.siguiente == cabeza) {
            cabeza = null;
            return;
        }

        NodoCircular temp = cabeza;
        NodoCircular prev = null;

        do {
            if (temp.dato == valor) {
                if (prev != null) {
                    prev.siguiente = temp.siguiente;
                } else {
                    NodoCircular ult = cabeza;
                    while (ult.siguiente != cabeza) {
                        ult = ult.siguiente;
                    }
                    cabeza = cabeza.siguiente;
                    ult.siguiente = cabeza;
                }
                return;
            }
            prev = temp;
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("Valor no encontrado");
    }

    // Mostrar lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        NodoCircular temp = cabeza;
        do {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(vuelve al inicio)");
    }
}
