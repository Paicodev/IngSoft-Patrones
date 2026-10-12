# Command

## Problema
Cuando un objeto solicita una acción y conoce directamente quién la ejecuta y cómo lo hace, aumenta el acoplamiento entre ambos.

## Solución
Command es un patrón de comportamiento que encapsula una solicitud dentro de un objeto, separando al que solicita una acción del que la ejecuta.

En este ejemplo, `Boton` solicita ejecutar un comando, `EncenderLuzCommand` define la acción y `Luz` la realiza.

## Implementación
Se utiliza una interfaz `Command` con el método `execute()`, que implementan los comandos concretos.

## Ventajas
- Reduce el acoplamiento entre quien solicita una acción y quien la ejecuta.
- Permite agregar nuevas acciones sin modificar el invocador.
- Facilita implementar operaciones como deshacer o encolar comandos.

## Desventajas
- Aumenta la cantidad de clases y objetos necesarios.
- Puede resultar excesivo para operaciones simples.

## Conclusión
Command permite representar acciones como objetos independientes, facilitando su reutilización, extensión y gestión.