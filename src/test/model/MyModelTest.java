package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameData testGameData;
    private Item testItem;

    @BeforeEach
    void runBefore() {
        testGameData = new GameData("a0a"); //add parameters here
        testItem = new Item("cheese slice", 0, 1);
    }

    @Test
    void testConstructor() {

    }
}