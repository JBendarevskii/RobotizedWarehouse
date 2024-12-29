package org.example;

import java.util.Arrays;

public class User {
    private String name;
    private OrderList orderList;

    public User(String name, OrderList orderList) {
        this.name = name;
        this.orderList = orderList;
    }

    public void createPurchaseOrder(String orderId, Item... items) {
        Order order = new Order(orderId, OrderType.PURCHASE, Arrays.asList(items));
        System.out.println(name + " created a PURCHASE order: " + order);
        orderList.addOrder(order);
    }

    public void createRestockOrder(String orderId, Item... items) {
        Order order = new Order(orderId, OrderType.RESTOCK, Arrays.asList(items));
        System.out.println(name + " created a RESTOCK order: " + order);
        orderList.addOrder(order);
    }
}
