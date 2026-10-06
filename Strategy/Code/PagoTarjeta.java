public class PagoTarjeta implements EstrategiaPago {

    private String numero;

    public PagoTarjeta(String numero) {
        this.numero = numero;
    }

    @Override
    public void pagar(int monto) {
        System.out.println("Pagado $" + monto + " con tarjeta: " + numero);
    }
}
