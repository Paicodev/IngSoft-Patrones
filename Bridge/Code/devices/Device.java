package Bridge.Code.devices;

// Interfaz común de todos los dispositivos
public interface Device {
    boolean estaHabilitado();

    void habilitar();

    void deshabilitar();

    int getVolumen();

    void setVolumen(int porcentaje);

    int getCanal();

    void setCanal(int canal);

    void imprimirEstado();
}