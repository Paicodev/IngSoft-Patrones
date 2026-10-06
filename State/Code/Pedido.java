
// El Contexto 
// Mantiene una referencia al estado actual y le delega el comportamiento.
public class Pedido {
    private final String cliente;
    private final String plato;
    private EstadoPedido estado;

    public Pedido(String cliente, String plato) {
        this.cliente = cliente;
        this.plato = plato;
        this.estado = new EstadoRecibido(); 
        System.out.println("Nuevo pedido de " + cliente + ": " + plato);
    }

    // Solo los estados llaman a este método para cambiar la transición
    public void setEstado(EstadoPedido nuevoEstado) {
        System.out.println("  -> " + estado.getNombre() + " pasa a " + nuevoEstado.getNombre());
        this.estado = nuevoEstado;
    }

    // El pedido no tiene ningún if/switch: delega en el estado actual
    public void avanzar() {
        estado.avanzar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String getEstado() {
        return estado.getNombre();
    }

    public void mostrar() {
        System.out.println("Pedido [" + cliente + " - " + plato + "] Estado: " + estado.getNombre());
    }
}