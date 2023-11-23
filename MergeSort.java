import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12,8,14,4,6,33,2,27};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        myMergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart; // index into left subarray
        int j = rightStart; // index into right subarray
        int k = leftStart; // index into temp

        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left array if any
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements of right array if any
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged elements back into the original array
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }

    private static void myMergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) { // base case
            return;
        }
        int middle = (start + end) / 2; // The splitting step

        // Sort first and second halves
        myMergeSort(arr, temp, start, middle);
        myMergeSort(arr, temp, middle + 1, end);

        // Merge the sorted halves
        merge(arr, temp, start, middle, middle + 1, end);
    }
}

/*
Initial Array
[12, 8, 14, 4, 6, 33, 2, 27]

Step 1: Splitting the Array
First, the array is split into two halves until there are arrays that can't be split further (i.e., they have only one element).

[12, 8, 14, 4] and [6, 33, 2, 27]
Split further:
[12, 8] and [14, 4]
[6, 33] and [2, 27]
Split even further:
[12] [8] [14] [4]
[6] [33] [2] [27]
Step 2: Merging and Sorting
Now, we start merging them back together in a sorted order.

Merge [12] and [8] into [8, 12]
Merge [14] and [4] into [4, 14]
Merge [6] and [33] into [6, 33]
Merge [2] and [27] into [2, 27]
Now, merge these sorted arrays:

Merge [8, 12] and [4, 14] into [4, 8, 12, 14]
Merge [6, 33] and [2, 27] into [2, 6, 27, 33]
Step 3: Final Merge
Finally, merge the two sorted halves to get the sorted array.

Merge [4, 8, 12, 14] and [2, 6, 27, 33] into [2, 4, 6, 8, 12, 14, 27, 33]
Result
The final sorted array is [2, 4, 6, 8, 12, 14, 27, 33].
 */