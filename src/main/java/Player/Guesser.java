package Player;

import Support.GameDifficulty;


public class Guesser extends Player {

    public Guesser() {
        this.setState(PlayerState.PLAYING);
    }

    public void guess() {
        //TODO guess
    }

    public GameDifficulty getDifficulty() {
        while (true) {
            GameDifficulty difficulty_return = null;
            System.out.println("Please choose game difficulty:");
            System.out.println("Easy");
            System.out.println("Normal");
            System.out.println("Hard");
            final String difficulty = this.scan();
            if ((difficulty_return = isValidDifficultyType(difficulty))!=null) {
                return difficulty_return;
            } else {
                System.out.println("The prompted game difficulty is not valid, try again");
            }
        }
    }

    private GameDifficulty isValidDifficultyType(final String difficulty) {

        if (difficulty.equalsIgnoreCase(GameDifficulty.EASY.name())) {
            return GameDifficulty.EASY;
        }
        if (difficulty.equalsIgnoreCase(GameDifficulty.NORMAL.name())) {
            return GameDifficulty.NORMAL;
        }
        if (difficulty.equalsIgnoreCase(GameDifficulty.HARD.name())) {
            return GameDifficulty.HARD;
        } else {
            return null;
        }
    }


}
