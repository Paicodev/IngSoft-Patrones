# Patrón Flyweight: tipos de árboles compartidos

## Problema

Al dibujar muchos árboles, crear un objeto con los mismos datos de tipo para cada árbol repite información y puede gastar memoria innecesariamente.

## Solución

Flyweight comparte los datos que se repiten y recibe los datos particulares de cada uso como parámetros.

- `TipoArbol`: es el flyweight. Guarda el nombre del tipo como **estado intrínseco**, compartido e inmutable.
- `FabricaArboles`: guarda un objeto por nombre y devuelve el existente cuando se pide el mismo tipo.
- Las coordenadas `x` e `y` son el **estado extrínseco**: se pasan a `dibujar()` y no se guardan en el objeto compartido.

El ejemplo dibuja dos pinos en posiciones distintas usando el mismo `TipoArbol`. El roble usa otro objeto. Para mantenerlo mínimo, dibujar consiste en imprimir un mensaje; en un caso real se podrían compartir también texturas del tipo.

## Ejecutar

Desde la raíz del repositorio:

```sh
javac Flyweight/Code/flyweight.java
java -cp Flyweight/Code flyweight
```

Salida esperada:

```text
Pino en (1, 2)
Pino en (5, 8)
Roble en (3, 4)
Los pinos comparten objeto: true
Pino y roble comparten objeto: false
```

La comparación `==` demuestra que ambos pinos reutilizan la misma instancia.

## Pros

- Puede reducir memoria cuando hay muchos objetos con datos repetidos.
- Evita crear varias instancias del mismo tipo dentro de la fábrica.
- Mantiene separados los datos compartidos y los propios de cada uso.

## Cons

- Agrega una fábrica y una colección de objetos compartidos.
- El cliente debe proporcionar los datos particulares en cada operación.
- Con pocos objetos o pocos datos repetidos, el costo de la colección puede superar el ahorro.

## Mini UML

Ver [UML/flyweight.puml](UML/flyweight.puml).
