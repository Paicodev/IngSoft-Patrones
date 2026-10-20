import java.util.ArrayList;
import java.util.List;




public class PaqueteMensual implements ServicioGimnasio {
    private String nombre;
    private double porcentajeDescuento;
    // Esta lista almacena referencias a la interfaz, permitiendo anidar lo que sea
    private List<ServicioGimnasio> servicios = new ArrayList<>();

    public PaqueteMensual(String nombre, double porcentajeDescuento) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void agregarServicio(ServicioGimnasio servicio) {
        servicios.add(servicio);
    }




    @Override
    public double getPrecio() {
        double precioTotal = 0;
        // La magia de la recursividad
        for (ServicioGimnasio servicio : servicios) {
            precioTotal += servicio.getPrecio(); 
        }
        return precioTotal - (precioTotal * porcentajeDescuento);
    }



    
    @Override
    public void mostrarDetalle() {
        System.out.println("Paquete: [" + nombre + "] (Descuento aplicado: " + (porcentajeDescuento * 100) + "%)");
        for (ServicioGimnasio servicio : servicios) {
            servicio.mostrarDetalle();
        }
        System.out.println("   -> Total a pagar: $" + getPrecio() + "\n");
    }
}