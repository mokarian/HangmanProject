package Player;

import java.util.Scanner;

public class Player {

    private PlayerState state;

    public PlayerState getState() {
        return state;
    }

    public void setState(final PlayerState state) {
        this.state = state;
    }

    public String scan() {

        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
