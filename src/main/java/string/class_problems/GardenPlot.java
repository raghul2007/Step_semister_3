package string.class_problems;

import java.util.Scanner;

public class GardenPlot {

    abstract static class Plot {
        String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double calculateArea();

        abstract String getShape();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        String getShape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        double calculateArea() {
            return length * width;
        }

        @Override
        String getShape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        double calculateArea() {
            return 0.5 * base * height;
        }

        @Override
        String getShape() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    plot = new Circle(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    plot = new Rectangle(
                        owner, sc.nextDouble(), sc.nextDouble()
                    );
                    break;

                case "TRIANGLE":
                    plot = new Triangle(
                        owner, sc.nextDouble(), sc.nextDouble()
                    );
                    break;

                default:
                    throw new IllegalArgumentException("Invalid shape");
            }

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner, plot.getShape(), area
            );

            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}