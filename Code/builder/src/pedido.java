// 1. PRODUCTO: El objeto complejo que se está construyendo.
class Pedido {
    private String platoPrincipal;
    private String bebida;
    private String postre;

    public void setPlatoPrincipal(String platoPrincipal) { this.platoPrincipal = platoPrincipal; }
    public void setBebida(String bebida) { this.bebida = bebida; }
    public void setPostre(String postre) { this.postre = postre; }

    public void mostrarPedido() {
        System.out.println("Pedido finalizado -> Plato: " + platoPrincipal + 
        ", Bebida: " + bebida + ", Postre: " + postre);
    }
}

// 2. BUILDER: Interfaz para crear los componentes del producto.
interface PedidoBuilder {
    void buildPlatoPrincipal();
    void buildBebida();
    void buildPostre();
    Pedido getPedido();
}

// 3. SPECIFIC BUILDER A: Menú Infantil
class MenuInfantilBuilder implements PedidoBuilder {
    private Pedido pedido = new Pedido();

    @Override
    public void buildPlatoPrincipal() { pedido.setPlatoPrincipal("Hamburguesa con papas"); }
    @Override
    public void buildBebida() { pedido.setBebida("Jugo de manzana"); }
    @Override
    public void buildPostre() { pedido.setPostre("Helado de vainilla"); }
    @Override
    public Pedido getPedido() { return pedido; }
}

// 3. SPECIFIC BUILDER B: Menú Ejecutivo
class MenuEjecutivoBuilder implements PedidoBuilder {
    private Pedido pedido = new Pedido();

    @Override
    public void buildPlatoPrincipal() { pedido.setPlatoPrincipal("Bife de chorizo con ensalada"); }
    @Override
    public void buildBebida() { pedido.setBebida("Copa de vino tinto"); }
    @Override
    public void buildPostre() { pedido.setPostre("Flan mixto"); }
    @Override
    public Pedido getPedido() { return pedido; }
}

// 4. DIRECTOR: Controla el proceso de construcción usando la interfaz Builder.
class Mesero {
    private PedidoBuilder builder;

    public void setBuilder(PedidoBuilder builder) {
        this.builder = builder;
    }

    // Este método define la secuencia de construcción para cada objeto
    public void construirPedido() {
        builder.buildPlatoPrincipal();
        builder.buildBebida();
        builder.buildPostre();
    }
}