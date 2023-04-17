package self;

import java.util.Arrays;

public class SelectionSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if ( min > arr[j] ) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sort(new int[]{7, 3, 8, 3, 6, 9, 4, 65, 89})));
    }
}
