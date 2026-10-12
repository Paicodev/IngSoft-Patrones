class EmailSender implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Email: " + mensaje);
    }
}