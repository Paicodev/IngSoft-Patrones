# Composite

Composite es un patrón de diseño estructural que permite agrupar objetos en estructuras de árbol para representar jerarquías de "parte-todo". Su mayor cualidad es que permite al sistema tratar de la misma manera a un objeto individual (Hoja) que a un grupo entero de objetos (Compuesto).
En este ejemplo de gestión de un gimnasio, el establecimiento ofrece servicios simples (como clases individuales de Musculación o Crossfit) y "Paquetes Mensuales" (combos compuestos que agrupan varias clases e incluyen un porcentaje de descuento).

# Problema

Cuando el sistema que procesa los pagos tiene que calcular el total de una venta y necesita verificar constantemente si está manejando un ítem suelto o iterando sobre una lista de ítems dentro de un paquete, aumenta drásticamente el acoplamiento. El código cliente se vuelve frágil al tener que conocer y gestionar la estructura interna de los combos, rompiendo la abstracción.

# Solución

Composite soluciona esto encapsulando a los elementos simples y complejos bajo una misma abstracción, separando al cliente de la estructura interna de los objetos.
En este ejemplo, el cliente interactúa con los servicios sin saber si son simples o compuestos. La ClaseIndividual devuelve su precio, y el PaqueteMensual delega el trabajo internamente recorriendo su lista de clases de forma recursiva, sumando los valores y aplicando el descuento.

# Implementación

Se utiliza una interfaz ServicioGimnasio con el método getPrecio(), la cual es implementada tanto por las clases individuales (Hojas) como por los paquetes (Compuestos). Los compuestos contienen, a su vez, una lista de objetos tipo ServicioGimnasio.

# Ventajas

- Reduce el acoplamiento y fomenta la alta cohesión. El cliente ignora la complejidad de lo que hay adentro de los combos.

- Permite agregar nuevos tipos de promociones o servicios individuales sin modificar el código existente del invocador.

- Facilita enormemente el trabajo con estructuras jerárquicas complejas de manera uniforme.

# Desventajas

- Aumenta la abstracción y el diseño se vuelve tan generalizado que a veces es difícil restringir qué cosas se pueden agrupar.

- Puede requerir validaciones adicionales en tiempo de ejecución (por ejemplo, para evitar meter un combo dentro de sí mismo por error).

# Conclusión

Composite permite representar servicios individuales y paquetes como objetos independientes pero tratables bajo la misma interfaz, facilitando su reutilización, extensión y gestión dentro de un entorno ágil y escalable.
