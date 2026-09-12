package string.class_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }

            int currentProfit = prices[i] - minimumPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);

        scanner.close();
    }
}