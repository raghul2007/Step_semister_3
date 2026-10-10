package string.assignment_problems;

import java.util.Scanner;

public class ApplianceEnergyReport {

    interface SaverMode {
        double getSaverMultiplier();
    }

    abstract static class Appliance {
        double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPower();

        boolean supportsSaver() {
            return this instanceof SaverMode;
        }

        double calculateUnits(boolean saver) {
            double units = getPower() * hours / 1000.0;

            if (saver) {
                units *= ((SaverMode) this).getSaverMultiplier();
            }

            return units;
        }

        double calculateCost(double units) {
            return units * 8.0;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 150.0;
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 1500.0;
        }

        @Override
        public double getSaverMultiplier() {
            return 0.75;
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 100.0;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 500.0;
        }

        @Override
        public double getSaverMultiplier() {
            return 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AC(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid appliance");
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}