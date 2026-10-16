# Iterator: recorrido de una colección

## Problema que soluciona

Tenemos una colección de elementos y necesitamos recorrerlos para que otros objetos puedan utilizarlos. El problema aparece cuando el código que recorre la colección depende de su estructura interna, ya sea un array, una lista enlazada, un árbol u otra estructura de datos.

Esto genera más acoplamiento y hace que cambiar la forma en que se almacenan los elementos pueda obligarnos a modificar el código que los recorre.

En este caso, queremos recorrer los elementos de una colección sin necesidad de conocer cómo están almacenados internamente.

## Solución

Iterator proporciona una forma de acceder secuencialmente a los elementos de una colección sin exponer su representación interna:

* `IteratorInterface` define la interfaz para recorrer los elementos mediante operaciones como `hasNext` y `next`.
* `ConcreteIterator` implementa el recorrido y mantiene la posición actual dentro de la colección.
* `Aggregate` define el contrato que permite obtener un iterador.
* `ConcreteAggregate` almacena los elementos y proporciona un iterador capaz de recorrerlos.
* `Iterator` contiene el método `main` y ejecuta la demostración del patrón.

Cuando el cliente necesita recorrer los elementos, solicita un iterador a la colección y utiliza sus operaciones para obtenerlos uno por uno.

Así, el código cliente no necesita conocer cómo está implementada la colección y puede utilizar una misma forma de recorrido con distintas estructuras de datos compatibles.



## Ejecutar la demostración

Desde la terminal, ubicarse en la carpeta raíz del proyecto, donde se encuentra `README.md`, y ejecutar:

```bash
javac Code/*.java
java -cp Code Iterator.Code.Iterator
```

La primera instrucción compila los archivos Java y la segunda ejecuta el método `main` de la clase `Iterator`.

**Nota:** como los archivos declaran el paquete `Iterator.Code`, si la compilación presenta errores de paquetes o rutas, se puede compilar desde la carpeta que contiene la carpeta raíz del paquete. En ese caso, ejecutar:

```bash
javac Iterator/Code/*.java
java Iterator.Code.Iterator
```

## Salida esperada

```text
Ana
Juan
Pedro
```

La demostración permite crear una colección, obtener su iterador y recorrer todos sus elementos utilizando las operaciones definidas por la interfaz `IteratorInterface`.

## Consecuencias de usar Iterator

**Ventajas**

* Permite recorrer una colección sin exponer su estructura interna.
* Reduce el acoplamiento entre el código cliente y la implementación de la colección.
* Permite establecer una interfaz de recorrido común para diferentes estructuras de datos.
* Facilita implementar distintos tipos de recorrido sin modificar el código cliente.

**Costos**

* Agrega clases e interfaces, aumentando la complejidad del diseño.
* Puede resultar innecesario para colecciones simples que no requieren una abstracción adicional.
* Si se modifican los elementos de la colección durante el recorrido, puede ser necesario definir cómo debe comportarse el iterador.
* Mantener varios tipos de iteradores puede aumentar el trabajo de implementación y mantenimiento.