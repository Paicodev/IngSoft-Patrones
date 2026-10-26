public class Main {

    public static void main(String[] args) {

        System.out.println("--- Preparando té ---");
        PreparacionBebida te = new Te();
        te.preparar(); // Usa el método plantilla

        System.out.println();

        System.out.println("--- Preparando café ---");
        PreparacionBebida cafe = new Cafe();
        cafe.preparar(); // Usa el método plantilla
    }
}