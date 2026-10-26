public class Cafe extends PreparacionBebida {

    @Override
    protected void prepararBebida() {
        System.out.println("Infusionando café en agua caliente...");
    }

    @Override
    protected void agregarIngrediente() {
        System.out.println("Agregando azúcar y leche...");
    }
}