public class SeguroDeRetiro implements  Seguros{

    //Código viejo
    @Override 
    public void calcularSeguro(){}

    @Override 
    public String accept(VisitorSeguros visitorSeguros)
    {
        return visitorSeguros.visitSeguroDeRetiro(this);
    }

}
