package model;

import java.util.ArrayList;
import java.util.List;


//represents an arbitrary long list of items
public class ItemList {
    List<Item> items;

    //EFFECTS: constructs a list
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
