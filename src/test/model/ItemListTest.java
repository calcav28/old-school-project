package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemListTest {
    private ItemList itemListTest;
    List<Item> itemListBenchmark;
    private Item test1;
    private Item test2;

    @BeforeEach
    void runBefore() {
        itemListTest = new ItemList();
        itemListBenchmark = new ArrayList<>();
        test1 = new Item("test1", 1, 1);
        test2 = new Item("test2", 2, 2);
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
