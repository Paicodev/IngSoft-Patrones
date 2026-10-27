public class Te extends PreparacionBebida {

    @Override
    protected void prepararBebida() {
        System.out.println("Infusionando saquito de té...");
    }

    @Override
    protected void agregarIngrediente() {
        System.out.println("Agregando limón...");
    }
}

// la clase te hereda los pasos de bebida y define como agregar el ingrediente especifico.