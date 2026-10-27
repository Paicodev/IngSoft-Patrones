public class MainMediator {
    public static void main(String[] args) {
        MediatorChat sala = new SalaChat();

        Usuario ana = new Usuario("Ana", sala);
        Usuario bruno = new Usuario("Bruno", sala);
        Usuario carla = new Usuario("Carla", sala);

        sala.registrarUsuario(ana);
        sala.registrarUsuario(bruno);
        sala.registrarUsuario(carla);

        ana.enviarMensaje("Hola a todos");
    }
}
