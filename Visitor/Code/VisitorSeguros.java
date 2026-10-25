/* La interfaz Visitor va a tener un método por cada clase
que lo implemente
Cada uno va a tener dentro de su firma el tipo de objeto que es que no se va a modificar
 */

public interface VisitorSeguros {

String visitSeguroDeVida(SeguroDeVida seguroDeVida);

String visitSeguroDeRobo(SeguroDeRobo seguroDeRobo);

String visitSeguroDeRetiro(SeguroDeRetiro seguroDeRetiro);

}
