public class Empleado extends Aprobador {
    @Override 
    public void aprobar(Gasto gasto) {
        if (gasto.getMonto() <= 100) {
            System.out.println("El empleado aprueba el gasto de " + gasto.getMonto());
        } else {
            if (siguiente != null) {
                siguiente.aprobar(gasto);
            }
        }
    }
    
}
