# Chain of Responsibility: aprobación de gastos

## Problema que soluciona

Tenemos una solicitud de aprobación de un gasto y diferentes responsables que pueden encargarse de aprobarla dependiendo del monto.
El problema aparece cuando el código que recibe el gasto tiene que conocer directamente qué responsable debe aprobarlo, generando más acoplamiento y haciendo más difícil agregar, quitar o modificar niveles
de aprobación.

En este caso, un Gasto puede tener diferentes montos y queremos que la solicitud pase por una cadena de responsables hasta encontrar uno que pueda aprobarla.

## Solución

Chain of Responsibility establece una cadena de objetos que pueden recibir y procesar una solicitud:

* `Aprobador` actúa como Handler y define el comportamiento común de los responsables, además de mantener una referencia al siguiente elemento de la cadena.
* `Empleado`, `Supervisor`, `Gerente` y `Director` son los ConcreteHandler, cada uno con un límite de aprobación diferente.
* `Gasto` representa la solicitud (Request) que debe ser procesada.
* Cuando un responsable no puede aprobar el gasto, pasa la solicitud al siguiente responsable mediante `siguiente.aprobar(gasto)`.
* La cadena se configura como Empleado → Supervisor → Gerente → Director.

Así, quien genera la solicitud no necesita conocer qué responsable específico la va a aprobar. Cada objeto decide si puede procesarla o si debe pasarla al siguiente elemento de la cadena.

## Ejecutar la demostración

El proyecto contiene las clases necesarias para ejecutar el ejemplo
mediante Main.

La cadena se configura de la siguiente manera:

`Empleado → Supervisor → Gerente → Director`

Los lím*ites de aprobación del ejemplo son:

* Empleado: hasta $100.
* Supervisor: hasta $1.000.
* Gerente: hasta $10.000.
* Director: puede aprobar cualquier monto.

Por ejemplo, si se solicita aprobar un gasto de $5.000, primero lo recibe Empleado, luego Supervisor y finalmente Gerente, que es quien puede aprobarlo.

## Consecuencias de usar Chain of Responsibility

**Ventajas**

* Reduce el acoplamiento entre quien genera la solicitud y quien finalmente la procesa.
* Permite agregar, quitar o modificar responsables dentro de la cadena.
* Cada responsable mantiene solamente la lógica correspondiente a su nivel de aprobación.
* Evita concentrar todas las decisiones en una única clase mediante muchos if o else.
* Permite que una solicitud sea procesada por el primer responsable que pueda hacerse cargo de ella.

**Costos**

* Puede ser más difícil saber de antemano qué objeto terminará procesando una solicitud.
* Si ningún responsable puede procesar la solicitud, es necesario definir qué comportamiento tendrá la cadena.
* Una cadena demasiado larga puede hacer más difícil seguir el recorrido de una solicitud.