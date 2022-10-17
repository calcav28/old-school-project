package model;


// represents a game with progress
public class GameData {
    // progress is represented with 1 number, a letter, and another number
    // the first number represents what path the player is on
    // the letter represents what stage the player is on
    // the second number represents what choice in the stage the player chooses
    private String progress;

    // constructs the progress
    public GameData(String currentStage) {
        progress = currentStage;
    }

    public String getProgress() {
        return progress;
    }

}
