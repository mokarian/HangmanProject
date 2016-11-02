import Player.Chooser;
import Player.Guesser;
import Player.PlayerState;
import Support.GameDifficulty;
import Support.GameState;


public class Controller {

    public static void main(final String[] args) {
        final Guesser  guesser = new Guesser();
        final Chooser  chooser = new Chooser();
        chooser.choose();
        final GameDifficulty difficulty = guesser.getDifficulty();
        final Game game = new Game(difficulty, chooser);
        game.StartGame();
        guesser.setState(PlayerState.NOT_PLAYING);
        chooser.setState(PlayerState.NOT_PLAYING);
    }


}
