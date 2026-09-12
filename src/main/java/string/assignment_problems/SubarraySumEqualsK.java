package string.assignment_problems;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixFrequency =
                new HashMap<>();

        prefixFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixFrequency.containsKey(requiredSum)) {
                count += prefixFrequency.get(requiredSum);
            }

            prefixFrequency.put(
                    currentSum,
                    prefixFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
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

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        int result = subarraySum(nums, k);

        System.out.println(
                "Number of Subarrays: " + result
        );

        scanner.close();
    }
}