package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// represents a game with progress and items
public class GameData {
    // progress is represented with 1 number, a letter, and another number
    // the first number represents what path the player is on
    // the letter represents what stage the player is on
    // the second number represents what choice in the stage the player chooses
    private String progress;

    // constructs a game with 0a0 for progress
    public GameData(String currentStage) {
        progress = currentStage;

    }

    public String getProgress() {
        return progress;
    }

}
