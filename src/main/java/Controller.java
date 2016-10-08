import Player.Chooser;
import Player.Guesser;
import Player.Player;
import Support.GameDifficulty;


public class Controller {

    public static void main(final String[] args) {
        System.out.print("Start");
        final Guesser guesser = (Guesser) new Player();
        final Chooser chooser = (Chooser) new Player();
        chooser.choose();
        final GameDifficulty difficulty = guesser.getDifficulty();
        final Game game = new Game(difficulty, chooser);
        game.StartGame();
    }


}
