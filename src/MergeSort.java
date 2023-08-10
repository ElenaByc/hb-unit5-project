import java.util.Arrays;

/*
https://www.geeksforgeeks.org/merge-sort/
Merge sort is defined as a sorting algorithm that works by dividing an array into
smaller subarrays, sorting each subarray, and then merging the sorted subarrays
back together to form the final sorted array.

In simple terms, we can say that the process of merge sort is to divide the array
into two halves, sort each half, and then merge the sorted halves back together.
This process is repeated until the entire array is sorted.

Auxiliary Space: O(N), In merge sort all elements are copied into an auxiliary array.
So N auxiliary space is required for merge sort.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 45, 1, 23, 12, 0, 2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[m + 1 + j];


        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
