# Patrón Proxy: carga de una imagen

## Problema

Cargar una imagen puede ser costoso. Si se carga al crear el objeto, se hace ese trabajo aunque después nadie la muestre.

## Solución

Un **proxy virtual** representa la imagen y retrasa su carga hasta el primer uso. El cliente usa la misma interfaz que usaría con la imagen real.

- `Imagen`: interfaz con el método `mostrar()`.
- `ImagenReal`: simula la carga de un archivo y permite mostrarlo.
- `ImagenProxy`: crea la imagen real en la primera llamada y la reutiliza en las siguientes.

El ejemplo solo imprime mensajes: no necesita un archivo de imagen ni una biblioteca gráfica.

## Ejecutar

Desde la raíz del repositorio:

```sh
javac Proxy/Code/proxy.java
java -cp Proxy/Code proxy
```

Salida esperada:

```text
Proxy creado: la imagen todavia no se cargo.
Cargando foto.png
Mostrando foto.png
Mostrando foto.png
```

La imagen se carga una sola vez, al llamar por primera vez a `mostrar()`.

## Pros

- Evita cargar recursos que nunca se usan.
- Permite controlar el acceso sin cambiar la interfaz del cliente.
- Reutiliza la imagen cargada en llamadas posteriores.

## Cons

- Agrega una clase y una llamada intermedia.
- El primer uso sigue teniendo el costo de carga.
- Mantiene la imagen en memoria después de cargarla.

## Mini UML

Ver [UML/proxy.puml](UML/proxy.puml).
