import java.util.Arrays;

public class Screen {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void showBlanks(final char[] blanks) {
        System.out.print(showBlanksFromArray(blanks));
        System.out.print("\nGuess a Letter: ");
    }

    public void youGuessedIt(final char[] blanks) {
        System.out.println("You Guessed it!!");
        System.out.println((showBlanksFromArray(blanks)));
    }

    public void youGuessedIt() {
        System.out.println("You Guessed it!!");
    }


    private String showBlanksFromArray(final char[] blanks) {
        return Arrays.toString(blanks);
    }

    public void youLost() {
        System.out.println("You are out of Guesses, Please try again later");
    }

    public void guessesRemaining(final int guesses) {
        System.out.println(guesses + " guesses remaining\n");
    }

    public void oneLetterWarning() {
        System.out.println("Please try one guess at a time.");
    }

    public void wrongLetter() {
        System.out.println("the entered letter is WRONG! ");
    }
    public void hangman(){
        System.out.println("---------  :WELCOME TO HANGMAN GAME:  ---------");

    }
}
