package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemListTest {
    private ItemList itemListTest;
    List<Item> itemListBenchmark;

    @BeforeEach
    void runBefore() {
        itemListTest = new ItemList();
        itemListBenchmark = new ArrayList<>();
        Item test1 = new Item("test1", 1, 1);
        Item test2 = new Item("test2", 2, 2);
        itemListTest.addItem(test1);
        itemListTest.addItem(test2);
        itemListBenchmark.add(test1);
        itemListBenchmark.add(test2);
    }

    @Test
    void testConstructor() {
        assertFalse(itemListTest.getItems().isEmpty());
        assertEquals(itemListBenchmark, itemListTest.getItems());
    }
}
