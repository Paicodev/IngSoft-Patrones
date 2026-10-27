
public class SeguroDeVida implements  Seguros {
    
    //Código viejo
    @Override 
    public void calcularSeguro() {}
    
    //En cada clase visitable tenemos que agregar un método de aceptación  
    /*Este método de aceptación va a recibir como parámetro de entrada 
    un objeto del tipo de la interfaz VisitorSeguro
    y al final lo que va a hacer es redirigirnos al método propio que creamos en la implementación del
    visitante, para que este sea el que va a tener la lógica de esta información*/
    @Override 
    public String accept(VisitorSeguros visitorSeguros)
    {
        return visitorSeguros.visitSeguroDeVida(this);
    }


}
