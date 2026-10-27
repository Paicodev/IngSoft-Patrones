/* Esta es la clase que va a implementar los métodos de la interfaz visitorSeguros
y va a crear cada uno de los métodos que se van a encargar de generar el reporte

 */

public class ReportVisitor implements VisitorSeguros {

    @Override 
    public String visitSeguroDeVida(SeguroDeVida seguroDeVida)
    {
        return "Información del seguro de vida";
    }

    @Override 
    public String visitSeguroDeRobo(SeguroDeRobo seguroDeRobo)
    {
        return "Información de seguro de robo";
    }

    @Override
    public String visitSeguroDeRetiro(SeguroDeRetiro seguroDeRetiro)
    {
        return "Información de Seguro de retiro";
    }

}
