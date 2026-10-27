# Patrón Estructural: Bridge (Puente)

## Contexto

El patrón **Bridge** es un patrón de diseño estructural cuyo propósito principal es **desacoplar una abstracción de su implementación, de modo que ambas puedan variar de forma independiente**.

En este ejemplo modelamos una familia de **Controles Remotos** (capa de abstracción y control) que interactúan con una familia de **Dispositivos Electrónicos** como televisores o radios (capa de implementación concreta).

---

## Problema que soluciona

Cuando un sistema tiene dos o más dimensiones independientes de variación (por ejemplo: *tipos de controles* y *tipos de dispositivos*), intentar modelarlas mediante herencia clásica genera una **explosión combinatoria de clases**.

Si utilizáramos herencia directa:
```text
                  Dispositivo
                /             \
               Tv             Radio
             /    \          /     \
       TvBasico TvAvanzado RadioBasico RadioAvanzado
```

Esto presenta serios inconvenientes:
* **Crecimiento cartesiano ($N \times M$):** Si tenemos $N$ tipos de controles y $M$ tipos de dispositivos, necesitamos crear $N \times M$ clases.
* **Rigidez:** Agregar un nuevo dispositivo (ej. `Proyector`) obliga a crear subclases para cada control existente (`ProyectorBasico`, `ProyectorAvanzado`).
* **Código duplicado:** La lógica de control se repite en cada rama de la jerarquía de herencia.

---

## Solución

Bridge resuelve este problema aplicando el principio de **"favorecer la composición sobre la herencia"**:

1. Divide el concepto en dos jerarquías separadas:
   - **Abstracción:** Define la interfaz de alto nivel orientada al cliente/usuario (los controles remotos).
   - **Implementación:** Define la interfaz de bajo nivel con las operaciones primitivas del hardware (los dispositivos).
2. Conecta ambas jerarquías mediante una referencia de composición (**el Puente**): la abstracción guarda una referencia hacia la interfaz de implementación (`Device`).

De esta manera, el crecimiento de clases pasa de ser multiplicativo ($N \times M$) a **aditivo ($N + M$)**.

---

## Estructura e Implementación

En nuestro código:

### 1. Implementación (Dispositivos)
* **`Device`**: Interfaz que define las operaciones primitivas comunes (`estaHabilitado()`, `habilitar()`, `deshabilitar()`, `setVolumen()`, `setCanal()`, etc.).
* **`Tv`**: Implementación concreta de `Device` que gestiona su propio estado interno (volumen, canal y encendido).
* **`Radio`**: Otra implementación concreta de `Device` con su propia lógica de hardware.

### 2. Abstracción (Controles Remotos)
* **`Remote`**: Interfaz de control que define las acciones disponibles para el usuario (`alternarEncendido()`, `subirVolumen()`, etc.).
* **`BasicRemote`**: Abstracción base que implementa `Remote`. Contiene el campo `protected Device dispositivo;` (el **Puente**) y delega las acciones del usuario a las primitivas del dispositivo.
* **`AdvancedRemote`**: Abstracción refinada que hereda de `BasicRemote` y añade nuevas funcionalidades de alto nivel, como `silenciar()`, sin requerir cambios en ningún dispositivo.

### 3. Cliente
* **`Demo`**: Clase principal que combina libremente cualquier control remoto con cualquier dispositivo en tiempo de ejecución.


## Consecuencias

### Ventajas

* **Desacoplamiento fuerte:** La abstracción y la implementación pueden modificarse o extenderse de forma completamente independiente.
* **Escalabilidad limpia ($N + M$):** Agregar un nuevo dispositivo o un nuevo control solo requiere crear una clase más, sin generar combinaciones redundantes.
* **Principio Abierto/Cerrado (OCP):** Puedes introducir nuevas abstracciones o nuevas implementaciones sin alterar el código existente.
* **Principio de Responsabilidad Única (SRP):** La abstracción se concentra en la lógica de control del usuario, mientras que la implementación se concentra en el manejo concreto de la plataforma o dispositivo.
* **Vinculación dinámica:** Permite cambiar el objeto implementador en tiempo de ejecución (por ejemplo, reutilizar un mismo control para manejar otro aparato).

### Desventajas / Costos

* **Mayor complejidad inicial:** Introduce múltiples interfaces y clases intermedias, lo que puede sobrecargar sistemas simples con una sola dimensión de variación.
* **Capa adicional de indirección:** Cada operación requiere un salto de delegación a través del objeto implementador.

---

## Comparación con otros patrones

| Patrón | ¿Qué comparte con Bridge? | ¿En qué se diferencia de Bridge? |
| :--- | :--- | :--- |
| **Adapter** | Ambos usan composición y delegan el trabajo a otro objeto a través de una interfaz. | **Propósito y momento:** **Adapter** se diseña *a posteriori* (después de que el código existe) para hacer compatibles dos interfaces ajenas o preexistentes. **Bridge** se diseña *a priori* (por adelantado, en la arquitectura inicial) para que dos jerarquías evolucionen por separado. |
| **Strategy** | La estructura de clases es prácticamente idéntica (un objeto delega a una interfaz que tiene múltiples implementaciones concretas). | **Alcance:** **Strategy** es un patrón de **comportamiento** enfocado en intercambiar algoritmos o formas de hacer una tarea puntual (ej. métodos de pago). **Bridge** es un patrón **estructural** enfocado en separar dos jerarquías completas (control vs hardware, UI vs sistema operativo). |
| **State** | Estructuralmente ambos delegan operaciones en una interfaz de soporte. | **Dinámica:** En **State**, el objeto cambia su estado de forma autónoma durante su ciclo de vida y varía su comportamiento según ese estado. En **Bridge**, la asociación suele configurarse al instanciar el objeto para conectar dos dimensiones arquitectónicas fijas. |
| **Abstract Factory** | Trabajan muy bien juntos. | Se pueden combinar: un **Abstract Factory** puede encargarse de construir y enlazar la Abstracción correcta con su Implementador concreto correspondiente según la plataforma o entorno. |
