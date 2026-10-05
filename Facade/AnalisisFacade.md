# Facade: sistema de compra de películas

## Problema que soluciona

Tenemos un sistema de compra de películas en el que, para realizar una compra, es necesario interactuar con diferentes subsistemas, como el inventario, el pago, el envío y las notificaciones.

El problema aparece cuando el cliente tiene que conocer y coordinar directamente todas estas clases para completar una operación, generando mayor acoplamiento y haciendo que el código sea más complejo y difícil de mantener.

En este caso, queremos que el cliente pueda realizar una compra sin tener que interactuar directamente con cada uno de los subsistemas.

## Solución

Facade proporciona una interfaz simplificada que permite acceder a un conjunto de subsistemas sin necesidad de conocer su funcionamiento interno:

* `CompraFacade` actúa como **Facade** y coordina las operaciones necesarias para realizar una compra.
* `Inventario` se encarga de verificar la disponibilidad de las películas y actualizar el inventario.
* `Pago` se encarga de procesar el pago de la compra.
* `Envio` se encarga de preparar el envío de la película.
* `Notificacion` se encarga de enviar la confirmación de la compra.
* `Cliente` utiliza `CompraFacade` para realizar una compra mediante el método `realizarCompra`.

Cuando el cliente solicita una compra, `CompraFacade` coordina los subsistemas en el orden correspondiente: verifica la disponibilidad, procesa el pago, actualiza el inventario, prepara el envío y envía la confirmación.

Así, el cliente solamente necesita utilizar la fachada, sin conocer cómo funcionan internamente los subsistemas. Además, se pueden modificar o ampliar estos subsistemas sin afectar directamente al código del cliente.

## Ejecutar la demostración

El proyecto contiene las clases necesarias para ejecutar el ejemplo mediante `Cliente`, que contiene el método `main`.

Al ejecutar el programa, se crea una instancia de `CompraFacade` y se llama al método `realizarCompra`, indicando el título de la película y su precio.

La fachada se encarga de coordinar todos los pasos necesarios para completar la compra.

## Consecuencias de usar Facade

**Ventajas**

* Simplifica la interacción del cliente con un conjunto de subsistemas complejos.
* Reduce el acoplamiento entre el cliente y las clases internas del sistema.
* Facilita el mantenimiento y la modificación de los subsistemas sin afectar directamente al cliente.
* Centraliza la coordinación de las operaciones relacionadas con la compra.
* Permite ofrecer una interfaz sencilla y clara para realizar operaciones complejas.

**Costos**

* Agrega una clase adicional al sistema, lo que puede aumentar su estructura.
* Si la fachada concentra demasiadas responsabilidades, puede volverse una clase difícil de mantener.
* Puede limitar el acceso directo a funcionalidades específicas de los subsistemas si el cliente solo utiliza la interfaz de la fachada.
* No elimina las dependencias entre los subsistemas, sino que simplifica la forma en que el cliente interactúa con ellos.
