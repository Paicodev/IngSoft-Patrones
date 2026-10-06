

// El Código Cliente
// Usa el Pedido sin saber nada de los estados concretos.
public class ClientePedidos {
    public static void main(String[] args) {
        System.out.println("=== Caso 1: flujo normal ===");
        Pedido pizza = new Pedido("Lucila", "Pizza muzzarella");
        pizza.mostrar();
        pizza.avanzar();   // Recibido -> En preparación
        pizza.avanzar();   // En preparación -> Listo
        pizza.cancelar();  // No permitido en Listo
        pizza.avanzar();   // Listo -> Entregado
        pizza.avanzar();   // No hay más pasos
        pizza.mostrar();

        System.out.println("\n=== Caso 2: cancelación a tiempo ===");
        Pedido empanadas = new Pedido("Martín", "Docena de empanadas");
        empanadas.cancelar();  // Recibido -> Cancelado
        empanadas.avanzar();   // No permitido en Cancelado
        empanadas.mostrar();
    }
}