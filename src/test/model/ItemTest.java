package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item testItem;

    @BeforeEach
    void runBefore() {
        testItem = new Item("cheese slice", 0, 1);
    }

    @Test
    void testConstructor() {
        assertEquals("cheese slice", testItem.getName());
        assertEquals(0, testItem.getDamage());
        assertEquals(1, testItem.getWeight());
        assertEquals(3, testItem.hitEnemy(3));
        assertEquals(0, testItem.hitEnemy(0));
    }
}
