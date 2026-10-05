public class PagoPayPal implements EstrategiaPago {

    private String email;

    public PagoPayPal(String email) {
        this.email = email;
    }

    @Override
    public void pagar(int monto) {
        System.out.println("Pagado $" + monto + " con PayPal: " + email);
    }
}
