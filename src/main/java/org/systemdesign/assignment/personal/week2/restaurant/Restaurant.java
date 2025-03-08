package org.systemdesign.assignment.personal.week2.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        customer customer = new CustomerDineIn("Denta Muhajir");
        customer.orderMenu("Nasi Goreng");
        customer.orderMenu("Es Teh");

        Server server = new Waiter();

        for(String order: ((CustomerDineIn) customer).getOrder()) {
            System.out.println(order);
        }

        //System.out.println(((CustomerDineIn) customer).getOrder());

//        for(String order : ()) {
//
//        }

//        foreach (order: List customer.getOrder()) {
//
//            System.out.println(order);
//
//        }
    }
}

interface customer {
    void orderMenu(String menu);
    void  payBills();
}

interface Server {
    void serveFood(List order);
}

interface chef {
    void makeFood();
}

class Waiter implements Server {
//    List order = new ArrayList();
//    public Waiter(List order) {
//        this.order = order;
//    }
    @Override
    public void serveFood(List order) {
        System.out.println("Waiter serving a customer order " + order);
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

    }
}


