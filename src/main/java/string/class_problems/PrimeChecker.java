package string.class_problems;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean prime = n > 1;

        for (int i = 2; i <= n / i && prime; i++) {
            if (n % i == 0) {
                prime = false;
            }
        }

        if (prime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }

        sc.close();
    }
}