import java.util.ArrayList;
import java.util.List;

public class Boton {

    private List<ObservadorBoton> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorBoton observador) {
        observadores.add(observador);
    }

    public void quitarObservador(ObservadorBoton observador) {
        observadores.remove(observador);
    }

    public void notificar() {
        for (ObservadorBoton observador : observadores) {
            observador.actualizar();
        }
    }

    public void click() {
        System.out.println("Botón presionado.");
        notificar();
    }
}