package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException{
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter department's name: ");
        String department = scan.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Level: ");
        String wL = scan.nextLine();
        System.out.print("Base Salary: ");
        double salary = scan.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(wL), salary, new Department(department));
        System.out.print("HOW MANY CONTRACTS TO THIS WORKER? ");
        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < n; i++){
            System.out.printf("Enter contract #%d data",i+1);
            System.out.println();
            System.out.print("Date (DD/MM/YYYY) : ");
            Date contractDate = sdf.parse(scan.next());
            System.out.print("Value per hour: ");
            double valuePerHour = scan.nextDouble();
            System.out.print("Duration(Hours)");
            int duration = scan.nextInt();
            scan.nextLine();
            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContract(contract);
        }
        System.out.print("Enter month and year to calculate income (MM/YYYY) ");
        String monthAndYear = scan.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println();

        System.out.printf("Name: %s%n",name);
        System.out.printf("Department: %s%n",worker.getDepartment().getName());
        System.out.printf("Income for %s: %.2f",monthAndYear, worker.income(year, month));
    }
}
