import java.util.ArrayDeque;
import java.util.Queue;

public class PoolBicicletas {
    private final Queue<Bicicleta> disponibles = new ArrayDeque<>();

    public PoolBicicletas(int cantidad) {
        for (int i = 1; i <= cantidad; i++) disponibles.add(new Bicicleta(i));
    }

    public synchronized Bicicleta obtener() {
        if (disponibles.isEmpty())
            throw new IllegalStateException("No hay bicicletas disponibles");
        return disponibles.poll();
    }

    public synchronized void devolver(Bicicleta b) {
        b.limpiar();
        disponibles.offer(b);                      // vuelve a estar disponible
    }

    public synchronized int cantidadDisponibles() { return disponibles.size(); }
}