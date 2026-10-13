public class Main {
    public static void main(String[] args) {
        NotificationCreator[] creators = {
            new EmailCreator(),
            new SmsCreator(),
            new WhatsAppCreator(),
            new PushCreator()
        };

        for (NotificationCreator creator : creators) {
            creator.notify("La clase de patrones empieza en 10 minutos.");
        }
    }
}
