package Class;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String color;

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public String DatoTriangulo() {
        return "Triángulo - Lados: " + getLado1() + ", " + getLado2() + ", " + getLado3() +
                " -Color: " + getColor() +
                " -Área: " + calcularArea() +
                " -Perímetro: " + calcularPerimetro();
    }
}
