package model;


import java.util.ArrayList;
import java.util.List;

// represents a game with progress
public class GameData {
    // progress is represented with 3 numbers
    // the first number represents what path the player is on
    // the second number represents what stage the player is on
    // the third number represents what choice in the stage the player chooses
    // example: "p1s1c1" is the first path in the first stage with player choosing choice 1
    private String progress;
    private List<Item> items;

    //EFFECTS: constructs game data with an empty list and empty progress
    public GameData(String currentStage) {
        this.progress = currentStage;
        items = new ArrayList<>();
    }

    //EFFECTS: returns items
    public List<Item> getItems() {
        return items;
    }

    //EFFECTS: adds an item to a list of items
    //MODIFIES: item
    public void addItem(Item item) {
        items.add(item);
    }

    public String getProgress() {
        return progress;
    }

}
