public class Inventario {

    public boolean verificarDisponibilidad(String titulo) {
        System.out.println("Verificando disponibilidad de: " + titulo);

        // Simulamos que la película está disponible
        return true;
    }

    public void actualizarInventario(String titulo) {
        System.out.println("Actualizando inventario...");
        System.out.println("Película retirada del inventario: " + titulo);
    }
}