package self;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] arr) {
        int temp;
        int target;

        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            target = i - 1;

            while ( target >= 0 ) {
                if ( arr[target] > temp ) {
                    arr[target+1] = arr[target];
                } else {
                    break;
                }
                target--;
            }
            arr[target+1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort selectionSort = new InsertionSort();
        System.out.println(Arrays.toString(selectionSort.sort(new int[]{7, 3, 8, 3, 6, 9, 4, 65, 89})));
    }
}
