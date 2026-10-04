public class Cliente {

    public static void main(String[] args) {

        // El cliente solamente conoce la Facade
        CompraFacade compra = new CompraFacade();

        // Realizar una compra
        compra.realizarCompra("Matrix", 2500);
    }
}