package org.example;

public class Item {
    private String name;
    private Group group;
    private int amount;

    public Item(String name, Group group, int amount) {
        this.name = name;
        this.group = group;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " (" + group + ", Amount: " + amount + ")";
    }
}
