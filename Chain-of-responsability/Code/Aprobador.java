public abstract class Aprobador {
    protected  Aprobador siguiente;

    public void establecerSiguiente(Aprobador siguiente){
        this.siguiente = siguiente;
    }

    public abstract void aprobar(Gasto gasto);
}