# Patrón de diseño Decorator

## Idea del patrón

El patrón decorator es un patrón estructural que nos permite extender funcionalidades a objetos colocandolos dentro de objetos encapsuladores especiales que contienen estas funcionalidades, evitando así la necesidad de hacer uso de herencia.

## Problema 

Este patrón es muy común en videojuegos, imaginemos que estamos desarrollando un juego en donde el personaje principal puede atacar con distintos tipos de armas y armaduras. Si queremos organizar estos tipos de personaje usando herencia, tendriamos una clase para el personaje con un arma de fuego, otra para el personaje con arma de fuego y casco, tendriamos miles de clases definiendo todas las posibles caracteristicas del jugador.

## Solución

Utilizando el patrón decorator podemos generar estos objetos de forma dinámica sin definir cada posibilidad de forma estatica. 
 Creamos el objeto base al que se le va a implementar los decoradores.

## Implementación

En el ejemplo podemos ver:
* Cliente (Juego) que es quien utiliza o interactpua con los objetos decorados
* Componente (Player) es quien define la interfaz común para los objetos decorables
* Componente concreto seria la clase del jugador base
* Clase base de decorador con sus subclases

Se instancia un objeto de jugador básico al que podemos decorar agregandole la funcionalidad de atacar con fuego o veneno.

## Consecuencias

### Ventajas

* Extensión de funcionalidades sin modificar el código original
* Composición flexible
* Adherencia al principio abierto/cerrado
* Reutilización de lógica

### Desventajas

* Muchas clases pequeñas
* El orden importa
* Complejidad oculta
* No es fácil de depurar