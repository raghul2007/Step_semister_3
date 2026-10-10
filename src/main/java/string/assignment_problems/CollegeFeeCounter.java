package string.assignment_problems;

import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double getTransportFee();
    }

    abstract static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateFee();
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        @Override
        public double getTransportFee() {
            return 12000.0;
        }

        @Override
        double calculateFee() {
            return 40000 + getTransportFee();
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double calculateFee() {
            return 40000 + 60000;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        @Override
        public double getTransportFee() {
            return 12000.0;
        }

        @Override
        double calculateFee() {
            return 20000 + getTransportFee();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}