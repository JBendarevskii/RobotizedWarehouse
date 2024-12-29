package org.example;

import java.util.List;

public class Order {
    private String orderId;
    private OrderType type;
    private List<Item> items;

    public Order(String orderId, OrderType type, List<Item> items) {
        this.orderId = orderId;
        this.type = type;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderType getType() {
        return type;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Type: " + type + ", Items: " + items;
    }
}
