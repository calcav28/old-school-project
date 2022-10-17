package model;

/*
Represents an item with 3 properties:
String name: the name of the item
int damage: the amount of damage the item can do
int weight: the amount the item weighs
*/


public class Item {
    private String name;
    private int damage;
    private int weight;

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
