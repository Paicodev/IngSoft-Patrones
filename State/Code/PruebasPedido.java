
public class PruebasPedido {
    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) throw new AssertionError("FALLO: " + mensaje);
        System.out.println("OK: " + mensaje);
    }

    public static void main(String[] args) {
        Pedido p = new Pedido("Test", "Milanesa");
        verificar(p.getEstado().equals("Recibido"), "inicia en Recibido");
        p.avanzar();
        verificar(p.getEstado().equals("En preparación"), "Recibido -> En preparación");
        p.avanzar();
        verificar(p.getEstado().equals("Listo"), "En preparación -> Listo");
        p.cancelar();
        verificar(p.getEstado().equals("Listo"), "no se puede cancelar en Listo");
        p.avanzar();
        verificar(p.getEstado().equals("Entregado"), "Listo -> Entregado");
        p.avanzar();
        p.cancelar();
        verificar(p.getEstado().equals("Entregado"), "Entregado es estado final");

        Pedido c = new Pedido("Test", "Ensalada");
        c.cancelar();
        verificar(c.getEstado().equals("Cancelado"), "Recibido -> Cancelado");
        c.avanzar();
        verificar(c.getEstado().equals("Cancelado"), "Cancelado es estado final");

        Pedido d = new Pedido("Test", "Hamburguesa");
        d.avanzar();
        d.cancelar();
        verificar(d.getEstado().equals("Cancelado"), "En preparación -> Cancelado");
        System.out.println("\nTodas las pruebas pasaron.");
    }
}
