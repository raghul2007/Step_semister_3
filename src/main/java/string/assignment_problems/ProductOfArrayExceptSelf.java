package string.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = prefix;

            prefix = prefix * nums[i];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * suffix;

            suffix = suffix * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println(
                "Product Except Self: " +
                Arrays.toString(result)
        );

        scanner.close();
    }
}