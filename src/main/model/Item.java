package model;

import org.json.JSONObject;
import persistence.Writable;

//toJSON method is modelled by code from:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//Represents an item with 3 properties:
public class Item implements Writable {
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

    //REQUIRES: mobHealth >= 0
    //EFFECTS: reduces mob health by item's damage
    // if item would overkill mob, automatically makes mob health = 0
    // otherwise just reduces mobs health
    public int hitEnemy(int mobHealth) {
        if (getDamage() >= mobHealth) {
            return 0;
        } else {
            return mobHealth - getDamage();
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("itemName", name);
        json.put("itemDamage", damage);
        json.put("itemWeight", weight);
        return json;
    }

    public int getWeight() {
        return weight;
    }
}
