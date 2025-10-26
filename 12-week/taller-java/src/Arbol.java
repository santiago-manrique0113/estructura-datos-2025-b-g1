class NodoBinario {
    int valor;
    NodoBinario izq, der;

    NodoBinario(int valor) {
        this.valor = valor;
    }
}

public class Arbol {
    NodoBinario raiz;

    void crearEjemplo() {
        raiz = new NodoBinario(10);
        raiz.izq = new NodoBinario(5);
        raiz.der = new NodoBinario(15);
        raiz.izq.izq = new NodoBinario(3);
        raiz.izq.der = new NodoBinario(7);
    }

    void inorden(NodoBinario nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            System.out.print(nodo.valor + " ");
            inorden(nodo.der);
        }
    }

    void preorden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }

    void postorden(NodoBinario nodo) {
        if (nodo != null) {
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.crearEjemplo();

        System.out.println("Recorrido Inorden:");
        arbol.inorden(arbol.raiz);
        System.out.println("\nRecorrido Preorden:");
        arbol.preorden(arbol.raiz);
        System.out.println("\nRecorrido Postorden:");
        arbol.postorden(arbol.raiz);
    }
}
