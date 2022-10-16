package model;

import model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
    List<Item> items;

    public ItemList() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
