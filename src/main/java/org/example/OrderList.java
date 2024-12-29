package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orders = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("New order added: " + order);
        notifyObservers(order);
    }

    private void notifyObservers(Order order) {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}
