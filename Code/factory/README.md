# Factory Method: sistema de notificaciones

## Idea del patrón

Factory Method es un patrón creacional: define en una clase base un método para crear un producto, y deja que las subclases decidan qué producto concreto instanciar.

## Problema que resuelve

Si el código cliente crea directamente `EmailNotification`, `SmsNotification` o `WhatsAppNotification`, queda acoplado a esas clases concretas. Cuando se agrega otro canal, como Push, habría que modificar el lugar que decide qué clase instanciar.

Con Factory Method, el cliente trabaja con una abstracción común (`Notification`) y recibe el producto desde un creador. Cada creador concreto elige el canal que fabrica.

## Roles en este ejemplo

- **Product:** contrato común `Notification`, con una operación para enviar un mensaje.
- **ConcreteProduct:** implementaciones de ese contrato para Email, SMS y WhatsApp.
- **Creator:** clase base que declara el Factory Method y contiene una operación que utiliza el producto.
- **ConcreteCreator:** clases que implementan el Factory Method y crean cada tipo concreto de notificación.

## Implementación actual

El código tiene una interfaz para el producto, una clase abstracta para el creador y una clase concreta por canal: Email, SMS, WhatsApp y Push.

Elegimos una **interfaz** para `Notification` porque solo necesitamos un contrato (`send`), sin estado ni implementación común. Elegimos una **clase abstracta** para `NotificationCreator` porque comparte la operación `notify` y deja abstracta la decisión de qué notificación crear.

La demostración guarda los cuatro creadores en una lista de tipo `NotificationCreator[]` y les pide enviar el mismo mensaje. La lógica de `notify` no necesita saber qué canal está usando.

## Ejecutar la demostración

```sh
npx --yes tsx Code/factory/notifications.ts
```
