# UML: Factory Method para notificaciones

El diagrama está en [`notification-factory.puml`](./notification-factory.puml) y refleja las clases de [`notifications.ts`](../../Code/factory/notifications.ts), incluidos los cuatro canales.

## Cómo leerlo

- `Notification` es la interfaz del producto. Las líneas con triángulo y línea punteada muestran que Email, SMS, WhatsApp y Push **implementan** esa interfaz.
- `NotificationCreator` es abstracta. Declara el Factory Method `createNotification()` y la operación `notify()` que usa un producto.
- Las líneas con triángulo y línea continua indican **herencia**: cada creador concreto hereda de `NotificationCreator` y define el Factory Method.
- Las flechas punteadas con la etiqueta `creates` indican qué producto instancia cada creador concreto.
- La flecha punteada de `NotificationCreator` a `Notification` indica que el creador usa el producto a través de su abstracción, sin depender de una clase concreta.

Para seguir el flujo, elegí un creador concreto: por ejemplo, `EmailCreator` crea `EmailNotification`. Luego `notify()` recibe ese producto como `Notification` y llama a `send()`. El código cliente puede usar los cuatro creadores mediante el tipo común `NotificationCreator`.
