package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {

            int newPosition = (i + k) % n;

            newArray[newPosition] = nums[i];
        }

        return newArray;
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

        System.out.print("Enter rotation count: ");
        int k = scanner.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(result));

        scanner.close();
    }
}