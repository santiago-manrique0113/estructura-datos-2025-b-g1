package Class;

public class Rectangulo {
    private double base;
    private double altura;
    private String color;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public String DatoRectangulo() {
        return "Rectángulo -Base: " + getBase() +
                " -Altura: " + getAltura() +
                " -Color: " + getColor() +
                " -Área: " + calcularArea() +
                " -Perímetro: " + calcularPerimetro();
    }
}
