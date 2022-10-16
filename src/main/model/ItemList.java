package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
    List<String> items = new ArrayList<>();

    public ItemList() {
        items.add("test");
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }
}
