package org.example;

public class Robot implements Observer, StorageManager {
    private Storage storage;

    public Robot(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void update(Order order) {
        System.out.println("Robot received new order: " + order.getOrderId() + " (" + order.getType() + ")");
        if (order.getType() == OrderType.PURCHASE) {
            processPurchaseOrder(order);
        } else if (order.getType() == OrderType.RESTOCK) {
            processRestockOrder(order);
        }
    }

    private void processPurchaseOrder(Order order) {
        for (Item item : order.getItems()) {
            takeFromStorage(item);
            if (item.getGroup() == Group.INSTRUMENTS) {
                putToStorage(item);
            }
        }
    }
    
    private void processRestockOrder(Order order) {
        for (Item item : order.getItems()) {
            addToStorage(item);
        }
    }

    @Override
    public void takeFromStorage(Item item) {
        Item fetchedItem = storage.getItem(item.getName(), item.getAmount());
        if (fetchedItem != null) {
            System.out.println("Robot took from storage: " + fetchedItem);
        }
    }

    @Override
    public void putToStorage(Item item) {
        if (item.getGroup() == Group.INSTRUMENTS) {
            storage.updateItem(item.getName(), item.getAmount());
            System.out.println("Robot returned Instruments to storage: " + item);
        } else {
            System.out.println("Spendthrift items are not returned: " + item);
        }
    }

    public void addToStorage(Item item) {
        storage.addItem(item);
        System.out.println("Robot added to storage: " + item);
    }
}
