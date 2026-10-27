// implementación del Mediador para el chat
public interface MediatorChat {
    
    void registrarUsuario(Usuario usuario);
    
    void enviarMensaje(String mensaje, Usuario remitente);

}