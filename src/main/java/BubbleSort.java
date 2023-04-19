import java.util.Arrays;

public class BubbleSort {

    public int[] sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if ( arr[j] > arr[j+1] ) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sort = bubbleSort.sort(new int[]{7, 3, 78, 3, 4, 8, 10, 34});
        System.out.println(Arrays.toString(sort));
    }
}
