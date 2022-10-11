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
    void testGetName() {
        assertEquals("cheese slice", testItem.getName());
    }
}
