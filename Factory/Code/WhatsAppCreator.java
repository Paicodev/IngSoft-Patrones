public class WhatsAppCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }
}
