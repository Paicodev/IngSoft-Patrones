public class DependencyInjection {
    public static void main(String[] args) {
        Notificador email = new EmailSender();
        NotificacionService notificacionService = new NotificacionService(email);
        notificacionService.notificar("Pedido confirmado");
    }
}
