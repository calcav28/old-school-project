package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//tests are modelled after tests in JsonWriterTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonWriterTest {

    protected void checkItem(String itemName, int itemDamage, int itemWeight, Item item) {
        assertEquals(itemName, item.getName());
        assertEquals(itemDamage, item.getDamage());
        assertEquals(itemWeight, item.getWeight());
    }


    @Test
    void testWritingGeneralGame() {
        try {
            GameData gd = new GameData("test1");
            gd.addItem(new Item("testname1", 1, 1));
            gd.addItem(new Item("testname2", 2, 2));
            JsonWriter writer = new JsonWriter("./data/testWritingGeneralGame.json");
            writer.open();
            writer.write(gd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWritingGeneralGame.json");
            gd = reader.read();
            assertEquals("test1", gd.getProgress());
            List<Item> items = gd.getItems();
            assertEquals(2, items.size());
            checkItem("testname1", 1, 1, items.get(0));
            checkItem("testname2", 2, 2, items.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
