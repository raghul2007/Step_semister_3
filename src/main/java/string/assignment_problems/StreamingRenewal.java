package string.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {

    protected String name;
    protected LocalDate startDate;

    public Subscription(
            String name,
            LocalDate startDate) {

        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class BasicPlan extends Subscription {

    public BasicPlan(
            String name,
            LocalDate startDate) {

        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Subscription {

    public StandardPlan(
            String name,
            LocalDate startDate) {

        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Subscription {

    public PremiumPlan(
            String name,
            LocalDate startDate) {

        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            String name = sc.next();

            LocalDate startDate =
                LocalDate.parse(
                    sc.next()
                );

            Subscription subscription;

            if (type.equals("BASIC")) {

                subscription =
                    new BasicPlan(
                        name,
                        startDate
                    );

            } else if (type.equals("STANDARD")) {

                subscription =
                    new StandardPlan(
                        name,
                        startDate
                    );

            } else {

                subscription =
                    new PremiumPlan(
                        name,
                        startDate
                    );
            }

            System.out.println(
                name + ": " +
                subscription.getRenewalDate()
            );
        }

        sc.close();
    }
}