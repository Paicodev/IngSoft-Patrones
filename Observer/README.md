# Observer: botón con eventos

## Problema que soluciona

Tenemos un objeto que genera un evento y diferentes objetos que deben reaccionar cuando este ocurre. El problema aparece cuando el objeto principal tiene que conocer directamente qué acciones debe ejecutar, generando más acoplamiento y haciendo más difícil agregar nuevos comportamientos.

En este caso, el `Boton` puede generar un evento al ser presionado y queremos que diferentes objetos reaccionen ante ese evento.

## Solución

Observer establece una relación entre un objeto que genera el evento y varios objetos interesados en recibirlo:

* `Boton` actúa como **Subject** y mantiene una lista de observadores.
* `ObservadorBoton` define el contrato que deben cumplir los observadores.
* `GuardarObservador`, `SonidoObservador` y `RegistroObservador` son los observadores concretos, cada uno con un comportamiento diferente.
* Cuando se presiona el botón, este notifica a todos los observadores registrados mediante `actualizar`.

Así, el botón no necesita conocer qué hace cada observador y se pueden agregar nuevos comportamientos sin modificar su lógica.

## Ejecutar la demostración

El proyecto contiene las clases necesarias para ejecutar el ejemplo mediante `Main`.

## Consecuencias de usar Observer

**Ventajas**

* Permite que un mismo evento sea recibido por varios objetos.
* Reduce el acoplamiento entre el objeto que genera el evento y los objetos que reaccionan ante él.
* Facilita agregar o quitar comportamientos sin modificar el `Subject`.

**Costos**

* Si existen muchos observadores, puede ser más difícil seguir qué acciones se ejecutan ante un evento.
* Agrega una relación de dependencia entre el `Subject` y sus observadores.
* La ejecución de un evento puede producir muchas operaciones si hay una gran cantidad de observadores registrados.
