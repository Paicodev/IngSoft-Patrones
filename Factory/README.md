# Factory Method: sistema de notificaciones

## Problema

Una aplicación debe enviar el mismo aviso por diferentes canales: Email, SMS o WhatsApp. Si el código que realiza el envío instancia directamente cada clase concreta, queda acoplado a esos canales. Al sumar uno nuevo, la lógica que decide qué clase crear también tendría que modificarse.

## Solución

Factory Method define en una clase creadora un método de fábrica y delega en sus subclases la elección del producto concreto. En este ejemplo, `NotificationCreator` declara `createNotification()` y define el flujo compartido `notify()`. Cada creador concreto implementa el método de fábrica y devuelve el tipo de notificación correspondiente.

El cliente usa la abstracción `NotificationCreator`; el método `notify()` obtiene una `Notification` y llama a `send()` sin necesitar conocer la clase concreta del producto.

## Roles del patrón

| Rol | Clases del ejemplo | Responsabilidad |
| --- | --- | --- |
| **Product** | `Notification` | Declara la operación común `send(String message)`. |
| **ConcreteProduct** | `EmailNotification`, `SmsNotification`, `WhatsAppNotification`, `PushNotification` | Implementan el envío para cada canal. |
| **Creator** | `NotificationCreator` | Declara `createNotification()` y usa el producto en `notify()`. |
| **ConcreteCreator** | `EmailCreator`, `SmsCreator`, `WhatsAppCreator`, `PushCreator` | Sobrescriben `createNotification()` para crear el producto de su canal. |
| **Cliente** | `Main` | Elige los creadores y ejecuta el flujo común. |

## Estructura

```text
Factory/
├── Code/       # Clases Java del ejemplo
├── UML/        # Diagrama PlantUML
└── README.md   # Explicación y ejecución
```

## Código y demostración

El código Java está en `Code/`. `Main` recorre distintos creadores y envía el mismo mensaje. Para compilar y ejecutar desde la carpeta `Factory` con JDK instalado:

```sh
javac Code/*.java
java -cp Code Main
```

Salida esperada:

```text
Email: La clase de patrones empieza en 10 minutos.
SMS: La clase de patrones empieza en 10 minutos.
WhatsApp: La clase de patrones empieza en 10 minutos.
Push: La clase de patrones empieza en 10 minutos.
```

## UML

El diagrama PlantUML está en [`UML/factory-method.puml`](UML/factory-method.puml). Las líneas punteadas con triángulo indican implementación de interfaz; las líneas continuas con triángulo indican herencia. Las dependencias punteadas `creates` muestran qué producto construye cada creador concreto. `NotificationCreator` depende del contrato `Notification`, que es el tipo usado por `notify()`.

## Agregar Push como modificación en vivo

Para mostrar la extensión, partí de los tres canales originales y agregá:

1. `PushNotification`, que implementa `Notification`.
2. `PushCreator`, que extiende `NotificationCreator` y devuelve `new PushNotification()`.
3. `new PushCreator()` al arreglo de `Main` para incluirlo en esta demostración.

No hay que modificar `NotificationCreator.notify()` ni el contrato `Notification`. El arreglo de `Main` sí se actualiza porque allí se eligen los creadores concretos a ejecutar.

## Ventajas

- Separa el código que usa el producto de las clases concretas que lo implementan.
- Permite agregar un tipo de producto creando su producto concreto y su creador, sin cambiar el flujo común de `NotificationCreator`.
- Facilita probar cada canal de forma independiente.
- Sigue el principio de inversión de dependencias: el flujo trabaja con abstracciones.

## Desventajas

- Aumenta la cantidad de clases: normalmente se agrega un creador concreto por cada producto concreto.
- Agregar un canal requiere crear y mantener tanto el producto como su creador.
- El cliente o el punto de configuración todavía debe elegir qué creador concreto usar; el patrón no elimina esa decisión.
- Para un sistema muy pequeño con pocos canales estables, puede ser más código que una creación directa o un `switch` sencillo.
