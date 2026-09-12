package string.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    result.add(triplet);

                    left++;
                    right--;

                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        return result;
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

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Triplets:");

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        scanner.close();
    }
}