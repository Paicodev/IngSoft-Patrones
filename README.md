# Singleton - Conexión a base de datos

## Contexto

La aplicación presenta un problema sobre el cual se busca tener una misma instancia en todo el programa.

Queremos centralizar el acceso para no tener silos de información entre módulos.

En este caso, suponemos que la aplicación utiliza una única base de datos durante su ejecución, por lo que buscamos que los diferentes módulos puedan acceder a la misma instancia de `DatabaseConnection`.

## Problema

El problema que podría ocurrir si cada módulo crea su propia instancia es generar silos de información y dispersión de esta.

Además, se estarían creando múltiples objetos para administrar el acceso a un mismo recurso, cuando en este caso solamente necesitamos uno compartido entre los diferentes módulos.

## Solución

Singleton logra evitar que se creen múltiples instancias al tener un constructor privado. Una vez que accedemos a su método para obtener la instancia, este evalúa si ya existe una instancia de `DatabaseConnection`. Si no existe, la crea y la almacena; si ya existe, devuelve la instancia existente.

De esta forma, los diferentes módulos pueden acceder al mismo objeto sin crear nuevas instancias.

## Implementación

La implementación del patrón se basa principalmente en un constructor privado, una variable `instance` que almacena la instancia y un método `getInstance()` que permite obtenerla.

### Constructor privado

El constructor es privado para impedir que otras clases puedan crear directamente nuevas instancias de `DatabaseConnection` utilizando `new`.

De esta manera, la creación de la instancia queda controlada por la propia clase.

### `instance`

`instance` almacena la referencia a la única instancia de `DatabaseConnection`.

Es `static` porque pertenece a la clase y permite mantener una única referencia compartida, sin depender de que exista previamente un objeto de la clase.

### `getInstance()`

`getInstance()` es el método encargado de proporcionar acceso a la instancia.

En la primera llamada, `instance` todavía es `null`, por lo que se crea una nueva instancia de `DatabaseConnection` y se almacena en `instance`.

En las siguientes llamadas, como la instancia ya existe, no se crea otro objeto y se devuelve la misma referencia.

## Diagrama UML

![Diagrama UML](uml/singleton.png)

El diagrama representa la clase `DatabaseConnection` y sus principales elementos.

`instance` es un atributo privado y estático que almacena la instancia. El constructor también es privado para evitar que otras clases creen objetos directamente.

`getInstance()` es un método público y estático que permite obtener la instancia, mientras que `executeQuery()` representa una operación que puede realizarse utilizando la conexión.

## Ejemplo de uso

En `Main` se obtiene dos veces la instancia de `DatabaseConnection`:

```java
DatabaseConnection db1 = DatabaseConnection.getInstance();

DatabaseConnection db2 = DatabaseConnection.getInstance();
```

La primera llamada crea la instancia, mientras que la segunda devuelve la instancia que ya había sido creada.

Luego se utiliza:

```java
db1 == db2
```

Esto comprueba si ambas variables hacen referencia al mismo objeto en memoria. En este caso, el resultado es `true`, demostrando que ambas variables apuntan a la misma instancia.

## Ventajas

* Garantiza que exista una única instancia de la clase.
* Permite tener un punto de acceso global a esa instancia.
* Evita crear múltiples objetos cuando solamente se necesita uno.
* Permite centralizar el acceso a un recurso compartido.

## Desventajas

* Introduce un estado global, lo que puede dificultar saber qué parte del programa utiliza o modifica la instancia.
* Puede dificultar las pruebas unitarias debido a la dependencia de una instancia compartida.
* No es apropiado cuando el sistema necesita múltiples instancias independientes.

## ¿Cuándo utilizar Singleton?

Singleton puede utilizarse cuando el sistema necesita garantizar que exista una única instancia de un determinado recurso o componente y que diferentes partes del programa puedan acceder a él.

En este ejemplo suponemos que la aplicación utiliza una única base de datos durante su ejecución, por lo que se centraliza su acceso mediante `DatabaseConnection`.

No sería apropiado utilizarlo si el sistema necesitara administrar múltiples bases de datos independientes, ya que una única instancia de `DatabaseConnection` impediría tener diferentes instancias para cada una.

## Conclusión

Mediante el ejemplo se pudo comprobar cómo Singleton permite restringir la creación de una clase a una única instancia.

En el caso de `DatabaseConnection`, la primera llamada a `getInstance()` crea la instancia y las siguientes llamadas devuelven la misma. Esto permite centralizar el acceso a la conexión dentro de la aplicación.
