public class Editor {

    private String contenido;

    public void escribir(String texto) {
        contenido = texto;
    }

    public Memento guardar() {
        return new Memento(contenido);
    }

    public void restaurar(Memento memento) {
        contenido = memento.obtenerContenido();
    }

    public void mostrarContenido() {
        System.out.println("Contenido: " + contenido);
    }
}