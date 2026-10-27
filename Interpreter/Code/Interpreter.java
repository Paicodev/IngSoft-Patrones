package Interpreter.Code;

public class Interpreter {

    public static void main(String[] args) {

        // Ejemplo 1: Suma
        Expresion expresion1 = new Suma(
            new Numero(5),
            new Numero(3)
        );

        Expresion expresion2 = new Suma(
            expresion1,
            new Numero(2)
        );

        System.out.println("Resultado de la suma: " + expresion1.interpretar());
        System.out.println("Resultado de la suma anidada: " + expresion2.interpretar());


        // Ejemplo 2: Descuento
        Expresion precio = new Numero(1000);

        Expresion precioConDescuento = new Descuento(precio, 10);

        System.out.println("Precio original: " + precio.interpretar());
        System.out.println("Precio con descuento: " + precioConDescuento.interpretar());
    }
}
