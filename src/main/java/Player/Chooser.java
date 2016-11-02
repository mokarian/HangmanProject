package Player;


import java.util.Scanner;

public class Chooser extends Player {
    private String word;

    public Chooser() {
        this.setState( PlayerState.PLAYING);
    }

    public void choose() {
        System.out.println("Hello Chooser");
        System.out.println("Please choose a word:");
        setWord(this.scan());

    }

    public String getWord() {
        return word;
    }

    public void setWord(final String word) {
        this.word = word;
    }


    public String scan() {

        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
