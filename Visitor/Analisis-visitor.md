# Patrón de diseño Visitor

## Visitor es un patrón de diseño de comportamiento que permite separar algoritmos de los objetos sobre los que operan.

Este patrón se utiliza cuando tenemos una estructura de clases compleja y queremos hacer operaciones en  o introducir algún método nuevo sin modificarlas, 
Esto se logra mediante la definición de una interfaz de visitante que declara los métodos de visita para cada clase de objeto posible. Las implementaciones de la interfaz de visitante pueden realizar diferentes operaciones en distintos objetos. 

## Problema

Imaginemos que tenemos tres clases importantes y antiguas en una aplicación de seguros que se encarga de generar diferentes lógicas para cada tipo de seguro. Cada uno está alojado en una clase diferente y nos están pidiendo que generemos un reporte a partir de la información de dichas clases.

## Solución 

Para aplicar el patrón Visitor tenemos estas tres partes:
- **Elementos a visitar**: los objetos de negocio(seguroDeVida, seguroDeRetiro, seguroDeRobo). Estos solo saben hacer cosas de seguro, no saben nada de reportes.
- **Visitante (La nueva funcionalidad)**: creamos al "visitante" (ReportVisitor) que es el que va a implementar la nueva funcionalidad a cada clase visitable, pero para hacer esto necesita que los seguros le "abran la puerta" para leer su información.
- **La interacción**: Cuando hacemos seguroDeVida.accept(reporte), le estamos diciendo al seguro que va a atender a un visitante(nueva funcionalidad). El seguro ejecuta esa función y devuelve su información para que el reporte haga su función.

## Consecuencias

**Ventajas**
- Principio Abierto/Cerrado. Esta es su mayor ventaja, permite agregar nuevas funcionalidades sin tocar el código existente, solo se tendría que crear un nuevo visitante con su interfaz.
- Principio de Responsabilidad única. Separa la lógica de negocio de las operaciones secundarias.
- Puede acumular estado: Un visitor puede ir guardando información a medida que visita distintos objetos.

**Desventajas**
- Complejidad al agregar nuevas clases visitables. Si se quiere agregar un SeguroDeAuto, vamos a tener que: 
    - Crear la clase SeguroDeAuto.
    - Agregar visitSeguroDeAuto() en la interfaz VisitorSeguros.
    - Modificar todos los visitors que ya existían para que implementen ese nuevo método.

- Puede romper el encapsulamiento. Para que el Visitor haga su trabajo, muchas veces necesita acceder a los datos internos del Seguro. Esto obliga a crear métodos getters públicos para variables preferiblemente privadas. El Visitor necesita saber "demasiado" sobre la clase que visita.
- Agrega complejidad. El flujo no es lineal.

## Conclusión 

Este patrón es ideal cuando la estructura de los objetos es estable y rara vez cambia, pero las operaciones que queremos hacer sobre ellos cambian o se agregan todo el tiempo.