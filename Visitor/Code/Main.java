public class Main {
    public static void main(String[] args) {
        
        SeguroDeVida seguroDeVida = new SeguroDeVida();
        SeguroDeRetiro seguroDeRetiro = new SeguroDeRetiro();
        SeguroDeRobo seguroDeRobo = new SeguroDeRobo();

        ReportVisitor reporte = new ReportVisitor();

        System.out.println(seguroDeVida.accept(reporte));
        System.out.println(seguroDeRetiro.accept(reporte));
        System.out.println(seguroDeRobo.accept(reporte));
    }
}
