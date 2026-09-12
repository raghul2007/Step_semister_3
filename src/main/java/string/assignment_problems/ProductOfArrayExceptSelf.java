package string.assignment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int prefix = 1;

        // Left product
        for (int i = 0; i < n; i++) {

            answer[i] = prefix;

            prefix = prefix * nums[i];
        }

        int suffix = 1;

        // Right product
        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * suffix;

            suffix = suffix * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(
                Arrays.toString(result)
        );
    }
}