package Interpreter.Code;

public class Numero implements Expresion {

    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    @Override
    public int interpretar() {
        return valor;
    }
}
