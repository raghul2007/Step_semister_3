package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in first array: ");
        int n1 = scanner.nextInt();

        int[] arr1 = new int[n1];

        System.out.println("Enter sorted elements of first array:");

        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter number of elements in second array: ");
        int n2 = scanner.nextInt();

        int[] arr2 = new int[n2];

        System.out.println("Enter sorted elements of second array:");

        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] result = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(result));

        scanner.close();
    }
}