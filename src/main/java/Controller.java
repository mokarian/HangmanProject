import Player.Chooser;
import Player.Guesser;
import Player.Player;
import Support.GameDifficulty;


public class Controller {

    public static void main(final String[] args) {
        System.out.print("Start");
        final Guesser guesser = new Guesser();
        final Chooser chooser = new Chooser();
        chooser.choose();
        final GameDifficulty difficulty = guesser.getDifficulty();
        final Game game = new Game(difficulty, chooser);
        game.StartGame();
    }


}
