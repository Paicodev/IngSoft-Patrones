import java.util.HashMap;
import java.util.Map;

// Flyweight: guarda el estado compartido e inmutable.
class TipoArbol {
    private final String nombre;

    TipoArbol(String nombre) {
        this.nombre = nombre;
    }

    // Las coordenadas pertenecen a cada uso, no al objeto compartido.
    void dibujar(int x, int y) {
        System.out.println(nombre + " en (" + x + ", " + y + ")");
    }
}

class FabricaArboles {
    private final Map<String, TipoArbol> tipos = new HashMap<>();

    TipoArbol obtener(String nombre) {
        if (!tipos.containsKey(nombre)) {
            tipos.put(nombre, new TipoArbol(nombre));
        }
        return tipos.get(nombre);
    }
}

public class flyweight {
    public static void main(String[] args) {
        FabricaArboles fabrica = new FabricaArboles();
        TipoArbol primero = fabrica.obtener("Pino");
        TipoArbol segundo = fabrica.obtener("Pino");
        TipoArbol tercero = fabrica.obtener("Roble");

        primero.dibujar(1, 2);
        segundo.dibujar(5, 8);
        tercero.dibujar(3, 4);
        System.out.println("Los pinos comparten objeto: " + (primero == segundo));
        System.out.println("Pino y roble comparten objeto: " + (primero == tercero));
    }
}
