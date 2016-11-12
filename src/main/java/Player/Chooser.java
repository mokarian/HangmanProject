package Player;


import java.util.Scanner;

public class Chooser extends Player {
    private String word;
    private ChooserState state;

    public Chooser() {
        startGame();
    }

    public void choose() {
        this.state = ChooserState.CHOOSING;
        System.out.println("Hello Chooser");
        System.out.println("Please choose a word:");
        setWord(this.chooseWord());
    }

    private void startGame() {
        this.state = ChooserState.PLAYING;
    }

    public void endGame() {
        this.state = ChooserState.NOT_PLAYING;
    }

    public String getWord() {
        return word;
    }

    public void setWord(final String word) {
        this.word = word;
    }


    public String chooseWord() {

        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
