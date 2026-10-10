package string.assignment_problems;

import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    abstract static class Parcel {
        double weight;
        double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();

        double getInsurance() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance();
            }

            return 0.0;
        }

        double calculateTotal() {
            return calculateCharge() + getInsurance();
        }
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 40 + 10 * weight;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 80 + 15 * weight;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 40 + 10 * weight + 50;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;

                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;

                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}