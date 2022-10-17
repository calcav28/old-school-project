package model;

//Represents an item with 3 properties:
public class Item {
    private String name;   // the name of the item
    private int damage;    // the amount of damage the item can do
    private int weight;    // the amount the item weighs

    //EFFECTS: constructs an item
    public Item(String itemName, int itemDamage, int itemWeight) {
        name = itemName;
        damage = itemDamage;
        weight = itemWeight;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getWeight() {
        return weight;
    }
}
