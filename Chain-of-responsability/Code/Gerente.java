public class Gerente extends Aprobador  {
    @Override 
    public void aprobar(Gasto gasto){
        if (gasto.getMonto() <= 5000) {
            System.out.println("El gerente aprueba el gasto de " + gasto.getMonto());
        } else {
            if (siguiente != null ) {
                siguiente.aprobar(gasto);
            }
        }
    }
}
