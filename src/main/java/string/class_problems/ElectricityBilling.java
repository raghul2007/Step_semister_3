package string.class_problems;

import java.util.Scanner;

public class ElectricityBilling {

    abstract static class Connection {
        int units;

        Connection(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class Home extends Connection {
        Home(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            }

            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    static class Shop extends Connection {
        Shop(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return units * 8.0 + 100;
        }
    }

    static class Factory extends Connection {
        Factory(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return Math.max(units * 6.0, 1000.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;

                case "SHOP":
                    connection = new Shop(units);
                    break;

                case "FACTORY":
                    connection = new Factory(units);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid connection type");
            }

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}