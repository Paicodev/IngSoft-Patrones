# Builder: sistema de pedidos de restaurante

## Idea del patrón

Builder es un patrón creacional: separa la construcción de un objeto complejo de su representación final. Esto permite que un mismo proceso o secuencia de construcción (dirigida por un Director) pueda crear diferentes variaciones o representaciones de un producto paso a paso.

## Problema que resuelve

Si el código cliente crea directamente un objeto `Pedido` con un constructor gigantesco (`new Pedido("Hamburguesa", "Jugo", "Helado")`), el código se vuelve difícil de leer y mantener, especialmente cuando hay parámetros opcionales (el anti-patrón "Telescoping Constructor"). Además, si los pasos para ensamblar un menú cambian o se vuelven más complejos, el cliente queda fuertemente acoplado a esa lógica.

Con el patrón Builder, el cliente delega la lógica paso a paso a un Director, que trabaja con una abstracción (`PedidoBuilder`). Cada constructor específico decide qué ingredientes exactos se añaden al pedido final.

## Roles en este ejemplo

*   **Product:** el objeto complejo `Pedido` que queremos ensamblar, con sus diferentes partes (plato principal, bebida, postre).
*   **Builder:** contrato común `PedidoBuilder`, con operaciones para construir cada parte del producto y obtener el resultado final.
*   **Specific Builder (ConcreteBuilder):** implementaciones de ese contrato (`MenuInfantilBuilder`, `MenuEjecutivoBuilder`) que crean y ensamblan las partes específicas del pedido.
*   **Director:** la clase `Mesero` que conoce el orden secuencial de los pasos para armar el producto utilizando la interfaz del Builder.

## Implementación actual

El código tiene una clase para el producto, una interfaz para el constructor, clases concretas para cada menú y una clase directora para orquestar la preparación.

Elegimos una **interfaz** para `PedidoBuilder` porque define un contrato de construcción puro (`buildPlatoPrincipal`, `buildBebida`, `buildPostre`), sin necesidad de compartir estado base. Elegimos delegar el control de la secuencia al `Mesero` (Director) para que la lógica de "qué va primero y qué va después" no ensucie al cliente principal.

La demostración instancia un Director (`Mesero`) y le pasa diferentes constructores específicos. El Director manda a construir el pedido ignorando los detalles concretos, y luego el cliente recupera el producto final terminado.

## Ejecutar la demostración

```bash
javac Code/builder/RestauranteApp.java
java -cp Code/builder RestauranteApp