package self;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] arr) {
        return divide(arr);
    }

    private int[] divide(int[] arr) {
        if ( arr.length <= 1 ) {
            return arr;
        }

        int temp;
        int pivot = arr[0];

        int leftIndex = 1;
        int rightIndex = arr.length - 1;

        while ( leftIndex <= rightIndex ) {
            if ( arr[leftIndex] > pivot && arr[rightIndex] < pivot ) {
                temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            } else if ( arr[leftIndex] > pivot ) {
                rightIndex--;
            } else if ( arr[rightIndex] < pivot ) {
                leftIndex++;
            } else {
                rightIndex--;
                leftIndex++;
            }
        }

        arr[0] = arr[rightIndex];
        arr[rightIndex] = pivot;

        int[] left = new int[rightIndex];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        int[] right = new int[arr.length - rightIndex - 1];
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[left.length + i + 1];
        }

        left = divide(left);
        right = divide(right);

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if ( i < left.length ) {
                result[i] = left[i];
            } else if ( i == left.length ) {
                result[i] = arr[i];
            } else {
                result[i] = right[i - left.length - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(new int[]{7, 3, 8, 3, 6, 9, 4, 65, 89})));
    }
}
