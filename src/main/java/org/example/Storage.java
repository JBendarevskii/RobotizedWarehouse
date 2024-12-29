package org.example;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        if (inventory.containsKey(item.getName())) {
            Item existingItem = inventory.get(item.getName());
            existingItem.setAmount(existingItem.getAmount() + item.getAmount());
            System.out.println("Updated item in storage: " + existingItem);
        } else {
            inventory.put(item.getName(), item);
            System.out.println("Added new item to storage: " + item);
        }
    }

    public void updateItem(String itemName, int amount) {
        if (inventory.containsKey(itemName)) {
            Item item = inventory.get(itemName);
            item.setAmount(item.getAmount() + amount);
            System.out.println("Storage updated: " + item);
        } else {
            System.out.println("Item not found in storage: " + itemName);
        }
    }

    public Item getItem(String itemName, int amount) {
        if (inventory.containsKey(itemName)) {
            Item item = inventory.get(itemName);
            if (item.getAmount() >= amount) {
                item.setAmount(item.getAmount() - amount);
                return new Item(item.getName(), item.getGroup(), amount);
            } else {
                System.out.println("Not enough stock for item: " + itemName);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return inventory.toString();
    }
}
