package Class;

public class Circulo {
    private double radio;
    private String color;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calcularArea() {
        return 3.1416 * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * 3.1416 * radio;
    }

    public String DatoCirculo() {
        return "Círculo -Radio: " + getRadio() +
                " -Color: " + getColor() +
                " -Área: " + calcularArea() +
                " -Perímetro: " + calcularPerimetro();
    }
}
