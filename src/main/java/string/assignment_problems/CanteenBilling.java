package string.assignment_problems;

import java.util.Scanner;

abstract class Customer {

    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {

    public Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {

    public Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {

    public Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student(amount);
            } else if (type.equals("STAFF")) {
                customer = new Staff(amount);
            } else {
                customer = new Guest(amount);
            }

            double finalAmount =
                    customer.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                type,
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}