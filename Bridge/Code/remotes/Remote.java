package Bridge.Code.remotes;

// Interfaz común de todos los remotos
public interface Remote {
    void alternarEncendido();

    void bajarVolumen();

    void subirVolumen();

    void bajarCanal();

    void subirCanal();
}
