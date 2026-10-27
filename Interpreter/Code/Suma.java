package Interpreter.Code;

public class Suma implements Expresion {

    private Expresion izquierda;
    private Expresion derecha;

    public Suma(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public int interpretar() {
        return izquierda.interpretar() + derecha.interpretar();
    }
}