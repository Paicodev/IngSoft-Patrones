public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos servicios simples (Hojas)
        ServicioGimnasio paseLibre = new ClaseIndividual("Pase Libre Musculacion", 15000);
        ServicioGimnasio claseCrossfit = new ClaseIndividual("Clases de Crossfit", 12000);
        ServicioGimnasio claseZumba = new ClaseIndividual("Clases de Zumba", 8000);

        // 2. Armamos un Combo basico (Compuesto)
        PaqueteMensual comboFitness = new PaqueteMensual("Combo Fitness", 0.10); // 10% descuento
        comboFitness.agregarServicio(paseLibre);
        comboFitness.agregarServicio(claseZumba);

        // 3. Armamos un Combo VIP que incluye otro Combo adentro (Compuesto dentro de Compuesto)
        PaqueteMensual comboVipTotal = new PaqueteMensual("Combo VIP Total", 0.20); // 20% descuento adicional
        comboVipTotal.agregarServicio(comboFitness);
        comboVipTotal.agregarServicio(claseCrossfit);

        // 4. El sistema principal opera todo mediante la misma abstraccion
        System.out.println("==== VENTA DE SERVICIO INDIVIDUAL ====");
        claseCrossfit.mostrarDetalle();
        System.out.println("\n==== VENTA DE PAQUETE COMPUESTO ====");
        comboVipTotal.mostrarDetalle();
    }
}
