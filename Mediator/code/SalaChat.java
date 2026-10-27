import java.util.ArrayList;
import java.util.List;

public class SalaChat implements MediatorChat {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensaje(String mensaje, Usuario remitente) {
        for (Usuario usuario : usuarios) {
            if (usuario != remitente) {
                usuario.recibirMensaje(remitente.getNombre() + ": " + mensaje);
            }
        }
    }
}