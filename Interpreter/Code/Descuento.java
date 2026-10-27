package Interpreter.Code;

public class Descuento implements Expresion {

    private Expresion precio;
    private double porcentaje;

    public Descuento(Expresion precio, double porcentaje) {
        this.precio = precio;
        this.porcentaje = porcentaje;
    }

    @Override
    public int interpretar() {
        return (int) (precio.interpretar() * (1 - porcentaje / 100));
    }
}