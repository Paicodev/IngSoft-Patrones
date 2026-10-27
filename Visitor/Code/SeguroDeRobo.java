public class SeguroDeRobo implements Seguros{

    //Código viejo
    @Override 
    public void calcularSeguro(){}

    @Override 
    public String accept(VisitorSeguros visitorSeguros)
    {
        return visitorSeguros.visitSeguroDeRobo(this);
    }


}
