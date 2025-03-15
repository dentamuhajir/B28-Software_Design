package org.systemdesign.assignment.team.week3;

import java.sql.SQLOutput;

public class Inventory {
    public static void main(String[] args) {
        InventoryInformation computerInfo = new InventoryInformation("Good", 1, "West Jakarta");
        InventoryOperation computer = new InventoryOperation(computerInfo);
        computer.CheckCondition();
        computer.trace();
        System.out.println(computer.checkAvailability(true));
    }
}


class InventoryInformation {
    private String condition;
    private int age;
    private String storageLocation;

    InventoryInformation(String condition, int age, String storageLocation ) {
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
}
class InventoryOperation {
    private Boolean isAvailable;

    private InventoryInformation inventoryInformation;
    InventoryOperation(InventoryInformation inventoryInformation) {
        this.inventoryInformation = inventoryInformation;
    }

    public void CheckCondition(){
        System.out.println("The condition of inventory : " + inventoryInformation.getCondition());
    }

    public void trace(){
        System.out.println("The trace location of inventory : " + inventoryInformation.getStorageLocation());
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String checkAvailability(Boolean available) {
        setAvailable(available);
        if(getAvailable()){
            return "The inventory is available";
        }
        return "The inventory is not available";
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}


