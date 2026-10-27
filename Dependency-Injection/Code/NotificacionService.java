public class NotificacionService {
    private final Notificador notificador;

    public NotificacionService(Notificador notificador){
        this.notificador = notificador;
    }

    public void notificar(String mensaje){
        notificador.enviar(mensaje);
    }
}
