package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {
    private GameData testGameData;
    private Item item1;
    private Item item2;
    private List<Item> baselineList;

    @BeforeEach
    void runBefore() {
        testGameData = new GameData("a0a");
        item1 = new Item("tester", 1, 1);
        item2 = new Item("tester2", 2, 2);
        baselineList = new ArrayList<>();
        baselineList.add(item1);
        baselineList.add(item2);
    }

    @Test
    void testConstructor() {
    assertEquals("a0a", testGameData.getProgress());
    }

    @Test
    void testGameItems() {
        testGameData.addItem(item1);
        testGameData.addItem(item2);
        assertEquals(baselineList, testGameData.getItems());
    }

    @Test
    void testSetProgress() {
        testGameData.setProgress("tester");
        assertEquals("tester", testGameData.getProgress());
    }
}