

// Estado concreto 3: el plato está terminado y espera ser entregado
public class EstadoListo implements EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("  No se puede cancelar: el plato ya está listo.");
    }

    @Override
    public String getNombre() {
        return "Listo";
    }
}
