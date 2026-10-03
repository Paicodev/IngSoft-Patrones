import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<Memento> estados = new ArrayList<>();

    public void guardar(Memento memento) {
        estados.add(memento);
    }

    public Memento obtenerAnterior() {
        if (estados.isEmpty()) {
            return null;
        }

        return estados.remove(estados.size() - 1);
    }
}