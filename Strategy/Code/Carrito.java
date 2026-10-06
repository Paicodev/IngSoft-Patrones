public class Carrito {

    private EstrategiaPago estrategia;

    public void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public void pagar(int monto) {
        estrategia.pagar(monto);
    }
}
