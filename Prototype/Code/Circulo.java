// Prototipo Concreto A (El objeto con la lógica de clonación)
public class Circulo implements PrototipoForma {
    private int radio;
    private String color;

    // Constructor normal
    public Circulo(int radio, String color) {
        this.radio = radio;
        this.color = color;
    }

    // El objeto conoce su propia estructura y sabe cómo copiarse
    @Override
    public PrototipoForma clonar() {
        return new Circulo(this.radio, this.color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void dibujar() {
        System.out.println("Círculo [Radio: " + radio + ", Color: " + color + "]");
    }
}

