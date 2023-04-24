package self;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] arr) {
        return divide(arr);
    }

    public int[] divide(int[] arr) {
        if ( arr.length == 1) {
            return arr;
        }

        int[] left = new int[(arr.length / 2)];
        int[] right = new int[arr.length - (arr.length / 2)];

        for (int i = 0; i < arr.length; i++) {
            if ( i < (arr.length / 2) ) {
                left[i] = arr[i];
            } else {
                right[i - (arr.length / 2)] = arr[i];
            }
        }

        left = divide(left);
        right = divide(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;

        int[] merged = new int[left.length + right.length];

        for (int i = 0; i < merged.length; i++) {
            if ( left[leftIndex] <= right[rightIndex] ) {
                merged[i] = left[leftIndex];
                leftIndex++;
                if ( leftIndex == left.length ) {
                    for (int j = i+1; j < merged.length; j++) {
                        merged[j] = right[rightIndex];
                        rightIndex++;
                    }
                    break;
                }
            } else {
                merged[i] = right[rightIndex];
                rightIndex++;
                if ( rightIndex == right.length ) {
                    for (int j = i+1; j < merged.length; j++) {
                        merged[j] = left[leftIndex];
                        leftIndex++;
                    }
                    break;
                }
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        MergeSort selectionSort = new MergeSort();
        System.out.println(Arrays.toString(selectionSort.sort(new int[]{7, 3, 8, 3, 6, 9, 4, 65, 89})));
    }
}
