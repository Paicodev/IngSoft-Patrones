# Patrón de diseño Visitor

## Visitor es un patrón de diseño de comportamiento que permite separar algoritmos de los objetos sobre los que operan.

Este patrón se utiliza cuando tenemos una estructura de clases compleja y queremos hacer operaciones en  o introducir algún método nuevo sin modificarlas, 
Esto se logra mediante la definición de una interfaz de visitante que declara los métodos de visita para cada clase de objeto posible. Las implementaciones de la interfaz de visitante pueden realizar diferentes operaciones en distintos objetos. 

## Problema

Imaginemos que tenemos tres clases importantes y antiguas en una aplicación de seguros que se encarga de generar diferentes lógicas para cada tipo de seguro de vida. Cada uno está alojado en una clase diferente y nos están pidiendo que generemos un reporte a partir de la información de dichas clases.

## Solución 

