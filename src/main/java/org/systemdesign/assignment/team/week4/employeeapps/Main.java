package org.systemdesign.assignment.team.week4.employeeapps;

import java.text.DecimalFormat;
public class Main {

    public static void main(String[] args) {
        Employee ani = new PermanentEmployee("Ani", "BN0001", "Finance Staff", 170);
        Employee budi = new ContractEmployee("Budi", "BN0002", "IT Support", 170);

        ani.displaySalaryInfo();
        budi.displaySalaryInfo();
    }
}

abstract class Employee {
    protected String name;
    protected String employeeID;
    protected String position;

    public Employee(String name, String employeeID, String position) {
        this.name = name;
        this.employeeID = employeeID;
        this.position = position;
    }

    public abstract String getEmployeeType();
    public abstract double calculateBenefit();
    public abstract double calculateBaseSalary();
    public abstract double calculateTotalSalary();

    public void displaySalaryInfo() {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        System.out.println("Informasi Gaji Karyawan:");
        System.out.println("Nama: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Posisi: " + position);
        System.out.println("Status: " + getEmployeeType());
        System.out.println("Gaji Pokok : Rp " + df.format(calculateBaseSalary()));
        System.out.println("Tunjangan : Rp " + df.format(calculateBenefit()));
        System.out.println("Total Gaji : Rp " + df.format(calculateTotalSalary()));
        System.out.println("====================================");
    }
}

class PermanentEmployee extends Employee {
    private static final double HOURLY_RATE = 50000.00;
    private static final double PERMANENT_ALLOWANCE = 2500000.00;
    private Double baseSalary;
    private int workHours;

    public PermanentEmployee(String name, String employeeID, String position, int workHours) {
        super(name, employeeID, position);
        this.workHours = workHours;
    }

    @Override
    public String getEmployeeType() {
        return "Karyawan Tetap";
    }

    @Override
    public double calculateBenefit() {
        return PERMANENT_ALLOWANCE;
    }

    public double calculateBaseSalary() {
        baseSalary = HOURLY_RATE * workHours;
        return baseSalary;
    }

    public double calculateTotalSalary() {
        return baseSalary + PERMANENT_ALLOWANCE;
    }
}

class ContractEmployee extends Employee {
    private static final double HOURLY_RATE = 30000.00;
    private static final double CONTRACT_ALLOWANCE = 2000000.00;
    private Double baseSalary;
    private int workHours;


    public ContractEmployee(String name, String employeeID, String position, int workHours) {
        super(name, employeeID, position);
        this.workHours = workHours;
    }

    @Override
    public String getEmployeeType() {
        return "Karyawan Kontrak";
    }

    @Override
    public double calculateBenefit() {
        return CONTRACT_ALLOWANCE;
    }

    public double calculateBaseSalary() {
        baseSalary = HOURLY_RATE * workHours;
        return baseSalary;
    }

    public double calculateTotalSalary() {
        return baseSalary + CONTRACT_ALLOWANCE;
    }
}
