

// La Interfaz (State)
public interface EstadoPedido {
    void avanzar(Pedido pedido);
    void cancelar(Pedido pedido);
    String getNombre();
}