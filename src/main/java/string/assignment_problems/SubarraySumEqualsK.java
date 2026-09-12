package string.assignment_problems;

import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySum(
            int[] nums,
            int k) {

        HashMap<Integer, Integer> prefixCount =
                new HashMap<>();

        // Empty prefix
        prefixCount.put(0, 1);

        int currentSum = 0;

        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int required =
                    currentSum - k;

            if (prefixCount.containsKey(required)) {

                count +=
                        prefixCount.get(required);
            }

            prefixCount.put(
                    currentSum,
                    prefixCount.getOrDefault(
                            currentSum, 0
                    ) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};

        int k = 2;

        int result =
                subarraySum(nums, k);

        System.out.println(
                "Number of subarrays: " +
                result
        );
    }
}