class NodoBST {
    int valor;
    NodoBST izq, der;

    NodoBST(int valor) {
        this.valor = valor;
    }
}

public class BST {
    NodoBST raiz;

    void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    NodoBST insertarRec(NodoBST nodo, int valor) {
        if (nodo == null) return new NodoBST(valor);

        if (valor < nodo.valor)
            nodo.izq = insertarRec(nodo.izq, valor);
        else if (valor > nodo.valor)
            nodo.der = insertarRec(nodo.der, valor);

        return nodo;
    }

    boolean buscar(NodoBST nodo, int valor) {
        if (nodo == null) return false;
        if (nodo.valor == valor) return true;

        if (valor < nodo.valor)
            return buscar(nodo.izq, valor);
        else
            return buscar(nodo.der, valor);
    }

    NodoBST eliminar(NodoBST nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.valor)
            nodo.izq = eliminar(nodo.izq, valor);
        else if (valor > nodo.valor)
            nodo.der = eliminar(nodo.der, valor);
        else {
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;
            System.out.println("Eliminando nodo con dos hijos (caso especial)");
        }
        return nodo;
    }

    public static void main(String[] args) {
        BST arbol = new BST ();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);

        System.out.println("¿Existe el valor 30?: " + arbol.buscar(arbol.raiz, 30));
        System.out.println("¿Existe el valor 99?: " + arbol.buscar(arbol.raiz, 99));

        arbol.raiz = arbol.eliminar(arbol.raiz, 30);
    }
}
