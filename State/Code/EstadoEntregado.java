
// Estado concreto 4 (final): el cliente ya recibió el plato
public class EstadoEntregado implements EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        System.out.println("  El pedido ya fue entregado, no hay más pasos.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("  No se puede cancelar un pedido ya entregado.");
    }

    @Override
    public String getNombre() {
        return "Entregado";
    }
}
