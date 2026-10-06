

// Estado concreto 2: la cocina está preparando el pedido
public class EstadoEnPreparacion implements EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoListo());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("  Pedido cancelado durante la preparación (se pierden los ingredientes).");
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String getNombre() {
        return "En preparación";
    }
}