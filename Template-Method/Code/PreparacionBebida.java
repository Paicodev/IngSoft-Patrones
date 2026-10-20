//clase abstracta, contiene el metodo plantilla que establece el orden de preparacion
public abstract class PreparacionBebida {
    //metodo plantilla: define el orden de los pasos
    public final void preparar() {
        hervirAgua();
        prepararBebida();
        servirEnTaza();
        agregarIngrediente();
    }

    private void hervirAgua(){
        System.out.println("Hirviendo agua...");

    }
    
    private void servirEnTaza() {
        System.out.println("Sirviendo en una taza...");
    }

    protected abstract void prepararBebida();
    protected abstract void agregarIngrediente();
}