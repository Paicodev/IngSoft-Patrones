public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        Supervisor supervisor = new Supervisor();
        Gerente gerente = new Gerente();
        Director director = new Director();

        empleado.establecerSiguiente(supervisor);
        supervisor.establecerSiguiente(gerente);
        gerente.establecerSiguiente(director);

        Gasto gasto1 = new Gasto(5000);

        empleado.aprobar(gasto1);


    }
}