public class Juego {

    public static void main(String[] args) {
        Player player = new BasicPlayer();
        System.out.println(player.attack());

        Player firePlayer = new FireDecorator(player);
        System.out.println(firePlayer.attack());

        Player poisonPlayer = new PoisonDecorator(player);
        System.out.println(poisonPlayer.attack());
    }
}
