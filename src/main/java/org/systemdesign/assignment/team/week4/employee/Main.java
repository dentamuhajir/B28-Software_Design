package org.systemdesign.assignment.team.week4.employee;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Employee employeeAna = new Employee("Ana", "BN0001", "Finance", Status.PERMANENT);
        SalaryServiceImpl employeeSalaryAna = new SalaryServiceImpl(employeeAna);
        employeeSalaryAna.displayInfoSalary();

        Employee employeeBudi = new Employee("Budi", "BN0002","IT Support", Status.CONTRACT);
        SalaryServiceImpl employeeSalaryBudi = new SalaryServiceImpl(employeeBudi);
        employeeSalaryBudi.displayInfoSalary();
    }
}

interface SalaryService {
    void salaryCalculation();
    void setSalaryBasedOnStatus();
    void displayInfoSalary();
}

class SalaryServiceImpl implements SalaryService {

    private Employee employee;
    private Double baseSalary;
    private Double benefit;
    private Double salary;
    public SalaryServiceImpl(Employee employee) {
        this.employee = employee;
        setSalaryBasedOnStatus();
        salaryCalculation();
    }
    @Override
    public void salaryCalculation() {
        setSalary(getBaseSalary() + getBenefit());
    }

    @Override
    public void setSalaryBasedOnStatus() {
        switch(employee.getStatus()) {
            case CONTRACT:
                setBaseSalary(18000000.00);
                setBenefit(2000000.00);
                break;
            default:
                setBaseSalary(22000000.00);
                setBenefit(4000000.00);
        }
    }

    @Override
    public void displayInfoSalary() {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        System.out.println("Informasi Gaji Karyawan: ");
        System.out.println("Nama: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Posisi: " + employee.getPosition());
        System.out.println("Status: " + (employee.getStatus().equals(Status.PERMANENT) ? "Karyawan Tetap" : "Karyawan Kontrak") );
        System.out.println("Gaji : Rp " + df.format(getSalary()));
        System.out.println("====================================");
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Double getBenefit() {
        return benefit;
    }

    public Double getSalary() {
        return salary;
    }
}

enum Status {
    PERMANENT,
    CONTRACT
}
class Employee {
    private String name;
    private String employeeID;
    private String position;
    private Status status;

    public Employee (String name, String employeeID, String position, Status status){
        this.name = name;
        this.employeeID = employeeID;
        this.position = position;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public Status getStatus() {
        return status;
    }
    public String getPosition() {
        return position;
    }
}
