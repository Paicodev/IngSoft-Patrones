# Adapter: impresora antigua

## Problema que soluciona

El código cliente espera trabajar con una interfaz conocida, en este ejemplo `Printer`, que ofrece el método `print`. Sin embargo, una impresora antigua ya existente ofrece `printDocument` y no implementa esa interfaz. Modificarla puede no ser posible o conveniente, y el cliente no debería depender directamente de su API particular.

## Solución

Adapter introduce una clase intermediaria que implementa la interfaz esperada por el cliente y delega el trabajo en el objeto existente:

- `Printer` define el contrato que necesita el cliente.
- `LegacyPrinter` es el servicio existente con una interfaz incompatible.
- `PrinterAdapter` implementa `Printer` y traduce la llamada `print` a `printDocument`.
- `Client` usa `Printer` sin conocer los detalles de `LegacyPrinter`.

Así se puede reutilizar la impresora antigua sin cambiar su clase ni acoplar el cliente a ella.

## Ejecutar la demostración

Desde la raíz del repositorio:

```sh
javac Code/adapter/adapter.java
java -cp Code/adapter adapter
```

## Consecuencias de usar Adapter

**Ventajas**

- Permite reutilizar clases existentes aunque sus interfaces no coincidan con las que necesita el cliente.
- Mantiene al cliente desacoplado de la clase adaptada.
- Centraliza la conversión entre interfaces en una clase separada.

**Costos**

- Agrega una clase y una capa de indirección al diseño.
- Si la interfaz adaptada cambia, hay que actualizar el adaptador.
- Para interfaces muy distintas, el adaptador puede acumular lógica de conversión y volverse complejo.
