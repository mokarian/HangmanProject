package Player;


import javax.swing.*;
import java.util.Scanner;

public class Chooser extends Player {
    private String word;
    private ChooserState state;

    public Chooser() {
        startGame();
    }

    public void choose() {
        this.state = ChooserState.CHOOSING;
        final String passwd;
        final String message = "Hello Chooser\n Please choose a word:";
        if (System.console() == null) {
            final JPasswordField pf = new JPasswordField();
            passwd = JOptionPane.showConfirmDialog(null, pf, message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(pf.getPassword()) : "";
        } else passwd = new String(System.console().readPassword("%s> ", message));
        setWord(passwd);
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
