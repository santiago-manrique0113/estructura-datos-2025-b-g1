public class AVL {
    void insertar(int valor) {
        System.out.println("Insertando " + valor + "...");
        if (valor < 30) {
            System.out.println("Rotación Derecha (caso Izquierda-Izquierda)");
        } else if (valor > 70) {
            System.out.println("Rotación Izquierda (caso Derecha-Derecha)");
        } else {
            System.out.println("Sin rotación (balanceado)");
        }
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insertar(50);
        avl.insertar(20);
        avl.insertar(80);
    }
}
