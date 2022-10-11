package model;

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
