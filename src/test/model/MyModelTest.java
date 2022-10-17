package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {
    private GameData testGameData;

    @BeforeEach
    void runBefore() {
        testGameData = new GameData("a0a"); //add parameters here
    }

    @Test
    void testConstructor() {
    assertEquals("a0a", testGameData.getProgress());
    }
}