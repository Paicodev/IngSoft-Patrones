public class App {
    public static void main(String[] args) {
        Mesero mesero = new Mesero();
        
        // El cliente pide un menú infantil
        PedidoBuilder infantilBuilder = new MenuInfantilBuilder();
        mesero.setBuilder(infantilBuilder);
        mesero.construirPedido();
        Pedido pedidoInfantil = infantilBuilder.getPedido();
        pedidoInfantil.mostrarPedido();

        // El cliente pide un menú ejecutivo
        PedidoBuilder ejecutivoBuilder = new MenuEjecutivoBuilder();
        mesero.setBuilder(ejecutivoBuilder);
        mesero.construirPedido();
        Pedido pedidoEjecutivo = ejecutivoBuilder.getPedido();
        pedidoEjecutivo.mostrarPedido();
    }
}
