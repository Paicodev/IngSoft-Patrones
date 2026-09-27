export {};

// Product: contrato común para todos los canales de notificación.
interface Notification {
  send(message: string): void;
}

// ConcreteProducts: cada clase envía el mensaje por un canal distinto.
class EmailNotification implements Notification {
  send(message: string): void {
    console.log(`Email: ${message}`);
  }
}

class SmsNotification implements Notification {
  send(message: string): void {
    console.log(`SMS: ${message}`);
  }
}

class WhatsAppNotification implements Notification {
  send(message: string): void {
    console.log(`WhatsApp: ${message}`);
  }
}

// Creator: declara el Factory Method y usa el producto sin conocer su clase.
abstract class NotificationCreator {
  abstract createNotification(): Notification;

  notify(message: string): void {
    const notification = this.createNotification();
    notification.send(message);
  }
}

// ConcreteCreators: deciden qué ConcreteProduct crear.
class EmailCreator extends NotificationCreator {
  createNotification(): Notification {
    return new EmailNotification();
  }
}

class SmsCreator extends NotificationCreator {
  createNotification(): Notification {
    return new SmsNotification();
  }
}

class WhatsAppCreator extends NotificationCreator {
  createNotification(): Notification {
    return new WhatsAppNotification();
  }
}

// Demo: el flujo común trabaja con el tipo Creator.
const creators: NotificationCreator[] = [
  new EmailCreator(),
  new SmsCreator(),
  new WhatsAppCreator(),
];

for (const creator of creators) {
  creator.notify("Factory method");
}
