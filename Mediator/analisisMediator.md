# Mediator: chat grupal

## Problema que soluciona

Tenemos varios usuarios que necesitan comunicarse entre sí mediante mensajes. El problema aparece cuando cada usuario debe conocer directamente a los demás para poder enviarles mensajes, generando más acoplamiento y haciendo más difícil agregar nuevos usuarios o modificar la lógica de comunicación.

En este caso, Ana, Bruno y Carla participan en una sala de chat. Queremos que puedan enviarse mensajes sin que cada usuario tenga que gestionar directamente las relaciones con los demás.

## Solución

Mediator establece un objeto central que coordina la comunicación entre varios objetos:

* `MediatorChat` define el contrato que debe cumplir el mediador.
* `SalaChat` actúa como **Concrete Mediator** e implementa la lógica de comunicación. Mantiene una lista de usuarios registrados y distribuye los mensajes.
* `Usuario` representa a los participantes del chat. Cada usuario conoce al mediador y delega en él el envío de mensajes.
* `MainMediator` actúa como cliente: crea la sala, instancia los usuarios, los registra y ejecuta la demostración.

Cuando un usuario envía un mensaje, este se comunica con `MediatorChat`. La implementación `SalaChat` recibe el mensaje y lo distribuye a todos los usuarios registrados, excepto al remitente.

Así, los usuarios no necesitan conocer directamente a los demás para comunicarse, reduciendo el acoplamiento entre ellos.

## Ejecutar la demostración

El proyecto contiene las clases necesarias para ejecutar el ejemplo mediante `MainMediator`.

La demostración crea una sala de chat y registra a tres usuarios: Ana, Bruno y Carla. Luego, Ana envía el mensaje `"Hola a todos"`.

El resultado esperado es que Bruno y Carla reciban el mensaje de Ana, mientras que ella no recibe su propio mensaje.

## Consecuencias de usar Mediator

**Ventajas**

* Reduce el acoplamiento entre los objetos que necesitan comunicarse.
* Centraliza la lógica de comunicación en un único componente.
* Facilita agregar nuevos usuarios sin tener que modificar las clases de los usuarios existentes.
* Permite modificar la forma en que se distribuyen los mensajes sin repartir esa lógica entre todos los participantes.

**Costos**

* El mediador puede volverse demasiado complejo si acumula muchas reglas y responsabilidades.
* Concentra la coordinación de la comunicación, por lo que los errores en el mediador pueden afectar a todos los participantes.
* Agrega una capa de indirección, ya que los mensajes pasan por el mediador antes de llegar a sus destinatarios.
* Los componentes siguen dependiendo del contrato del mediador, aunque ya no necesitan conocerse directamente entre sí.