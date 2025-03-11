package org.systemdesign.explore;

public class differentInterfaceAndInheritance {
    public static void main(String[] args) {
        Stratocaster strat = new Stratocaster();
        strat.type(); // get method from superclass
        strat.price(); // get method from subclass
        strat.guitarString();
        strat.pick();
    }
}


interface accessoris {
    void pick();
    void guitarString();
}
class Guitar implements accessoris {
    String name;

    void type() {
        System.out.println("Acoustic guitar");
    }

    @Override
    public void pick() {
        System.out.println("pick from interface");
    }

    @Override
    public void guitarString() {
        System.out.println("guitar string from interface");
    }
}

class Stratocaster extends Guitar {
    void price() {
        System.out.println("The price is USD 1000");
    }

    public void pick() {
        System.out.println("Pick interface from subclass");
    }
}