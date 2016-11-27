import Player.Chooser;
import Player.Guesser;
import Support.GameDifficulty;

import javax.swing.*;
import java.io.Console;
import java.io.IOException;


public class Controller {

    public static void main(final String[] args) throws IOException {
        final Guesser  guesser = new Guesser();
        final Chooser  chooser = new Chooser();
        new Screen().hangman();
        chooser.choose();
        Runtime.getRuntime().exec("clear");
        final GameDifficulty difficulty = guesser.getDifficulty();
        final Game game = new Game(difficulty, chooser);
        boolean guesserWon = game.StartGame();
        guesser.checkResult(guesserWon);
        chooser.endGame();

    }


}
