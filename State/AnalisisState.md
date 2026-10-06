# State: sistema de pedidos de un restaurante

## Problema que soluciona

Tenemos un sistema de pedidos de un restaurante en el que cada `Pedido` pasa por distintos estados: recibido, en preparación, listo, entregado o cancelado. Las mismas acciones (`avanzar` y `cancelar`) tienen un resultado diferente según el estado en el que se encuentre el pedido. Por ejemplo, un pedido recibido se puede cancelar, pero uno que ya está listo o entregado no.

El problema aparece cuando esta lógica se resuelve dentro de la propia clase `Pedido`, con un atributo que guarda el estado actual (un `String` o un `enum`) y bloques `if` o `switch` repetidos en cada método. Esto hace que el código crezca, sea difícil de leer y de probar, y que agregar un estado nuevo obligue a modificar todos los métodos de `Pedido`, con el riesgo de romper lo que ya funcionaba.

En este caso, queremos que el pedido cambie su comportamiento según su estado sin llenar la clase de condicionales.

## Solución

State propone encapsular cada estado en su propia clase y hacer que el objeto principal delegue en el estado actual el comportamiento que depende de él:

* `EstadoPedido` es la interfaz **State**. Define las acciones que un pedido puede recibir: `avanzar`, `cancelar` y `getNombre`.
* `Pedido` es el **Context**. Guarda una referencia al estado actual y le delega las acciones. No tiene ningún `if` ni `switch` sobre el estado.
* `EstadoRecibido` es el estado inicial. Puede avanzar a `EstadoEnPreparacion` o cancelarse.
* `EstadoEnPreparacion` indica que la cocina está preparando el pedido. Puede avanzar a `EstadoListo` o cancelarse (se pierden los ingredientes).
* `EstadoListo` indica que el plato está terminado. Puede avanzar a `EstadoEntregado`, pero ya no se puede cancelar.
* `EstadoEntregado` es un estado final. No admite más cambios.
* `EstadoCancelado` es un estado final. No admite más cambios.
* `ClientePedidos` utiliza `Pedido` sin conocer los estados concretos.

Cuando el cliente llama a `avanzar()` o `cancelar()`, `Pedido` delega la acción en el estado actual. Ese estado decide qué hacer y, si corresponde, llama a `setEstado()` para dejar el pedido en el estado siguiente. El flujo es:

`Recibido → En preparación → Listo → Entregado`

y desde `Recibido` o `En preparación` también se puede pasar a `Cancelado`.

Así, el comportamiento de cada estado queda en una sola clase, y el cliente solamente usa los métodos de `Pedido`. Además, se pueden agregar nuevos estados creando otra clase que implemente `EstadoPedido`, sin modificar `Pedido` ni el código del cliente.

## Ejecutar la demostración

El proyecto contiene las clases necesarias para ejecutar el ejemplo mediante `ClientePedidos`, que contiene el método `main`. Desde la carpeta `State/Code`:

```
javac -encoding UTF-8 *.java
java ClientePedidos
```

Al ejecutar el programa se crean dos pedidos. El primero recorre todo el flujo normal hasta ser entregado, e intenta cancelarse cuando ya está listo (no lo permite). El segundo se cancela apenas se recibe y después intenta avanzar (tampoco lo permite).

También se incluye `PruebasPedido`, que verifica cada transición permitida y prohibida y termina con el mensaje `Todas las pruebas pasaron.`:

```
java PruebasPedido
```

## Consecuencias de usar State

**Ventajas**

* Elimina los condicionales extensos (`if` o `switch`) que dependen del estado, dejando la clase `Pedido` más simple.
* Cada estado queda en su propia clase, con una única responsabilidad, lo que facilita entender y probar cada comportamiento.
* Hace explícitas las transiciones: se ve en cada clase a qué estados puede pasar el pedido y qué acciones están prohibidas.
* Facilita agregar nuevos estados (por ejemplo, "En camino") sin modificar `Pedido` ni el cliente, aunque puede requerir ajustar las transiciones de los estados vecinos.
* El cliente no necesita conocer los estados concretos, solo usa la interfaz de `Pedido`.

**Costos**

* Agrega varias clases al sistema (una interfaz y una clase por estado), lo que puede aumentar la estructura para un flujo sencillo.
* Si hay pocos estados o las reglas son simples, puede ser excesivo: un `enum` con un `switch` podría ser suficiente.
* Los estados conocen a sus estados sucesores, por lo que existe cierto acoplamiento entre ellos.
* La lógica del flujo queda repartida en varias clases, lo que dificulta ver el recorrido completo de un vistazo.
* Si se agrega una nueva acción a la interfaz, hay que implementarla en todos los estados concretos.