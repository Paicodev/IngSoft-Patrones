

// Estado concreto 5 (final): el pedido fue cancelado
public class EstadoCancelado implements EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        System.out.println("  El pedido está cancelado, no puede avanzar.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("  El pedido ya estaba cancelado.");
    }

    @Override
    public String getNombre() {
        return "Cancelado";
    }
}
