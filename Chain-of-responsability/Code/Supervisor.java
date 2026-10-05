public class Supervisor extends Aprobador {
    @Override
    public void aprobar(Gasto gasto) {
        if (gasto.getMonto() <= 1000) {
            System.out.println("El supervisor aprueba el gasto de " + gasto.getMonto());
        } else {
            if (siguiente != null) {
                siguiente.aprobar(gasto);
            }
        }
    }
}
