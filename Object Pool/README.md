# Object Pool: reutilización de recursos limitados

## Problema que soluciona

Tenemos un recurso que es costoso de crear o que existe en cantidad limitada, y varios clientes necesitan usarlo. El problema aparece cuando cada cliente crea su propio recurso y lo descarta al terminar: se desperdician tiempo y memoria en cada creación y destrucción, y no hay control sobre cuántas instancias existen.

Además, si un recurso se reutiliza sin reiniciar su estado, puede conservar datos del cliente anterior.

En este caso, queremos que las bicicletas de una sala de spinning se creen una sola vez, se presten a los socios y se reutilicen cuando estos terminan, controlando la cantidad disponible.

## Solución

Object Pool mantiene un conjunto de objetos ya creados y listos para usar, que los clientes piden prestados y devuelven al terminar:

* `Bicicleta` es el objeto reutilizable. Guarda su número, el socio que la usa y la resistencia, y ofrece `limpiar` para reiniciar su estado antes de reutilizarse.
* `PoolBicicletas` crea todas las bicicletas al iniciar y las guarda en una cola de disponibles. Ofrece `obtener` para pedir una, `devolver` para regresarla y `cantidadDisponibles` para consultar cuántas quedan.
* `Gimnasio` contiene el método `main` y ejecuta la demostración del patrón.

Cuando el cliente necesita una bicicleta, se la pide al pool con `obtener`. Al terminar, la devuelve con `devolver`, que la reinicia con `limpiar` y la deja nuevamente disponible. Si no quedan bicicletas, el pool lanza una excepción en lugar de crear una nueva.

Así, el código cliente no necesita crear ni destruir los recursos, y el pool controla cuántas instancias existen y que cada una se reutilice con su estado limpio.

## Ejecutar la demostración

Desde la terminal, ubicarse en la carpeta raíz del proyecto, donde se encuentra `README.md`, y ejecutar:

```bash
javac Code/*.java
java -cp Code Gimnasio
```

La primera instrucción compila los archivos Java y la segunda ejecuta el método `main` de la clase `Gimnasio`.

**Nota:** si el proyecto se ejecuta desde otra carpeta y aparecen errores de rutas, ubicarse primero en `Code` y ejecutar:

```bash
javac *.java
java Gimnasio
```

## Salida esperada

```text
Bicicleta #1 asignada a Ana (resistencia 1)
  Ana sube la resistencia a 8
Bicicleta #2 asignada a Beto (resistencia 1)
Carla espera: No hay bicicletas disponibles
Bicicleta #1 asignada a Carla (resistencia 1)
Disponibles: 0
```

La demostración crea un pool de dos bicicletas y simula a tres socios. Ana y Beto toman una cada uno, Carla debe esperar porque no quedan, y cuando Ana devuelve la suya, Carla recibe la misma bicicleta con la resistencia reiniciada.

## Consecuencias de usar Object Pool

**Ventajas**

* Evita crear y destruir objetos repetidamente, mejorando el rendimiento.
* Permite limitar y controlar la cantidad máxima de instancias de un recurso.
* Reduce el consumo de memoria y la carga sobre el recolector de basura.
* Centraliza la administración del recurso en un único punto.

**Costos**

* El cliente es responsable de devolver el objeto; si no lo hace, el pool se agota.
* Hay que reiniciar el estado del objeto al devolverlo para no filtrar datos entre clientes.
* Requiere manejar la concurrencia cuando varios clientes usan el pool al mismo tiempo.
* Puede resultar innecesario si los objetos son baratos de crear.