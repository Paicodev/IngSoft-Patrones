public class FireDecorator extends PlayerDecorator {
    public FireDecorator(Player player) {
        super(player);
    }

    @Override
    public String attack() {
        return player.attack() + " con fuego";
    }

}
