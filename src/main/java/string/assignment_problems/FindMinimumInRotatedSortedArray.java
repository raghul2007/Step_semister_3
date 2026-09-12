package string.assignment_problems;

public class FindMinimumInRotatedSortedArray {

    static int findMin(int[] nums) {

        int left = 0;

        int right = nums.length - 1;

        while (left < right) {

            // Already sorted
            if (nums[left] < nums[right]) {

                return nums[left];
            }

            int mid =
                    left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                // Minimum is on the right
                left = mid + 1;

            } else {

                // Minimum is on the left
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums =
                {4, 5, 6, 7, 0, 1, 2};

        int result = findMin(nums);

        System.out.println(
                "Minimum: " + result
        );
    }
}