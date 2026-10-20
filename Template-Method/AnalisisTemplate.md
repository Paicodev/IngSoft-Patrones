## Template Method: preparación de bebidas calientes
### Problema que soluciona
Tenemos un sistema que simula la preparación de distintas bebidas calientes, como té y café. Ambas bebidas siguen un proceso de preparación casi idéntico: hervir agua, infusionar/preparar la bebida, servir en una taza y agregar ingredientes o condimentos.

El problema aparece cuando cada clase (Cafe, Te) implementa todo el algoritmo por su cuenta, generando duplicación de código en los pasos comunes (como hervir agua y servir en taza) y dificultando el mantenimiento si en el futuro cambia el orden general de la receta.

En este caso, queremos reutilizar el flujo general de preparación y garantizar que el orden de los pasos no cambie, permitiendo únicamente que cada bebida personalice sus pasos específicos.

#### Solución
Template Method define el esqueleto de un algoritmo en un método de una clase base, delegando la implementación de ciertos pasos a las subclases:

- PreparacionBebida actúa como Clase Abstracta y define el método plantilla preparar(), marcado como final para evitar que las subclases alteren el orden del proceso. Además, implementa los pasos comunes (hervirAgua, servirEnTaza) y declara los métodos abstractos que varían.

- Cafe actúa como Clase Concreta e implementa sus pasos específicos (prepararBebida para infusionar café y agregarIngrediente para sus agregados).

- Te actúa como Clase Concreta e implementa sus pasos específicos (prepararBebida para el saquito de té y agregarIngrediente para sus agregados).

- Main actúa como Cliente e invoca el método plantilla preparar() sobre las instancias de Te y Cafe.

Cuando el cliente solicita preparar una bebida, PreparacionBebida ejecuta el algoritmo en el orden estricto: hierve agua, llama a la implementación específica de prepararBebida(), sirve en la taza y finalmente ejecuta agregarIngrediente().

Así, el flujo de preparación queda centralizado y protegido en la clase padre, mientras que las subclases solo se preocupan por detallar lo que las hace distintas.

#### Ejecutar la demostración
El proyecto contiene las clases necesarias para ejecutar el ejemplo mediante Main, que contiene el método main.

Al ejecutar el programa, se crean instancias de Te y Cafe referenciadas mediante la clase abstracta PreparacionBebida, y se invoca el método preparar().

El método plantilla se encarga de coordinar la ejecución en secuencia de los pasos comunes e individuales de cada bebida.

### Consecuencias de usar Template Method
#### Ventajas

- Evita la duplicación de código centralizando los pasos comunes en la clase abstracta base.

- Garantiza que la estructura general del algoritmo no sea alterada ni modificada por las subclases.

- Facilita la extensión del sistema, permitiendo agregar nuevas bebidas (como Mate o Chocolate Caliente) solo implementando los métodos específicos.

- Aplica el principio de inversión de control ("Principio de Hollywood"): la clase base llama a las operaciones de la subclase y no al revés.

### Costos

- Limita la flexibilidad del algoritmo, ya que las subclases están obligadas a seguir la estructura rígida del método plantilla.

- Puede aumentar la cantidad de clases en el sistema si existen muchas variaciones pequeñas.

- Si la clase base acumula demasiados pasos abstractos o hooks opcionales, puede volverse compleja de mantener.