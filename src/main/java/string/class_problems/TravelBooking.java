package string.class_problems;

import java.util.Scanner;

public class TravelBooking {

    abstract static class Booking {
        double distance;
        static final double BOOKING_FEE = 50.0;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double calculateBaseFare();

        final double calculateTotal() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {
        Bus(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return distance * 2.0;
        }
    }

    static class Train extends Booking {
        Train(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return distance * 1.5;
        }
    }

    static class Flight extends Booking {
        Flight(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return 2500 + distance * 4.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;

                case "TRAIN":
                    booking = new Train(distance);
                    break;

                case "FLIGHT":
                    booking = new Flight(distance);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf(
                "%s: %.2f%n", mode, booking.calculateTotal()
            );
        }

        sc.close();
    }
}