public class ClaseIndividual implements ServicioGimnasio {
    private String nombre;
    private double precioBase;

    public ClaseIndividual(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println(" - " + nombre + ": $" + precioBase);
    }
}

