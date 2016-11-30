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
    private Reader reader;

    public Game(final GameDifficulty gameDifficulty, final Chooser chooser) {
        this.gameState = GameState.NOT_STARTED;
        this.gameDifficulty = gameDifficulty;
        this.blanks = new char[chooser.getWord().length()];
        this.word = chooser.getWord();
        this.wordArr = chooser.getWord().toCharArray();
        this.guesses = (int) (chooser.getWord().length() * getDifficultyFactor(gameDifficulty));
        this.screen = new Screen();
        this.reader = new Reader();
    }

    private double getDifficultyFactor(final GameDifficulty gameDifficulty) {
        gameState = GameState.SET_DIFFICULTY;
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

    public boolean StartGame() {
        this.setGameState(GameState.IN_PROGRESS);
        return Start();
    }

    public void endGame() {
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

    public boolean Start() {
        newGame();
        boolean guesserWon;
        do {
            screen.showBlanks(blanks);
            final String letterGuessed = reader.getNextCharacter();
            if(letterGuessed.length()>1 && letterGuessed.equalsIgnoreCase(word)){
                screen.guessesRemaining(guesses);
                screen.youGuessedIt();
                endGame();
                return true;
            }
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
            guesserWon=true;
            endGame();
        } else {
            screen.youLost();
            guesserWon=false;
            endGame();
        }
        return guesserWon;
    }


}
