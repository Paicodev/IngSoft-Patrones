public class Main {

    public static void main(String[] args) {
        Carrito carrito = new Carrito();

        // Pagamos con tarjeta
        carrito.setEstrategia(new PagoTarjeta("1234-5678"));
        carrito.pagar(1000);

        // Cambiamos de estrategia en tiempo de ejecución
        carrito.setEstrategia(new PagoPayPal("usuario@mail.com"));
        carrito.pagar(500);
    }
}
