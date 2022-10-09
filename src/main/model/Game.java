package model;

import java.util.ArrayList;

// represents a game with list of Progress, list of Items,
public class Game {
    private String progress;
    private ArrayList<Game> myProgress  = new ArrayList<Game>();
    private String item;

    public String getProgress() {
        return progress;
    }

    public String getItem() {
        return item;
    }
}
