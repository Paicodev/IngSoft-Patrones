public abstract class PlayerDecorator implements Player {
    //espera en su constructor una instancia de jugador para ser decorada
    protected Player player;

    public PlayerDecorator(Player player) {
        this.player = player;
    }

    abstract public String attack();
}
//es abstracto ya qeu tiene que ser immplementado por las subclases