package string.assignment_problems;

import java.util.Scanner;

public class MovieTicketCounter {

    abstract static class Ticket {
        int count;
        static final double CONVENIENCE_FEE = 20.0;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getTicketPrice();

        final double calculateAmount() {
            return count * (getTicketPrice() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        @Override
        double getTicketPrice() {
            return 150.0;
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        @Override
        double getTicketPrice() {
            return 250.0;
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        @Override
        double getTicketPrice() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular(count);
                    break;

                case "PREMIUM":
                    ticket = new Premium(count);
                    break;

                case "RECLINER":
                    ticket = new Recliner(count);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }

            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}