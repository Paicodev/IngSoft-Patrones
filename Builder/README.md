# Patrón creacional Builder

Este ejemplo construye pedidos de restaurante con dos representaciones: un menú infantil y un menú ejecutivo.

## Problema

Crear un objeto complejo como `Pedido` directamente desde el cliente obliga a conocer todos sus componentes y el orden en que se configuran. A medida que aparecen distintos tipos de menú o cambia el proceso de preparación, esta lógica se duplica y el cliente queda acoplado a los detalles de construcción.

## Solución

Builder separa la construcción del producto de su representación. En este ejemplo:

- `Pedido` es el producto que contiene el plato principal, la bebida y el postre.
- `PedidoBuilder` define los pasos comunes para construir un pedido.
- `MenuInfantilBuilder` y `MenuEjecutivoBuilder` implementan esos pasos para cada menú.
- `Mesero` es el Director: coordina los pasos sin depender de un constructor concreto.
- `App` selecciona un constructor, solicita al Director que construya el pedido y obtiene el resultado.

El código Java se encuentra en [`Code/src`](Code/src), y las instrucciones para compilar y ejecutar la demostración están en [`Code/README.md`](Code/README.md).

## Consecuencias

**Ventajas**

- Separa el proceso de construcción de las representaciones de `Pedido`.
- Centraliza la secuencia de construcción en el Director y permite reutilizarla con distintos constructores.
- Facilita añadir nuevos tipos de menú sin modificar el cliente ni la interfaz del Director.

**Costos**

- Añade clases e interfaces, por lo que puede resultar excesivo para productos simples con pocas variaciones.
- Cada nueva representación requiere implementar otro constructor concreto.

## Diagrama UML

El diagrama editable de PlantUML es [`UML/pedido.puml`](UML/pedido.puml). Para visualizarlo, usa la imagen PNG [`UML/pedidoUML.png`](UML/pedidoUML.png); también se conserva el archivo original [`UML/pedidoUML.jfif`](UML/pedidoUML.jfif). La explicación de sus roles y relaciones está en [`UML/README.md`](UML/README.md).
