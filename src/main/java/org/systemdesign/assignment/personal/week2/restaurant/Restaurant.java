package org.systemdesign.assignment.personal.week2.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        customer customer = new CustomerDineIn("Denta Muhajir");
        customer.orderMenu("Nasi Goreng");
        customer.orderMenu("Es Teh");

        Server server = new Waiter();
        Kitchen kitchen = new Chef();
        List <String> foodReady = new ArrayList<>();
        for(String order: ((CustomerDineIn) customer).getOrder()) {

            foodReady.add(kitchen.makeFood(order));
        }

        server.serveFood(foodReady);

        customer.payBills();
    }
}

interface customer {
    void orderMenu(String menu);
    void  payBills();
}

interface Server {
    void serveFood(List order);
}

interface Kitchen {
    String makeFood(String order);
}

class Chef implements Kitchen {
    @Override
    public String makeFood(String order) {
        String foodFinished = order;
        System.out.println("Chef cooking a " + order);
        return foodFinished;
    }
}
class Waiter implements Server {
    //    List order = new ArrayList();
//    public Waiter(List order) {
//        this.order = order;
//    }
    @Override
    public void serveFood(List order) {
        System.out.println("Waiter serving order " + order + " to customer");
    }
}
class CustomerDineIn implements customer {
    String name = "";
    public CustomerDineIn(String name) {
        this.name = name;
    }
    List <String>order = new ArrayList();
    @Override
    public void orderMenu(String menu) {
        order.add(menu);
        System.out.println("Customer " + name + " ordering a menu : " + menu);
    }

    public List<String> getOrder() {
        return order;
    }

    @Override
    public void payBills() {
        System.out.println("Customer " + name + " pay bills");
    }
}


