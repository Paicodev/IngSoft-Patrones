# UML: Builder para pedidos de restaurante

## Cómo leerlo

*   **`Pedido`** es la clase del producto final. Contiene los atributos del objeto complejo.
*   **`PedidoBuilder`** es la interfaz del constructor. Las líneas con triángulo y línea punteada muestran que `MenuInfantilBuilder` y `MenuEjecutivoBuilder` implementan esta interfaz.
*   **`Mesero`** es el Director. Tiene una relación de agregación (línea con rombo) hacia `PedidoBuilder` porque contiene una referencia al constructor que está utilizando, pero depende de la abstracción, no de las clases concretas.
*   La línea punteada desde la clase `Mesero` hacia los métodos de construcción (o una nota indicándolo) muestra que el Director es quien llama secuencialmente a `buildPart()`.
*   Las flechas punteadas de los constructores concretos hacia `Pedido` indican que cada constructor específico instancia y ensambla (crea) el producto final.

Para seguir el flujo, elegí un constructor concreto: por ejemplo, `MenuInfantilBuilder`.
El Cliente le pasa este constructor al `Mesero`.
Luego, `Mesero.construirPedido()` llama a los métodos de construcción en orden.
Finalmente, el código cliente llama a `getPedido()` sobre el `MenuInfantilBuilder` para recibir el `Pedido` ya configurado.