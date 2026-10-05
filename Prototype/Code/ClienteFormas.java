//El Código Cliente (El código que consume los objetos)
public class ClienteFormas {
    public static void main(String[] args) {
        // Se crean los prototipos base una sola vez
        Circulo circuloBase = new Circulo(15, "Rojo");

        // El cliente necesita más círculos. 
        // En lugar de instanciarlos con 'new', le pide al original que se clone.
        Circulo clon1 = (Circulo) circuloBase.clonar();
        clon1.setColor("Verde"); // Modificamos el clon independientemente

        Circulo clon2 = (Circulo) circuloBase.clonar();
        clon2.setColor("Amarillo");

        // Verificamos que el original quedó intacto y los clones tienen sus propios datos
        System.out.println("--- PrototipoForma Original ---");
        circuloBase.dibujar();

        System.out.println("\n--- Clones ---");
        clon1.dibujar();
        clon2.dibujar();
    }
}