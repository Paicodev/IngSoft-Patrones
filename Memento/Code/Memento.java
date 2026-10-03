public class Memento {

    private String contenido;

    public Memento(String contenido) {
        this.contenido = contenido;
    }

    public String obtenerContenido() {
        return contenido;
    }
}