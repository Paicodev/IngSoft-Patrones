public class Boton {
    private final Command comando;

    public Boton(Command comando) {
        this.comando = comando;
    }

    public void presionar() {
        comando.execute();
    }
}
