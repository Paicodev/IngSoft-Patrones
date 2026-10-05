# UML: Builder para pedidos de restaurante

- `Pedido` es el producto final que contiene el plato principal, la bebida y el postre.
- `PedidoBuilder` declara los pasos comunes para construir un pedido.
- `MenuInfantilBuilder` y `MenuEjecutivoBuilder` implementan esos pasos y configuran cada menú.
- `Mesero` es el Director: mantiene una referencia a `PedidoBuilder` y coordina la secuencia de construcción.
- `App` actúa como cliente: selecciona un constructor concreto, solicita la construcción al Director y recupera el pedido terminado.

El diagrama editable está en [`pedido.puml`](pedido.puml). La imagen visual está disponible como [`pedidoUML.png`](pedidoUML.png) y [`pedidoUML.jfif`](pedidoUML.jfif).
