# Interpreter: interpretación de expresiones

## Problema que soluciona

Cuando necesitamos representar y evaluar expresiones de un lenguaje, podemos terminar concentrando las reglas y operaciones en una única clase. Esto dificulta la organización del código y la incorporación de nuevas operaciones.

El patrón Interpreter permite representar las expresiones mediante objetos que conocen cómo interpretar su propio contenido. De esta manera, las expresiones simples pueden combinarse para construir expresiones más complejas.

## Solución

Interpreter proporciona una forma de representar las reglas de un lenguaje y evaluar expresiones que siguen esas reglas.

En esta implementación se utilizan las siguientes clases:

- `Expresion` define la interfaz común mediante el método `interpretar()`.
- `Numero` representa un valor numérico y devuelve su valor al interpretarse.
- `Suma` representa una operación de suma entre dos expresiones.
- `Descuento` representa una regla de descuento aplicada al resultado de otra expresión.
- `Interpreter` contiene el método `main` y ejecuta los ejemplos del patrón.

Las clases `Suma` y `Descuento` reciben objetos que implementan `Expresion`. Esto permite combinar distintas expresiones sin necesidad de conocer los detalles internos de cada una.

La demostración incluye una suma de expresiones y la aplicación de un descuento sobre un precio.

## Ejecutar la demostración

Desde la terminal, ubicarse en la carpeta raíz del proyecto, donde se encuentra `README.md`, y ejecutar:

```bash
javac Interpreter/Code/*.java
java Interpreter.Code.Interpreter
```

La primera instrucción compila los archivos Java y la segunda ejecuta el método `main` de la clase `Interpreter`.

Los comandos suponen que la estructura del proyecto contiene la carpeta `Interpreter/Code` y que los archivos declaran el paquete `Interpreter.Code`.

## Salida esperada

```text
Resultado de la suma: 8
Resultado de la suma anidada: 10
Precio original: 1000
Precio con descuento: 900
```

La demostración permite construir expresiones, combinarlas mediante las clases correspondientes y obtener sus resultados utilizando el método `interpretar()` definido por la interfaz común.

## Consecuencias de usar Interpreter

**Ventajas**

- Permite representar expresiones y reglas de un lenguaje mediante clases y objetos.
- Facilita agregar nuevas operaciones mediante nuevas implementaciones de `Expresion`.
- Separa la lógica de interpretación en componentes independientes.
- Permite combinar expresiones simples para construir otras más complejas.

**Costos**

- Agrega clases e interfaces, aumentando la complejidad del diseño.
- Puede resultar difícil de mantener cuando la gramática contiene muchas reglas.
- Las expresiones complejas pueden generar estructuras de objetos difíciles de comprender.
- No resulta conveniente para todos los lenguajes; cuando las reglas son muy complejas, puede ser preferible utilizar herramientas específicas de análisis sintáctico.