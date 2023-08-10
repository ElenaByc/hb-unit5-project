/*
https://www.geeksforgeeks.org/insertion-sort/
Insertion Sort Algorithm

To sort an array of size N in ascending order iterate over the array
and compare the current element (key) to its predecessor,
if the key element is smaller than its predecessor,
compare it to the elements before.
Move the greater elements one position up to make space for the swapped element.

Complexity Analysis of Insertion Sort:
Time Complexity of Insertion Sort
The worst-case time complexity of the Insertion sort is O(N^2)
The average case time complexity of the Insertion sort is O(N^2)
The time complexity of the best case is O(N) - already sorted
Space Complexity of Insertion Sort
The auxiliary space complexity of Insertion Sort is O(1)

More challenging problem - Insertion Sort List
https://leetcode.com/problems/insertion-sort-list/
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 45, 1, 23, 12, 0, 2};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int temp;
        int key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                } else {
                    break;
                }
            }
        }
    }
}
