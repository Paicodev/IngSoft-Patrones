# Prototype Method

## Problema

En muchas aplicaciones, crear un objeto desde cero (instanciación) puede ser un proceso muy costoso en términos de tiempo y recursos, especialmente si requiere consultar bases de datos, leer archivos de configuración o realizar cálculos complejos. Además, a veces se necesita crear copias exactas de un objeto en un estado particular, pero hacerlo desde el código cliente genera un fuerte acoplamiento a las clases concretas y expone detalles de implementación que deberían mantenerse ocultos.

## Solución

El patrón Prototype propone delegar el proceso de clonación al propio objeto que está siendo clonado. Para esto, se declara una interfaz común con un método clonar(). Todos los objetos que soporten la clonación deben implementar esta interfaz. De esta manera, el cliente solo interactúa con la interfaz genérica y le pide al objeto original que se copie a sí mismo, obteniendo un nuevo objeto con el mismo estado sin necesidad de acoplarse a su clase específica ni inicializarlo desde cero.

## Consecuencias

**Ventajas:**

- Se puede clonar objetos sin acoplarlos a sus clases concretas.
- Evita código de inicialización repetido.
- Se pueden crear objetos complejos con más facilidad.
- Es muy útil cuando se necesita instanciar objetos en tiempo de ejecución de manera dinámica.

**Desventajas:**

- La principal dificultad radica en clonar objetos complejos que tienen referencias circulares o dependencias de otros objetos. En estos casos, es necesario decidir y programar con cuidado si se realizará una copia superficial (Shallow Copy) o una copia profunda (Deep Copy).