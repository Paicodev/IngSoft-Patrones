# Dependency Injection (Inyección de Dependencias)

## Problema
Cuando una clase como por ejemplo un servicio instancia las dependencias que necesita, queda acoplado a los adaptadores específicos. Esto dificulta sustituir y realizar test unitarios.

## Solución
Dependency Injection es una técnica de diseño que consiste en inyectar las dependencias desde afuera de la clase que las implementa.

En este ejemplo, `NotificacionService` recibe un objeto `Notificador` mediante su constructor. De esta manera, puede trabajar con distintas implementaciones, como `EmailSender`, sin depender directamente de una clase concreta.

## Implementación
Se utiliza **inyección por constructor**, pasando la dependencia al crear el objeto.

## Ventajas
- Reduce el acoplamiento entre clases.
- Facilita las pruebas unitarias y el uso de implementaciones alternativas.
- Mejora la mantenibilidad y la flexibilidad del código.

## Desventajas
- Puede aumentar la cantidad de clases y la configuración necesaria.
- En proyectos grandes, gestionar las dependencias puede resultar complejo.

## Conclusión
Dependency Injection permite separar la creación de los objetos de su utilización, favoreciendo un diseño más flexible, mantenible y fácil de probar.

**Nota:** Dependency Injection es una técnica de diseño, no un patrón GoF de los 23 patrones clásicos.