package org.systemdesign.assignment.team.week3.oop.inventory;

public class Inventory {
    public static void main(String[] args) {
        InventoryInformation computerInfo = new InventoryInformation("computer","Good", 1, "West Jakarta");
        InventoryOperation computer = new InventoryOperation(computerInfo);
        computer.CheckCondition();
        computer.traceLocation();
        System.out.println(computer.checkAvailability(true));
    }
}


class InventoryInformation {
    private String name;
    private String condition;
    private int age;
    private String storageLocation;

    InventoryInformation(String name, String condition, int age, String storageLocation ) {
        this.name = name;
        this.condition = condition;
        this.age = age;
        this.storageLocation = storageLocation;
    }

    public String getCondition() {
        return condition;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public String getName() {
        return name;
    }
}
class InventoryOperation {
    private Boolean isAvailable;

    private InventoryInformation inventoryInformation;
    InventoryOperation(InventoryInformation inventoryInformation) {
        this.inventoryInformation = inventoryInformation;
    }

    public void CheckCondition(){
        System.out.println("The " +inventoryInformation.getName()+ " inventory condition is " + inventoryInformation.getCondition());
    }

    public void traceLocation(){
        System.out.println("The "+ inventoryInformation.getName() +" inventory storage location in " + inventoryInformation.getStorageLocation());
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String checkAvailability(Boolean available) {
        setAvailable(available);
        return getAvailable() ? "The "+  inventoryInformation.getName()+ " inventory is available" : "The "+  inventoryInformation.getName()+ " inventory is not available" ;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}


