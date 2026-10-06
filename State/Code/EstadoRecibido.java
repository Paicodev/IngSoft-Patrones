

// Estado concreto 1: el pedido recién ingresó
public class EstadoRecibido implements EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoEnPreparacion());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("  Pedido cancelado antes de cocinarse.");
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String getNombre() {
        return "Recibido";
    }
}