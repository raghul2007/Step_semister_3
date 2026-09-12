package main.java.string.class_problems;

import java.util.Scanner;
import java.util.Arrays;

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
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

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));

        scanner.close();
    }
}