public class Director extends Aprobador {
    @Override
    public void aprobar(Gasto gasto) {
        if (gasto.getMonto() <= 10000) {
            System.out.println("El director aprueba el gasto de " + gasto.getMonto());
        }
    }
}