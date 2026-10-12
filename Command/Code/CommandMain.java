public class CommandMain {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Command comando = new EncenderLuzCommand(luz);
        Boton boton = new Boton(comando);

        boton.presionar(); // Esto encenderá la luz
    }
}
