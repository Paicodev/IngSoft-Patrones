public class PoisonDecorator extends PlayerDecorator {
    public PoisonDecorator(Player player) {
        super(player);
    }

    @Override
    public String attack() {
        return player.attack() + " con veneno";
    }
}
