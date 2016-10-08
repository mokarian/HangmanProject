package Player;


public class Chooser extends Player {
    private String word;

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

}
