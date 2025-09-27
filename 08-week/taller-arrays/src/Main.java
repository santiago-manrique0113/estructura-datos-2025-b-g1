import java.util.ArrayList;
import java.util.Scanner;
import Class.Circulo;
import Class.Rectangulo;
import Class.Triangulo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> figuras = new ArrayList<>();

        boolean control = true;

        while (control) {
            System.out.println("MENÚ DE FIGURAS");
            System.out.println("1.Agregar Círculo");
            System.out.println("2.Agregar Rectángulo");
            System.out.println("3.Agregar Triángulo");
            System.out.println("4.Mostrar todas las figuras");
            System.out.println("5.Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Circulo c = new Circulo();
                    double radio;
                    String colorC;
                    System.out.print("Radio: ");
                    radio = scanner.nextDouble();
                    c.setRadio(radio);
                    System.out.print("Color: ");
                    colorC = scanner.next();
                    c.setColor(colorC);
                    figuras.add(c);
                    break;

                case 2:
                    Rectangulo r = new Rectangulo();
                    double base, altura;
                    String colorR;
                    System.out.print("Base: ");
                    base = scanner.nextDouble();
                    r.setBase(base);
                    System.out.print("Altura: ");
                    altura = scanner.nextDouble();
                    r.setAltura(altura);
                    System.out.print("Color: ");
                    colorR = scanner.next();
                    r.setColor(colorR);
                    figuras.add(r);
                    break;

                case 3:
                    Triangulo t = new Triangulo();
                    double lado1,lado2,lado3;
                    String colorT;
                    System.out.print("Lado 1: ");
                    lado1 = scanner.nextDouble();
                    t.setLado1(lado1);
                    System.out.print("Lado 2: ");
                    lado2 = scanner.nextDouble();
                    t.setLado2(lado2);
                    System.out.print("Lado 3: ");
                    lado3 = scanner.nextDouble();
                    t.setLado3(lado3);
                    System.out.print("Color: ");
                    colorT = scanner.next();
                    t.setColor(colorT);
                    figuras.add(t);
                    break;

                case 4:
                    for (Object f : figuras) {
                        if (f instanceof Circulo) {
                            System.out.println(((Circulo) f).DatoCirculo());
                        } else if (f instanceof Rectangulo) {
                            System.out.println(((Rectangulo) f).DatoRectangulo());
                        } else if (f instanceof Triangulo) {
                            System.out.println(((Triangulo) f).DatoTriangulo());
                        }
                    }
                    break;

                case 5:
                    control = false;
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
