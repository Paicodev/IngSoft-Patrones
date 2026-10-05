public class CompraFacade {

    private Inventario inventario;
    private Pago pago;
    private Envio envio;
    private Notificacion notificacion;

    public CompraFacade() {
        inventario = new Inventario();
        pago = new Pago();
        envio = new Envio();
        notificacion = new Notificacion();
    }

    public void realizarCompra(String titulo, double precio) {

        System.out.println("===== INICIANDO COMPRA =====");

        // 1. Verificar disponibilidad
        if (!inventario.verificarDisponibilidad(titulo)) {
            System.out.println("La película no está disponible.");
            return;
        }

        // 2. Procesar pago
        if (!pago.procesarPago(precio)) {
            System.out.println("No se pudo realizar el pago.");
            return;
        }

        // 3. Actualizar inventario
        inventario.actualizarInventario(titulo);

        // 4. Preparar envío
        envio.prepararEnvio(titulo);

        // 5. Enviar confirmación
        notificacion.enviarConfirmacion(titulo);

        System.out.println("===== COMPRA FINALIZADA =====");
    }
}