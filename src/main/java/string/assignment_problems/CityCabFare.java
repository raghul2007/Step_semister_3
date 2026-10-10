package string.assignment_problems;

import java.util.Scanner;

public class CityCabFare {

    interface NightService {
        double getNightMultiplier();
    }

    abstract static class Cab {
        double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();

        final double calculateFare(String time) {
            double fare = Math.max(100.0, km * getRate());

            if (time.equals("NIGHT") && this instanceof NightService) {
                fare *= ((NightService) this).getNightMultiplier();
            }

            return fare;
        }

        boolean supportsNightService() {
            return this instanceof NightService;
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 10.0;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 14.0;
        }

        @Override
        public double getNightMultiplier() {
            return 1.20;
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 18.0;
        }

        @Override
        public double getNightMultiplier() {
            return 1.20;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;

                case "SEDAN":
                    cab = new Sedan(km);
                    break;

                case "SUV":
                    cab = new SUV(km);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            if (time.equals("NIGHT") && !cab.supportsNightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(time);

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}