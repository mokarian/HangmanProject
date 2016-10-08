import Player.Chooser;
import Support.GameDifficulty;
import Support.GameState;

public class Game {
    private final Screen screen;
    private final GameDifficulty gameDifficulty;
    private final String word;
    public char[] wordArr;
    public char[] blanks;
    private GameState gameState;
    private int guesses;

    public Game(final GameDifficulty gameDifficulty, final Chooser chooser) {
        this.setGameState(GameState.NOT_STARTED);
        this.gameDifficulty = gameDifficulty;
        this.blanks = new char[chooser.getWord().length()];
        this.word = chooser.getWord();
        this.wordArr = chooser.getWord().toCharArray();
        this.guesses = (int) (chooser.getWord().length() * getDifficultyFactor(gameDifficulty));
        this.screen = new Screen();
    }

    private double getDifficultyFactor(final GameDifficulty gameDifficulty) {
        if (gameDifficulty == GameDifficulty.EASY) {
            return 2;
        } else if (gameDifficulty == GameDifficulty.NORMAL) {
            return 1.5;
        } else if (gameDifficulty == GameDifficulty.HARD) {
            return 1;
        } else {
            return 1;
        }
    }

    public void StartGame() {
        this.setGameState(GameState.IN_PROGRESS);
        Start();
    }

    public void endGame() {
        //TODO EndGAme
        this.setGameState(GameState.FINISHED);
    }

    public void setGameState(final GameState gameState) {
        this.gameState = gameState;
    }

    public void newGame() {
        for (int i = 0; i < blanks.length; i++) {
            blanks[i] = '_';
        }
    }

    public void Start() {
        final Reader reader = new Reader();
        newGame();
        do {
            screen.showBlanks(blanks);
            final String letterGuessed = reader.scan();
            final char letterGuess = letterGuessed.charAt(0);
            if (letterGuessed.length() > 1) {
                screen.oneLetterWarning();
            }
            for (int j = 0; j < wordArr.length; j++) {
                if (wordArr[j] == letterGuess) {
                    blanks[j] = letterGuess;
                }
            }
            boolean contains = false;
            for (final char c : wordArr) {
                if (c == letterGuess) {
                    contains = true;
                }
            }
            if (!contains) {
                screen.wrongLetter();
            }
            guesses--;
            screen.guessesRemaining(guesses);
        } while (guesses > 0 && (new String(blanks).contains("_")));

        if (guesses >= 0 && !(new String(blanks).contains("_"))) {
            screen.youGuessedIt(blanks);
            endGame();
        } else {
            screen.youLost();
            endGame();
        }
    }


}
