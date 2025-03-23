package org.systemdesign.assignment.team.week4.refactoremployee;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Employee ani = new PermanentEmployee("Ani", "BN0001", "Finance Staff", 170);
        Employee budi = new ContractEmployee("Budi", "BN0002", "IT Support", 150);
        ani.displaySalaryInfo();
        budi.displaySalaryInfo();
    }

}

abstract class Employee {
    protected String name;
    protected String employeeID;
    protected String position;

    // penambahan properti workHours yang dikirim dari subclass
    protected int workHours;

    public Employee(String name, String employeeID, String position, int workHours) {
        this.name = name;
        this.employeeID = employeeID;
        this.position = position;
        this.workHours = workHours;
    }

    public abstract String getEmployeeType();
    public abstract double getHourlyRate();

    // merefactor method public abstract double calculateAllowance() diganti ke getAllowance karena sebelumnya kurang cocok tidak ada operasi perhitungan
    public abstract double getAllowance();


    // Merefactor method public abstract double calculateBaseSalary() diganti dengan method public
    // Mengirimkan parameter properti workHours yang didapat dari constructor dan method getHourlyRate
    public double calculateBaseSalary() {
        return PayrollCalculator.calculateBaseSalary(workHours, getHourlyRate());
    }

    // merefactor public abstract double calculateTotalSalary() diganti dengan method public
    // mengirim parameter method calculateBaseSalary dan getAllowance yang dapatnya didapat dari subclass
    public double calculateTotalSalary() {
        return PayrollCalculator.calculateTotalSalary(calculateBaseSalary(), getAllowance());
    }

    public void displaySalaryInfo() {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        System.out.println("Informasi Gaji Pegawai:");
        System.out.println("Nama: " + name);
        System.out.println("ID Pegawai: " + employeeID);
        System.out.println("Posisi: " + position);
        System.out.println("Status: " + getEmployeeType());
        System.out.println("Gaji Pokok : Rp " + df.format(calculateBaseSalary()));
        // mengganti calculateAllowance dengan getAllowance()
        //System.out.println("Tunjangan : Rp " + df.format(calculateAllowance()));
        System.out.println("Tunjangan : Rp " + df.format(getAllowance()));

        System.out.println("Total Gaji : Rp " + df.format(calculateTotalSalary()));
        System.out.println("====================================");
    }
}
class PayrollCalculator {
    public static double calculateBaseSalary(int workHours, double hourlyRate) {
        return workHours * hourlyRate;
    }

    public static double calculateTotalSalary(double baseSalary, double allowance) {
        return baseSalary + allowance;
    }
}
class PermanentEmployee extends Employee {
    private static final double HOURLY_RATE = 50000.00;
    private static final double PERMANENT_ALLOWANCE = 2500000.00;
    private Double baseSalary;
    private int workHours;

    public PermanentEmployee(String name, String employeeID, String position, int workHours) {
        // Kita tambahkan workHours ke class parent agar bisa digunakan dioperasi Class PayrollCalculator
        super(name, employeeID, position, workHours);
        this.workHours = workHours;
    }

    @Override
    public String getEmployeeType() {
        return "Pegawai Tetap";
    }

    // Pembuatan getter function untuk mengambil konstanta upah per jam
    @Override
    public double getHourlyRate() {
        return HOURLY_RATE;
    }
    //    Merefactor method calculateAllowance karena tidak ada operasi perhitungan diganti dengan getAllowance untuk sebagai getter dari konstanta value tunjangan
    @Override
    public double getAllowance() {
        return PERMANENT_ALLOWANCE;
    }

//    @Override
//    public double calculateAllowance() {
//        return PERMANENT_ALLOWANCE;
//    }


    // Menghapus method calculateBaseSalary() dan calculateTotalSalary() yang sekarang kedua metode tersebut dikelola di class PayrollCalculator
    // Sehingga mengurangi duplikasi code di subclass
//    @Override
//    public double calculateBaseSalary() {
//        baseSalary = HOURLY_RATE * workHours;
//        return baseSalary;
//    }
//    @Override
//    public double calculateTotalSalary() {
//        return calculateBaseSalary() + calculateAllowance();
//    }
}

class ContractEmployee extends Employee {
    private static final double HOURLY_RATE = 30000.00;
    private static final double CONTRACT_ALLOWANCE = 2000000.00;
    private Double baseSalary;

    //private int workHours;


    public ContractEmployee(String name, String employeeID, String position, int workHours) {
        super(name, employeeID, position, workHours);
        // menghapus properti workHour karena sudah tidak dibutuhkan di dalam subclass
//        this.workHours = workHours;
    }

    @Override
    public String getEmployeeType() {
        return "Pegawai Kontrak";
    }

    // Pembuatan getter function untuk mengambil konstanta upah per jam
    @Override
    public double getHourlyRate() {
        return HOURLY_RATE;
    }
    //    Merefactor method calculateAllowance karena tidak ada operasi perhitungan diganti dengan getAllowance untuk sebagai getter dari konstanta value tunjangan
    @Override
    public double getAllowance() {
        return CONTRACT_ALLOWANCE;
    }

//    @Override
//    public double calculateAllowance() {
//        return CONTRACT_ALLOWANCE;
//    }

//    @Override
//    public double calculateBaseSalary() {
//        baseSalary = HOURLY_RATE * workHours;
//        return baseSalary;
//    }
//    @Override
//    public double calculateTotalSalary() {
//        return calculateBaseSalary() + calculateAllowance();
//    }
}
