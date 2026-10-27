public class Usuario {
    private String nombre;
    private MediatorChat mediador;

    public Usuario(String nombre, MediatorChat mediador) {
        this.nombre = nombre;
        this.mediador = mediador;
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(String mensaje) {
        mediador.enviarMensaje(mensaje, this);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println(nombre + " ha recibido el mensaje: " + mensaje);
    }
}