import java.util.Arrays;

public class Screen {

    public void showBlanks(final char[] blanks) {
        System.out.print(showBlanksFromArray(blanks));
        System.out.print("\nGuess a Letter: ");
    }

    public void youGuessedIt(final char[] blanks) {
        System.out.println("You Guessed it!!");
        System.out.println((showBlanksFromArray(blanks)));
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
}
