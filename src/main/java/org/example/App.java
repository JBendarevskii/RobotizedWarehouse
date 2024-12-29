package org.example;

public class App
{
    public static void main(String[] args) {
        System.out.println();
        Storage storage = new Storage();
        OrderList orderList = new OrderList();

        Robot robot = new Robot(storage);
        orderList.addObserver(robot);

        User user = new User("Yaroslav", orderList);

        user.createRestockOrder("R001",
                new Item("Hammer", Group.INSTRUMENTS, 10),
                new Item("Nails", Group.SPENDTHRIFT, 100)
        );

        user.createPurchaseOrder("P001",
                new Item("Hammer", Group.INSTRUMENTS, 2),
                new Item("Nails", Group.SPENDTHRIFT, 50)
        );

        System.out.println("Final Storage State: " + storage);
    }
}
