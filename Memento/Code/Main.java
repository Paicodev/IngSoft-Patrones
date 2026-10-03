public class Main {

    public static void main(String[] args) {

        Editor editor = new Editor();
        Historial historial = new Historial();

        editor.escribir("Hola");
        historial.guardar(editor.guardar());

        editor.escribir("Hola mundo");
        historial.guardar(editor.guardar());

        editor.escribir("Hola mundo!!!");

        System.out.println("Estado actual:");
        editor.mostrarContenido();

        editor.restaurar(historial.obtenerAnterior());

        System.out.println("Después de deshacer:");
        editor.mostrarContenido();
    }
}